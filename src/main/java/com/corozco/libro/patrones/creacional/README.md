<h1 style="text-align: center;">
<strong>Patrones Creacionales</strong><br/>
<strong>Abstracción del proceso de construcción de objetos</strong>
</h1>

<p style="text-align: justify;">
Los <b>patrones creacionales</b> proporcionan mecanismos avanzados para <b>abstraer y estandarizar la creación de objetos</b> dentro de un sistema orientado a objetos.  
Su objetivo principal es <b>desacoplar la lógica de construcción</b> de las clases concretas, de modo que el cliente no dependa de cómo los objetos son creados, configurados o representados internamente.  
Gracias a ello, el sistema se vuelve <b>más flexible, extensible y mantenible</b>, especialmente cuando la creación de objetos implica estructuras complejas o dependencias múltiples.
</p>

---

<h2>🏗️ <strong>Definición</strong></h2>

<p style="text-align: justify;">
Los patrones creacionales se enfocan en <b>ocultar los detalles de instanciación</b> y en <b>delegar la creación de objetos</b> a estructuras especializadas.  
Esto evita que el código cliente dependa de clases concretas y permite que la lógica de creación sea reutilizable y configurable.  
En otras palabras, el cliente solicita un objeto sin conocer su implementación exacta, recibiendo siempre una instancia válida y consistente.
</p>

<p style="text-align: justify;">
Estos patrones se rigen bajo tres principios fundamentales:
</p>

<ul style="text-align: justify;">
  <li>🔒 <b>Encapsular la estructura interna</b> de los objetos creados, aislando los detalles de su composición.</li>
  <li>🎭 <b>Ocultar los mecanismos de instanciación</b> al cliente, ofreciendo interfaces o constructores abstractos.</li>
  <li>🧩 <b>Favorecer la generalidad y reutilización</b> de las soluciones, haciendo posible extender tipos sin modificar código existente.</li>
</ul>

<p style="text-align: justify;">
Como resultado, los patrones creacionales simplifican el diseño, mejoran la mantenibilidad y promueven la coherencia en la forma en que las aplicaciones generan nuevas estructuras.  
Esto libera al desarrollador de las preocupaciones sobre cómo instanciar correctamente un objeto, permitiéndole centrarse en la <b>lógica de negocio</b>.
</p>

---

<h2>⚙️ <strong>Importancia</strong></h2>

<p style="text-align: justify;">
En la práctica, los sistemas grandes suelen requerir la creación dinámica de objetos que cambian con el tiempo o en función del contexto.  
Si la construcción de estos objetos no se abstrae, se introduce un fuerte <b>acoplamiento</b> entre el cliente y las clases concretas, lo cual complica las modificaciones futuras.  
Los patrones creacionales <b>eliminan este problema</b> al encapsular la lógica de creación dentro de componentes especializados, garantizando que los cambios en la forma de construir un objeto no afecten al resto del sistema.
</p>

<p style="text-align: justify;">
De este modo, los patrones creacionales contribuyen a:
</p>

<ul style="text-align: justify;">
  <li>🧠 <b>Reducir el acoplamiento</b> entre el código cliente y las implementaciones concretas.</li>
  <li>🔁 <b>Reutilizar la lógica de construcción</b> en diferentes contextos sin duplicación.</li>
  <li>⚙️ <b>Establecer una arquitectura flexible</b> para crear objetos complejos mediante composición o delegación.</li>
  <li>📦 <b>Facilitar la configuración y extensión</b> de nuevas familias de productos sin alterar el código existente.</li>
</ul>

<p style="text-align: justify;">
En definitiva, su uso garantiza que el proceso de construcción sea <b>escalable, claro y consistente</b>, lo cual resulta esencial para proyectos grandes y de larga duración.
</p>

---

<h2>📚 <strong>Listado de patrones creacionales</strong></h2>

<p style="text-align: justify;">
La siguiente tabla presenta los principales patrones creacionales del GoF, su propósito y la descripción de su utilidad:
</p>

<table>
  <thead>
    <tr>
      <th style="text-align:center;">Patrón</th>
      <th style="text-align:center;">Nombre en español</th>
      <th style="text-align:center;">Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:center;"><a href="./singleton/README.md"><b>Singleton</b></a></td>
      <td style="text-align:center;">Instancia Única</td>
      <td style="text-align:justify;">Garantiza que una clase tenga una única instancia accesible globalmente y proporciona un punto de acceso controlado a ella.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./prototype/README.md"><b>Prototype</b></a></td>
      <td style="text-align:center;">Prototipo</td>
      <td style="text-align:justify;">Permite crear nuevos objetos copiando instancias existentes, evitando la dependencia directa de sus constructores.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./builder/README.md"><b>Builder</b></a></td>
      <td style="text-align:center;">Constructor</td>
      <td style="text-align:justify;">Separa la construcción de un objeto complejo de su representación, permitiendo construirlo paso a paso.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./factory/README.md"><b>Factory Method</b></a></td>
      <td style="text-align:center;">Método Fábrica</td>
      <td style="text-align:justify;">Define una interfaz para crear objetos, pero delega la decisión de instanciación a las subclases concretas.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./abstract_factory/README.md"><b>Abstract Factory</b></a></td>
      <td style="text-align:center;">Fábrica Abstracta</td>
      <td style="text-align:justify;">Proporciona una interfaz para crear familias de objetos relacionados sin especificar sus clases concretas.</td>
    </tr>
  </tbody>
</table>

---

<h2>🧠 <strong>Conceptos clave</strong></h2>

<h3>🔹 Desacoplamiento de la creación</h3>
<p style="text-align: justify;">
Los patrones creacionales aíslan el proceso de construcción, reduciendo la dependencia entre el código cliente y las clases que instancian los objetos.
</p>

<h3>🔹 Reutilización de lógica</h3>
<p style="text-align: justify;">
La lógica de creación se convierte en un <b>componente reutilizable</b> que puede adaptarse a distintos contextos sin duplicación de código.
</p>

<h3>🔹 Extensibilidad controlada</h3>
<p style="text-align: justify;">
El uso de fábricas y constructores abstractos facilita la incorporación de nuevos tipos de productos sin alterar la estructura base.
</p>

---

<h2>🚀 <strong>Objetivos de aprendizaje</strong></h2>

<p style="text-align: justify;">
Al finalizar este módulo, el lector será capaz de:
</p>

<ol style="text-align: justify;">
  <li><b>Comprender</b> las diferencias entre los principales patrones creacionales del GoF.</li>
  <li><b>Aplicar</b> correctamente cada patrón según el tipo de objeto o la complejidad de su creación.</li>
  <li><b>Diseñar</b> arquitecturas que encapsulen la lógica de instanciación, mejorando el desacoplamiento.</li>
  <li><b>Reutilizar</b> constructores, prototipos y fábricas para generar familias de productos consistentes.</li>
  <li><b>Evaluar</b> el impacto de cada enfoque en la flexibilidad y mantenibilidad del sistema.</li>
</ol>

---

<h2>📎 <strong>Referencia</strong></h2>

<p style="text-align: justify;">
Este material forma parte del <b>Bloque II – Patrones de diseño orientado a objetos</b> del libro  
<i><b>Notas a mano sobre análisis orientado a objetos y patrones de diseño: Teoría y Aplicaciones</b></i> (Orozco, 2024).
</p>