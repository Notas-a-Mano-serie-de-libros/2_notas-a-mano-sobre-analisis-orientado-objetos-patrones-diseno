<h1 style="text-align:center;">
  <strong> Ejemplo: Relación de Asociación / Dependencia</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
En este ejemplo se modela la relación entre las clases <b>ServicioReporte</b> y <b>Reporte</b>.
El objetivo es definir qué clase debe asumir la responsabilidad de crear los objetos <code>Reporte</code> cuando se requiere generar información sobre las ventas totales y mensuales de una empresa.
</p>

<p style="text-align:justify;">
Siguiendo el principio <b>Creator</b> de los patrones <b>GRASP</b>, la clase <code>ServicioReporte</code> es la responsable de crear instancias de <code>Reporte</code>, ya que:
</p>

<ul style="text-align:justify;">
  <li><code>ServicioReporte</code> <b>utiliza</b> directamente los objetos <code>Reporte</code> en su proceso de generación.</li>
  <li>Posee los <b>datos necesarios</b> para inicializar el contenido de cada reporte (ventas totales y ventas del mes).</li>
  <li>Existe una relación de <b>dependencia funcional</b> entre ambas clases: el servicio depende del reporte para cumplir su objetivo.</li>
</ul>

<p style="text-align:justify;">
De esta manera, el diseño distribuye las responsabilidades de forma coherente, concentrando la creación de los objetos <code>Reporte</code> en el lugar donde su uso es más natural y semánticamente consistente.
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
        ▶️ <a href="#codigo-servicioreporte-java"><b>ServicioReporte.java</b></a><br/>
        ▶️ <a href="#codigo-reporte-java"><b>Reporte.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
El siguiente diagrama UML muestra una relación de <b>asociación / dependencia</b> entre <code>ServicioReporte</code> y <code>Reporte</code>.
La clase <code>ServicioReporte</code> genera instancias de <code>Reporte</code> para construir el contenido del informe, mientras que <code>Reporte</code> encapsula la información textual y las operaciones que permiten modificar su contenido.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/creador_asociacion_dependencia.png"
       width="70%" height="auto" alt="Diagrama UML de asociación/dependencia entre ServicioReporte y Reporte"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Relación de asociación y dependencia entre <code>ServicioReporte</code> y <code>Reporte</code>.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.creador.ejemplo_asociacion_dependencia;
    
    public class Cliente {
    
        public static void main(String[] args) {
            ServicioReporte servicioReporte = new ServicioReporte();
            Reporte reporte = servicioReporte.generarReporteVentas(100, 120);
        }
    }
    ```
