<h1 style="text-align: center;">
<strong>SOLID</strong><br/>
<strong>Diseño orientado a objetos limpio y extensible</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<p style="text-align: justify;">
Los <b>principios SOLID</b> representan un conjunto de <b>buenas prácticas</b> para el diseño e implementación de software orientado a objetos.
Fueron propuestos y difundidos por <b>Robert C. Martin</b> a lo largo de las décadas de 1980 y 2000, con el propósito de mejorar la mantenibilidad, la extensibilidad y la robustez de los sistemas de software.
El acrónimo <b>SOLID</b> fue introducido posteriormente por <b>Michael Feathers</b> —autor de <i>Working Effectively with Legacy Code</i>— como una forma de unificar y recordar los cinco principios fundamentales que orientan el desarrollo de código limpio y desacoplado.
</p>

<p style="text-align: justify;">
Cada uno de los principios que conforman <b>SOLID</b> aborda un aspecto específico del diseño orientado a objetos, y su aplicación conjunta conduce a arquitecturas más coherentes, flexibles y fáciles de mantener.
Estos principios son considerados una <b>evolución práctica de los principios GRASP</b>, al trasladar sus ideas conceptuales a un marco operativo moderno.
</p>

<p>Consulta los ejemplos de cada principio:</p>
<ul class="chapter-section-list">
<li><a href="responsabilidad_unica/"><strong>Single Responsibility Principle (SRP)</strong></a></li>
<li><a href="abierto_cerrado/"><strong>Open/Closed Principle (OCP)</strong></a></li>
<li><a href="liskov/"><strong>Liskov Substitution Principle (LSP)</strong></a></li>
<li><a href="segregacion_interfaces/"><strong>Interface Segregation Principle (ISP)</strong></a></li>
<li><a href="inversion_dependencias/"><strong>Dependency Inversion Principle (DIP)</strong></a></li>
</ul>

---

##  Estructura de los principios

<table>
  <thead>
    <tr>
      <th style="text-align: center;">Carpeta</th>
      <th style="text-align: center;">Principio</th>
      <th>Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align: center;"><a href="responsabilidad_unica/"><b>responsabilidad_unica</b></a></td>
      <td style="text-align: center;">SRP</td>
      <td><p style="text-align: justify;">Establece que cada clase debe tener una única razón de cambio. Este principio promueve la cohesión y simplifica la lectura, prueba y mantenimiento del código.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="abierto_cerrado/"><b>abierto_cerrado</b></a></td>
      <td style="text-align: center;">OCP</td>
      <td><p style="text-align: justify;">Indica que las entidades del sistema deben estar abiertas para su extensión pero cerradas para su modificación, favoreciendo la evolución sin alterar código estable.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="liskov/"><b>liskov</b></a></td>
      <td style="text-align: center;">LSP</td>
      <td><p style="text-align: justify;">Garantiza que las subclases puedan sustituir a sus superclases sin alterar la corrección del programa. Promueve jerarquías coherentes y seguras.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="segregacion_interfaces/"><b>segregacion_interfaces</b></a></td>
      <td style="text-align: center;">ISP</td>
      <td><p style="text-align: justify;">Propone dividir las interfaces grandes en múltiples interfaces específicas, de modo que los clientes no dependan de métodos que no utilizan.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="inversion_dependencias/"><b>inversion_dependencias</b></a></td>
      <td style="text-align: center;">DIP</td>
      <td><p style="text-align: justify;">Sugiere que las dependencias deben orientarse hacia abstracciones, no hacia implementaciones concretas. Esto permite invertir el flujo de control y facilita el uso de inyección de dependencias.</p></td>
    </tr>
  </tbody>
</table>

---

##  Accesos directos

<p style="text-align: justify;">
Accede rápidamente a los principios que conforman el conjunto <b>SOLID</b> mediante los siguientes enlaces:
</p>

<ul style="text-align: justify;">
  <li> <a href="responsabilidad_unica/"><b>Single Responsibility Principle (SRP)</b></a></li>
  <li> <a href="abierto_cerrado/"><b>Open/Closed Principle (OCP)</b></a></li>
  <li> <a href="liskov/"><b>Liskov Substitution Principle (LSP)</b></a></li>
  <li> <a href="segregacion_interfaces/"><b>Interface Segregation Principle (ISP)</b></a></li>
  <li> <a href="inversion_dependencias/"><b>Dependency Inversion Principle (DIP)</b></a></li>
</ul>

---

##  Conceptos clave

###  Cohesión y acoplamiento
<p style="text-align: justify;">
Los principios SOLID buscan maximizar la <b>cohesión</b> —cada clase cumple un propósito bien definido— y minimizar el <b>acoplamiento</b>, reduciendo las dependencias directas entre componentes.
Esto facilita la evolución del sistema sin afectar otras partes del código.
</p>

###  Extensibilidad controlada
<p style="text-align: justify;">
Uno de los objetivos principales de SOLID es permitir la <b>extensión del comportamiento</b> del software sin necesidad de modificar el código existente.
Esto se logra mediante abstracciones, interfaces y herencia correctamente aplicadas.
</p>

###  Abstracción y estabilidad
<p style="text-align: justify;">
La <b>abstracción</b> permite aislar los detalles que cambian con mayor frecuencia, garantizando que el núcleo del sistema permanezca estable a lo largo del tiempo.
</p>

---

##  Objetivos de aprendizaje

<p style="text-align: justify;">
Al estudiar los principios SOLID, el lector será capaz de:
</p>

<ol style="text-align: justify;">
  <li><b>Identificar</b> malas prácticas de diseño que afectan la mantenibilidad del software.</li>
  <li><b>Aplicar</b> correctamente los cinco principios SOLID en proyectos orientados a objetos.</li>
  <li><b>Refactorizar</b> código para mejorar su estructura, cohesión y flexibilidad.</li>
  <li><b>Diseñar</b> sistemas que favorezcan la extensibilidad y reduzcan el impacto de los cambios.</li>
  <li><b>Relacionar</b> los principios SOLID con los principios GRASP como evolución del pensamiento de diseño orientado a objetos.</li>
</ol>

---

## Bibliografía


<p style="text-align: justify;" id="Feathers">
<b>Referencia principal:</b> Feathers, M. (2004). <i>Working Effectively with Legacy Code</i>. Prentice Hall.
</p>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/solid/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
