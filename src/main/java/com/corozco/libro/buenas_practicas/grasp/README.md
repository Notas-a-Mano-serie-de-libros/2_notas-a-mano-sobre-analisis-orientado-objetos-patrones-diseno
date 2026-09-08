<h1 style="text-align:center;"><strong>🎯 Principios GRASP (General Responsibility Assignment Software Patterns)</strong></h1>

<h4 style="text-align:center;"><em>“Asignar responsabilidades de forma coherente es la base de un buen diseño orientado a objetos.”</em></h4>

<p style="text-align: justify;">
Los <b>principios GRASP</b> —acrónimo de <i>General Responsibility Assignment Software Patterns</i>— constituyen un conjunto de <b>patrones fundamentales</b> que orientan la <b>asignación de responsabilidades</b> dentro del diseño orientado a objetos.  
Fueron introducidos por <b>Craig Larman</b> en su libro <i>Applying UML and Patterns</i> (2004), con el propósito de ayudar a los diseñadores de software a tomar decisiones más racionales, coherentes y mantenibles al estructurar los sistemas.
</p>

<p style="text-align: justify;">
A diferencia de los <b>patrones de diseño</b> (GoF), que describen soluciones recurrentes a problemas específicos de arquitectura, los principios <b>GRASP</b> se centran en <b>principios de diseño conceptual</b>, definiendo quién debe tener una responsabilidad y por qué.  
Cada principio aborda una dimensión clave del diseño: acoplamiento, cohesión, creación de objetos, control del flujo, polimorfismo o manejo de la variación.
</p>

---

## 🧭 Propósito general

<p style="text-align: justify;">
El objetivo de GRASP es <b>garantizar una distribución racional de responsabilidades</b> entre las clases de un sistema.  
De esta forma, se promueven diseños más <b>robustos, reutilizables, extensibles y fáciles de mantener</b>, en los que las clases cooperan entre sí sin depender excesivamente unas de otras.
</p>

---

## 📚 Principios GRASP y sus descripciones

<table>
  <thead>
    <tr>
      <th style="text-align:center;">🧱 Principio</th>
      <th style="text-align:center;">📖 Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:center;"><a href="./acoplamiento/README.md"><b>Acoplamiento</b></a></td>
      <td style="text-align:justify;">Define el grado de dependencia entre clases. Se busca mantener un <b>bajo acoplamiento</b> para favorecer la flexibilidad y reducir los efectos secundarios ante los cambios.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./cohesion/README.md"><b>Cohesión</b></a></td>
      <td style="text-align:justify;">Mide qué tan relacionadas están las responsabilidades de una clase. Una alta cohesión implica que una clase tiene un propósito claro y enfocado.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./controlador/README.md"><b>Controlador</b></a></td>
      <td style="text-align:justify;">Asigna la responsabilidad de manejar eventos del sistema a una clase que actúe como intermediaria entre la interfaz de usuario y la lógica de negocio.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./creador/README.md"><b>Creador</b></a></td>
      <td style="text-align:justify;">Indica qué clase debería ser responsable de instanciar otras clases. Una clase debe crear instancias de aquellas con las que tiene una relación estrecha.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./experto_informacion/README.md"><b>Experto en información</b></a></td>
      <td style="text-align:justify;">Establece que la responsabilidad debe asignarse a la clase que tiene la información necesaria para cumplirla de forma natural, promoviendo el encapsulamiento.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./fabricacion_pura/README.md"><b>Fabricación pura</b></a></td>
      <td style="text-align:justify;">Propone la creación de clases artificiales para manejar responsabilidades que no encajan claramente en las entidades del dominio, preservando la cohesión y el bajo acoplamiento.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./indireccion/README.md"><b>Indirección</b></a></td>
      <td style="text-align:justify;">Sugiere introducir un intermediario entre dos elementos acoplados para reducir la dependencia directa entre ellos, mejorando la extensibilidad del sistema.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./polimorfismo/README.md"><b>Polimorfismo</b></a></td>
      <td style="text-align:justify;">Asigna responsabilidades de comportamiento alternativo a las subclases adecuadas, permitiendo extender el sistema mediante herencia o interfaces sin alterar el código existente.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./variacion_protegida/README.md"><b>Variación protegida</b></a></td>
      <td style="text-align:justify;">Define fronteras explícitas para aislar los elementos que varían. Los cambios deben concentrarse en un único punto, protegiendo al resto del sistema de sus efectos.</td>
    </tr>
  </tbody>
</table>

---

## 🧠 Relación con otros principios de diseño

<p style="text-align: justify;">
Los principios <b>GRASP</b> complementan otros lineamientos como los principios <b>SOLID</b> y las <b>buenas prácticas de diseño orientado a objetos</b>.  
Mientras que SOLID se enfoca en el comportamiento de las clases y la extensión del código, GRASP ofrece una <b>guía conceptual sobre cómo asignar responsabilidades</b> desde la etapa de modelado.
</p>

<p style="text-align: justify;">
La correcta aplicación conjunta de ambos conjuntos de principios conduce a arquitecturas <b>escalables, coherentes y resistentes al cambio</b>.
</p>

---

## 💡 Beneficios del uso de GRASP

| 🌟 Beneficio | 📘 Descripción |
|--------------|----------------|
| **Diseños más coherentes** | <p style="text-align: justify;">Proporciona un marco conceptual claro para distribuir responsabilidades entre clases y módulos.</p> |
| **Alta mantenibilidad** | <p style="text-align: justify;">Las clases bien cohesionadas y con bajo acoplamiento son más fáciles de modificar y extender.</p> |
| **Mayor reutilización** | <p style="text-align: justify;">Los patrones de asignación de responsabilidades permiten construir componentes genéricos reutilizables.</p> |
| **Reducción del acoplamiento** | <p style="text-align: justify;">Evita dependencias innecesarias entre módulos, facilitando la evolución del sistema.</p> |
| **Diseño orientado a objetivos** | <p style="text-align: justify;">Cada decisión de diseño responde a una motivación clara y medible dentro del dominio del problema.</p> |

---

## 📎 Referencia

<p style="text-align: justify;">
Larman, C. (2004). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development</i> (3rd ed.).  
Prentice Hall PTR. ISBN 978-0-13-148906-6.
</p>