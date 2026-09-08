<h1 style="text-align:center;">
  <strong> Ejemplo: Relación de Composición</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
En este ejemplo se modela la relación entre las clases <b>Vehículo</b> y <b>Motor</b> dentro de un sistema de gestión automotriz.
Cada vehículo posee un motor que forma parte integral de su estructura. Si el vehículo deja de existir, su motor también deja de hacerlo.
Este vínculo refleja una <b>relación de composición</b>, donde el ciclo de vida del objeto contenido depende completamente del objeto contenedor.
</p>

<p style="text-align:justify;">
Siguiendo el principio <b>Creator</b> de los patrones <b>GRASP</b>, la clase <code>Vehiculo</code> es la responsable de crear instancias de <code>Motor</code>, ya que:
</p>

<ul style="text-align:justify;">
  <li><code>Vehiculo</code> <b>contiene</b> directamente a <code>Motor</code> como parte de su estructura interna.</li>
  <li>Existe una <b>relación de fuerte dependencia</b> entre ambos objetos: el motor no puede existir sin el vehículo que lo contiene.</li>
  <li>El vehículo <b>posee toda la información necesaria</b> para inicializar correctamente su motor al momento de la creación.</li>
</ul>

<p style="text-align:justify;">
Este tipo de relación garantiza un <b>alto grado de cohesión</b> dentro de la clase contenedora y evita acoplamientos innecesarios con otras partes del sistema, promoviendo un diseño claro y de responsabilidad única.
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
        ▶️ <a href="#codigo-vehiculo-java"><b>Vehiculo.java</b></a><br/>
        ▶️ <a href="#codigo-motor-java"><b>Motor.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
El siguiente diagrama UML representa la relación de <b>composición</b> entre las clases <code>Vehiculo</code> y <code>Motor</code>.
La composición indica que el <code>Motor</code> es una parte esencial del <code>Vehiculo</code> y que su existencia depende completamente del objeto que lo contiene.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/creador_composicion.png"
       width="70%" height="auto" alt="Diagrama UML de relación de composición entre Vehículo y Motor"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Relación de composición entre <code>Vehículo</code> y <code>Motor</code>.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.creador.ejemplo_composicion;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Vehiculo automovil = new Vehiculo("2017", "Chevrolet", "MYU321", 100, "Motor Básico");
        }
    }
    ```
