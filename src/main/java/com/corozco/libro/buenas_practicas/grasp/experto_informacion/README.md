<h1 style="text-align:center;">
  <strong>🧠 Experto en Información</strong>
</h1>

<hr/>

<h2><strong>📘 Definición</strong></h2>

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

<h2><strong>🎯 Propósito</strong></h2>

<p style="text-align:justify;">
El objetivo fundamental de este principio es asignar responsabilidades de manera racional y estructurada,  
de modo que cada componente del sistema sea responsable de aquello que conoce mejor.  
Esto no solo mejora la mantenibilidad, sino que también facilita la comprensión del código,  
ya que las operaciones se encuentran naturalmente cerca de los datos que manipulan.
</p>

<hr/>

<h2><strong>💡 Beneficios de aplicar el principio</strong></h2>

<ul style="text-align:justify;">
  <li><b>Alta cohesión:</b> Cada clase agrupa los datos y comportamientos relacionados con una misma responsabilidad.</li>
  <li><b>Bajo acoplamiento:</b> Otras clases no necesitan acceder a los detalles internos de la clase experta.</li>
  <li><b>Reutilización:</b> Las clases se vuelven más independientes y reutilizables al concentrar su propia lógica de negocio.</li>
  <li><b>Claridad conceptual:</b> Facilita la lectura y el mantenimiento del código, ya que las operaciones residen donde tienen sentido semántico.</li>
</ul>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>