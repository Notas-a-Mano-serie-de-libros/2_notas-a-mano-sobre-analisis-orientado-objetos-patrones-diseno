<h1 style="text-align:center;">
  <strong> Ejemplo: Relación de Inicialización</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
En este ejemplo se modela la relación entre las clases <b>Configuración</b> y <b>Conexión</b> dentro de un sistema que gestiona la comunicación con un servidor externo.
Cada instancia de <code>Configuración</code> contiene los parámetros necesarios —como el host, usuario y contraseña— para inicializar una nueva conexión.
El sistema debe ser capaz de crear y establecer conexiones de forma controlada, asegurando la correcta configuración antes de su uso.
</p>

<p style="text-align:justify;">
De acuerdo con el principio <b>Creator</b> de los patrones <b>GRASP</b>, la clase <code>Configuración</code> es responsable de crear instancias de <code>Conexión</code>,
ya que posee todos los datos requeridos para su inicialización. Esta relación se conoce como una <b>relación de inicialización</b>,
pues el objeto creador dispone de la información necesaria para configurar el nuevo objeto de manera coherente y completa.
</p>

<p style="text-align:justify;">
Este enfoque promueve un diseño más consistente, al centralizar la lógica de creación en la clase que conoce el contexto de inicialización,
evitando duplicación de responsabilidades y posibles errores de configuración en otras partes del sistema.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Cliente</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Clases principales</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-cliente-java"><b>Cliente.java</b></a>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-configuracion-java"><b>Configuracion.java</b></a><br/>
        ▶️ <a href="#codigo-conexion-java"><b>Conexion.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
El siguiente diagrama UML muestra la relación de <b>inicialización</b> entre las clases <code>Configuración</code> y <code>Conexión</code>.
La clase <code>Configuración</code> encapsula los parámetros de acceso y proporciona un método <code>crearConexion()</code> que instancia y devuelve un nuevo objeto de tipo <code>Conexión</code> configurado correctamente.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/creador_inicializacion.png"
       width="70%" height="auto" alt="Diagrama UML de relación de inicialización entre Configuración y Conexión"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Relación de inicialización entre <code>Configuración</code> y <code>Conexión</code>.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.creador.ejemplo_inicializacion;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Configuracion configuracion = new Configuracion("host", "usuario", "1234");
            configuracion.crearConexion();
        }
    }
    ```
