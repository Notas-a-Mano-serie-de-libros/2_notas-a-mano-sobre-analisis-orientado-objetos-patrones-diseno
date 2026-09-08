<h1 style="text-align:center;">
  <strong> Experto en Información</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición</strong></h2>

<p style="text-align:justify;">
El principio <b>Experto en Información</b> establece que la responsabilidad de realizar una tarea debe asignarse a la clase que posee la información necesaria para llevarla a cabo.
En otras palabras, una clase debe encargarse de ejecutar aquellas operaciones que dependen directamente de los datos que controla o administra.
</p>

<p style="text-align:justify;">
Este principio busca promover un diseño más <b>cohesionado</b> y <b>autónomo</b>, evitando que otras clases dependan innecesariamente de la estructura interna o los datos de un objeto.
Cuando la responsabilidad recae en el experto natural —la entidad que “sabe” cómo hacerlo—, se reduce el acoplamiento, se mejora la reutilización y se facilita la evolución del sistema.
</p>

<p style="text-align:justify;">
En términos prácticos, aplicar el principio <b>Experto en Información</b> implica analizar qué clase tiene el conocimiento suficiente sobre los datos requeridos para ejecutar una acción específica.
Esa clase, y no otra, debe implementar el comportamiento, garantizando así que el modelo mantenga la coherencia entre <b>datos</b> y <b>comportamiento</b>.
</p>

<hr/>

<h2><strong> Propósito</strong></h2>

<p style="text-align:justify;">
El objetivo fundamental de este principio es asignar responsabilidades de manera racional y estructurada,
de modo que cada componente del sistema sea responsable de aquello que conoce mejor.
Esto no solo mejora la mantenibilidad, sino que también facilita la comprensión del código,
ya que las operaciones se encuentran naturalmente cerca de los datos que manipulan.
</p>

<hr/>

<h2><strong> Beneficios de aplicar el principio</strong></h2>

<ul style="text-align:justify;">
  <li><b>Alta cohesión:</b> Cada clase agrupa los datos y comportamientos relacionados con una misma responsabilidad.</li>
  <li><b>Bajo acoplamiento:</b> Otras clases no necesitan acceder a los detalles internos de la clase experta.</li>
  <li><b>Reutilización:</b> Las clases se vuelven más independientes y reutilizables al concentrar su propia lógica de negocio.</li>
  <li><b>Claridad conceptual:</b> Facilita la lectura y el mantenimiento del código, ya que las operaciones residen donde tienen sentido semántico.</li>
</ul>

<hr/>

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Registro de Inventario** | Se solicita diseñar un sistema que gestione el inventario de productos de una tienda. La aplicación debe permitir calcular tanto el costo unitario de cada producto como el costo total del inventario, y posibilitar la incorporación de nuevos lotes de productos conforme ingresen al almacén. Cada registro en el inventario debe reflejar la cantidad, el precio y el valor acumulado de los productos disponibles. | [Ver diagramas y desplegar el código](experto_informacion-ejemplo_inventario.md) |

## Ejemplos y diagramas UML

### 1. Registro de Inventario

Se solicita diseñar un sistema que gestione el inventario de productos de una tienda. La aplicación debe permitir calcular tanto el costo unitario de cada producto como el costo total del inventario, y posibilitar la incorporación de nuevos lotes de productos conforme ingresen al almacén. Cada registro en el inventario debe reflejar la cantidad, el precio y el valor acumulado de los productos disponibles.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/experto_informacion_ejemplo.png" alt="Diagrama UML de Registro de Inventario">
  <figcaption><strong>Modelo UML.</strong> Registro de Inventario.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](experto_informacion-ejemplo_inventario.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | Una operación se asigna lejos de los datos necesarios para realizarla. |
| **Escenario de aplicación** | Cálculos de inventario, totales, disponibilidad o reglas sobre el propio estado. |
| **Ventaja principal** | Mejora encapsulamiento y cohesión al mantener juntos conocimiento y comportamiento. |
| **Desventaja o precaución** | Las responsabilidades técnicas que no pertenecen al dominio pueden sobrecargar la entidad. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/experto_informacion/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
