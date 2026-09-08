<h1 style="text-align:center;">
  <strong>🏗️ Principio GRASP: Creator (Creador)</strong>
</h1>

<hr/>

<h2><strong>📘 Definición general</strong></h2>

<p style="text-align:justify;">
El principio <b>Creator</b> establece una guía clara para decidir <b>qué clase debe ser responsable de crear instancias de otras clases</b>.  
Su propósito es lograr una <b>distribución adecuada de responsabilidades</b> en el sistema, promoviendo un diseño con bajo acoplamiento y alta cohesión.
</p>

<p style="text-align:justify;">
En términos simples, una clase <em>A</em> debe ser responsable de crear instancias de una clase <em>B</em> si se cumple alguna de las siguientes condiciones:
</p>

<ul style="text-align:justify;">
  <li><b>A contiene a B</b> o agrega instancias de B como parte de su estructura interna.</li>
  <li><b>A utiliza a B</b> de manera estrecha en sus operaciones o su ciclo de vida depende de B.</li>
  <li><b>A tiene los datos necesarios</b> para inicializar adecuadamente a B.</li>
  <li><b>A registra, coordina o controla</b> objetos de tipo B en un contexto específico.</li>
</ul>

<p style="text-align:justify;">
En esencia, el principio busca que la clase que más "conoce" sobre la creación o el uso de un objeto sea la responsable de instanciarlo, evitando dependencias innecesarias entre clases.
</p>

<hr/>

<h2><strong>🧩 Motivación</strong></h2>

<p style="text-align:justify;">
En el desarrollo orientado a objetos, es habitual que diferentes componentes del sistema necesiten crear instancias de otros objetos.  
Sin embargo, si esta creación se distribuye de forma arbitraria, puede generar un <b>alto acoplamiento</b> entre clases y dificultar el mantenimiento del sistema.
</p>

<p style="text-align:justify;">
El principio <b>Creator</b> proporciona una solución estructurada: <b>delegar la creación al objeto que tiene la relación más natural con el creado</b>.  
De esta manera, el conocimiento del proceso de construcción se concentra en un solo lugar, manteniendo la coherencia y evitando duplicación de lógica.
</p>

<p style="text-align:justify;">
Por ejemplo, si una clase <code>Pedido</code> contiene una colección de <code>Producto</code>, tiene sentido que <code>Pedido</code> sea responsable de crear nuevas instancias de <code>Producto</code> cuando se agregan al pedido.
</p>

<hr/>

<h2><strong>⚙️ Aplicación práctica</strong></h2>

<p style="text-align:justify;">
La aplicación del principio <b>Creator</b> permite diseñar sistemas en los cuales cada clase asume la responsabilidad de creación solo de aquellos objetos con los que tiene una relación directa.  
Esto reduce el acoplamiento innecesario y facilita el mantenimiento, ya que el conocimiento sobre la creación de objetos se mantiene encapsulado.
</p>

<p style="text-align:justify;">
A continuación, se listan algunas situaciones típicas en las que puede aplicarse:
</p>

<ul style="text-align:justify;">
  <li>Cuando una clase <b>agrega o compone</b> objetos de otro tipo (por ejemplo, una <code>Factura</code> que crea sus <code>Detalles</code>).</li>
  <li>Cuando una clase <b>usa frecuentemente</b> a otra y está estrechamente acoplada a su ciclo de vida.</li>
  <li>Cuando una clase <b>posee la información necesaria</b> para inicializar correctamente la nueva instancia.</li>
</ul>

<hr/>

<h2><strong>💡 Beneficios</strong></h2>

<ul style="text-align:justify;">
  <li><b>Disminuye el acoplamiento:</b> la creación de objetos se asigna al componente que ya está relacionado con ellos.</li>
  <li><b>Mejora la cohesión:</b> los objetos se crean dentro del contexto donde realmente se necesitan, reforzando su propósito funcional.</li>
  <li><b>Centraliza la lógica de construcción:</b> evita duplicación de código y facilita cambios futuros en la forma de creación.</li>
  <li><b>Fomenta el encapsulamiento:</b> el resto del sistema no necesita conocer los detalles internos del proceso de creación.</li>
</ul>

<hr/>

<h2><strong>⚠️ Limitaciones</strong></h2>

<ul style="text-align:justify;">
  <li>Si se abusa del principio, puede generar clases con demasiadas responsabilidades, rompiendo el principio de responsabilidad única (SRP).</li>
  <li>En sistemas grandes, puede ser necesario complementar <b>Creator</b> con patrones como <b>Factory Method</b> o <b>Abstract Factory</b> para manejar la complejidad de la creación.</li>
  <li>La delegación de la creación debe ser justificada por la relación conceptual entre las clases; de lo contrario, se corre el riesgo de un acoplamiento innecesario.</li>
</ul>

<hr/>

<h2><strong>📖 Conclusión</strong></h2>

<p style="text-align:justify;">
El principio <b>Creator</b> es fundamental para distribuir responsabilidades de forma lógica y mantener un diseño coherente.  
Cuando se aplica correctamente, asegura que la creación de objetos se delegue al componente más cercano al contexto de uso, evitando dependencias innecesarias y facilitando la evolución del sistema.
</p>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>