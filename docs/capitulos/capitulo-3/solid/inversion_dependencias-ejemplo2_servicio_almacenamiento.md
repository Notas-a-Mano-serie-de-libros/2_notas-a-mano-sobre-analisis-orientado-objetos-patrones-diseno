<h1 style="text-align:center;">
  <strong> Ejemplo práctico: Servicio de Almacenamiento</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita diseñar una solución que permita <b>persistir información</b> mediante diferentes mecanismos,
como el almacenamiento en <b>disco local</b>, en una <b>base de datos</b> o en un <b>sistema de almacenamiento en la nube</b>.
El sistema debe poder ampliar sus métodos de persistencia sin alterar las clases principales del proyecto.
</p>

<p style="text-align:justify;">
En su versión inicial, la clase principal encargada de la gestión —<code>ServicioAlmacenamiento</code>— dependía directamente
de las implementaciones concretas (<code>AlmacenamientoArchivo</code>, <code>AlmacenamientoDB</code> y <code>AlmacenamientoNube</code>).
Esto provocaba un fuerte acoplamiento, haciendo que cualquier cambio o nueva opción de almacenamiento
requiriera modificar el código existente.
Este diseño viola el <b>Principio de Inversión de Dependencias (DIP)</b>.
</p>

<p style="text-align:justify;">
El reto es refactorizar el sistema para que las clases de alto nivel dependan de <b>abstracciones</b>
(en lugar de implementaciones concretas), garantizando una arquitectura más flexible, extensible y mantenible.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar DIP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando DIP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En esta versión, la clase <code>ServicioAlmacenamiento</code> crea e invoca directamente los servicios
          concretos de almacenamiento (<code>Archivo</code>, <code>Base de datos</code>, <code>Nube</code>).
          Este diseño impide reutilizar o intercambiar las implementaciones sin modificar la clase principal,
          generando un <b>acoplamiento fuerte</b> y reduciendo la escalabilidad del sistema.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-servicios-almacenamientoarchivo-java"><b>AlmacenamientoArchivo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-servicios-almacenamientodb-java"><b>AlmacenamientoDB.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-servicios-almacenamientonube-java"><b>AlmacenamientoNube.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-servicioalmacenamiento-java"><b>ServicioAlmacenamiento.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión mejorada, se introduce la <b>abstracción</b> <code>ServicioAlmacenamiento</code>,
          la cual define el contrato que deben seguir todas las clases concretas.
          Los diferentes tipos de almacenamiento implementan esta interfaz y la clase <code>Cliente</code>
          depende exclusivamente de ella, no de las implementaciones.
          Esto permite <b>inyectar dependencias</b> de forma dinámica sin modificar el código existente.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-servicioalmacenamiento-java"><b>ServicioAlmacenamiento.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-servicios-almacenamientoarchivo-java"><b>AlmacenamientoArchivo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-servicios-almacenamientodb-java"><b>AlmacenamientoDB.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-servicios-almacenamientonube-java"><b>AlmacenamientoNube.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Inversión de Dependencias</strong></h2>

<p style="text-align:justify;">
En el diseño original, la clase <code>ServicioAlmacenamiento</code> depende directamente de las clases concretas
<code>AlmacenamientoArchivo</code>, <code>AlmacenamientoDB</code> y <code>AlmacenamientoNube</code>.
Cada vez que se desea incorporar un nuevo tipo de persistencia (por ejemplo, <em>almacenamiento distribuido</em>),
es necesario modificar esta clase, lo que viola el principio DIP.
</p>

<p style="text-align:justify;">
Además, el <code>Cliente</code> también se ve afectado por este acoplamiento, ya que debe conocer qué implementación concreta utilizar.
El resultado es un sistema poco flexible, difícil de probar y de mantener.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/inversion_dependencias/dip_ejemplo2_mal.png"
       width="75%" height="auto" alt="Modelo UML sin aplicar DIP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño inicial acoplado a implementaciones concretas de almacenamiento.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.sin_aplicar_principio;
    
    public class Cliente {
    
        public static void main(String[] args) {
            ServicioAlmacenamiento servicio = new ServicioAlmacenamiento();
    
            String mensaje = "Hola mundo";
            servicio.guardarEnArchivo(mensaje);
            servicio.guardarEnDB(mensaje);
            servicio.guardarEnNube(mensaje);
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio;
    
    import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios.AlmacenamientoArchivo;
    import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios.AlmacenamientoDB;
    import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios.AlmacenamientoNube;
    
    public class Cliente {
    
        public static void main(String[] args) {
            ServicioAlmacenamiento servicioArchivo = new AlmacenamientoArchivo();
            ServicioAlmacenamiento servicioDB = new AlmacenamientoDB();
            ServicioAlmacenamiento servicioNube = new AlmacenamientoNube();
    
            String mensaje = "Hola mundo";
            servicioArchivo.guardar(mensaje);
            servicioDB.guardar(mensaje);
            servicioNube.guardar(mensaje);
        }
    }
    ```
