<h1 style="text-align:center;">
  <strong> Ejemplo práctico: Solicitudes Administrativas</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita diseñar un módulo que permita a los estudiantes de una universidad enviar <b>solicitudes académicas</b> a la vicedecanatura.
El sistema debe procesar tres tipos de solicitudes principales: <b>cancelación</b>, <b>homologación</b> y <b>validación</b> de cursos.
Cada una de ellas requiere un tratamiento distinto por parte del área administrativa.
</p>

<p style="text-align:justify;">
En la primera versión del sistema, todas las solicitudes fueron gestionadas dentro de una misma clase,
utilizando estructuras condicionales (<code>if</code>/<code>switch</code>) para diferenciar su tipo.
Aunque funcional, este diseño <b>viola el Principio Abierto/Cerrado (OCP)</b>, ya que cada vez que se añade una nueva solicitud
(por ejemplo, una <em>solicitud de revisión de nota</em> o de <em>transferencia interna</em>), es necesario <b>modificar el código existente</b>.
</p>

<p style="text-align:justify;">
El reto consiste en rediseñar el sistema de forma que pueda incorporar nuevos tipos de solicitud
<b>sin alterar las clases existentes</b>, garantizando una arquitectura más estable, extensible y mantenible.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar OCP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando OCP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En esta versión inicial, la clase <code>Cliente</code> crea las solicitudes y las envía directamente a la <code>Vicedecanatura</code>,
          que se encarga de procesarlas mediante una estructura condicional que evalúa el <code>TipoSolicitud</code>.
          Esto genera <b>alto acoplamiento</b> y dificulta la incorporación de nuevas solicitudes.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-tiposolicitud-java"><b>TipoSolicitud.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-vicedecanatura-java"><b>Vicedecanatura.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión refactorizada, se define una <b>interfaz abstracta</b> <code>Solicitud</code>,
          de la cual heredan las clases <code>SolicitudCancelacion</code>, <code>SolicitudHomologacion</code> y <code>SolicitudValidacion</code>.
          Cada tipo de solicitud implementa su propio método <code>procesar()</code>,
          lo que permite a la <code>Vicedecanatura</code> tratar todas las solicitudes de manera uniforme mediante polimorfismo.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-solicitud-solicitud-java"><b>Solicitud.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-solicitud-solicitudcancelacion-java"><b>SolicitudCancelacion.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-solicitud-solicitudhomologacion-java"><b>SolicitudHomologacion.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-solicitud-solicitudvalidacion-java"><b>SolicitudValidacion.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-vicedecanatura-java"><b>Vicedecanatura.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Abierto/Cerrado</strong></h2>

<p style="text-align:justify;">
En este diseño, la <code>Vicedecanatura</code> recibe diferentes tipos de solicitudes, pero depende directamente del enumerado <code>TipoSolicitud</code>
para determinar cómo procesar cada una.
Esto implica una fuerte dependencia entre las clases y un flujo de control rígido.
</p>

<p style="text-align:justify;">
Si se desea incorporar una nueva solicitud, el desarrollador debe modificar tanto la enumeración <code>TipoSolicitud</code>
como el método de procesamiento de la <code>Vicedecanatura</code>,
lo que implica alterar código que ya fue probado y desplegado, violando el OCP.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/abierto_cerrado/ocp_ejemplo2_mal.png"
       width="75%" height="auto" alt="Modelo UML sin aplicar el OCP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño inicial con condicionales centralizadas y alta dependencia entre clases.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.sin_aplicar_principio;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Vicedecanatura vicedecanatura = new Vicedecanatura();
            vicedecanatura.realizarSolicitud(TipoSolicitud.HOMOLOGACION);
            vicedecanatura.realizarSolicitud(TipoSolicitud.VALIDACION);
            vicedecanatura.realizarSolicitud(TipoSolicitud.CANCELACION);
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio;
    
    import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.Solicitud;
    import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.SolicitudCancelacion;
    import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.SolicitudHomologacion;
    import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.SolicitudValidacion;
    
    public class Cliente {
        public static void main(String[] args) {
            Vicedecanatura vicedecanatura = new Vicedecanatura();
    
            Solicitud solicitudHomologacion = new SolicitudHomologacion();
            Solicitud solicitudCancelacion = new SolicitudCancelacion();
            Solicitud solicitudValidacion = new SolicitudValidacion();
    
            vicedecanatura.realizarSolicitud(solicitudHomologacion);
            vicedecanatura.realizarSolicitud(solicitudCancelacion);
            vicedecanatura.realizarSolicitud(solicitudValidacion);
        }
    }
    ```
