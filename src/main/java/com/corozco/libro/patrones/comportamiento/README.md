<h1 style="text-align: center;">
<strong>Patrones de Comportamiento</strong><br/>
<strong>Organización de la comunicación entre objetos</strong>
</h1>

<p style="text-align: justify;">
Los <b>patrones de comportamiento</b> constituyen la categoría más avanzada dentro de los patrones del <b>GoF (Gang of Four)</b>.  
Su objetivo es definir <b>cómo los objetos colaboran, se comunican y distribuyen responsabilidades</b> dentro de un sistema, reduciendo al máximo las dependencias entre ellos.  
Gracias a estos patrones, es posible diseñar sistemas <b>flexibles, extensibles y fácilmente mantenibles</b>, donde cada componente cumple una función clara dentro de una arquitectura desacoplada.
</p>

---

<h2>🧩 <strong>Definición</strong></h2>

<p style="text-align: justify;">
Hasta este punto del libro, los patrones estudiados han tenido dos propósitos fundamentales:  
(i) <b>facilitar la creación de objetos</b> y (ii) <b>extender estructuras existentes</b> de forma controlada.  
Sin embargo, cuando el sistema alcanza un mayor nivel de madurez, surge una nueva necesidad: <b>garantizar una comunicación ordenada y flexible entre los componentes</b>.  
Los patrones de comportamiento proporcionan precisamente esa solución, <b>gestionando el flujo de información y la asignación de responsabilidades</b> sin incrementar el acoplamiento.
</p>

---

<h2>⚙️ <strong>Importancia</strong></h2>

<p style="text-align: justify;">
A medida que una aplicación crece, también lo hacen las interacciones entre sus objetos.  
Sin un diseño adecuado, estas relaciones pueden convertirse en una red de dependencias difíciles de mantener.  
Los patrones de comportamiento permiten <b>controlar esas interacciones</b> mediante mecanismos bien definidos que <b>preservan la cohesión interna</b> de los objetos y evitan dependencias innecesarias.
</p>

<p style="text-align: justify;">
El principio de <b>bajo acoplamiento</b> —uno de los pilares de la ingeniería del software— se encuentra en el centro de esta categoría.  
Aplicar estos patrones conduce a sistemas en los que las partes pueden <b>evolucionar de manera independiente</b>, mejorando la <b>reutilización</b> y la <b>extensibilidad</b>.
</p>

---

<h2>📚 <strong>Listado de patrones de comportamiento</strong></h2>

<p style="text-align: justify;">
La siguiente tabla presenta los principales patrones de comportamiento del GoF, junto con su propósito y el enlace a la implementación correspondiente:
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
      <td style="text-align:center;"><a href="./cadena_responsabilidad/README.md"><b>Chain of Responsibility</b></a></td>
      <td style="text-align:center;">Cadena de Responsabilidad</td>
      <td style="text-align:justify;">Permite pasar una solicitud a través de una cadena de manejadores, evitando dependencias directas entre el emisor y el receptor.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./command/README.md"><b>Command</b></a></td>
      <td style="text-align:center;">Comando</td>
      <td style="text-align:justify;">Encapsula una acción como objeto, permitiendo parametrizar, registrar y deshacer operaciones.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./iterator/README.md"><b>Iterator</b></a></td>
      <td style="text-align:center;">Iterador</td>
      <td style="text-align:justify;">Proporciona un acceso secuencial a los elementos de una colección sin exponer su estructura interna.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./mediator/README.md"><b>Mediator</b></a></td>
      <td style="text-align:center;">Mediador</td>
      <td style="text-align:justify;">Centraliza la comunicación entre objetos, eliminando dependencias directas y reduciendo la complejidad de interacción.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./memento/README.md"><b>Memento</b></a></td>
      <td style="text-align:center;">Memoria</td>
      <td style="text-align:justify;">Permite capturar y restaurar el estado interno de un objeto sin violar su encapsulación.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./observer/README.md"><b>Observer</b></a></td>
      <td style="text-align:center;">Observador</td>
      <td style="text-align:justify;">Define una relación de suscripción entre objetos, de modo que los observadores se actualizan automáticamente ante cambios de estado.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./state/README.md"><b>State</b></a></td>
      <td style="text-align:center;">Estado</td>
      <td style="text-align:justify;">Permite que un objeto altere su comportamiento cuando cambia su estado interno, evitando condicionales extensos.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./strategy/README.md"><b>Strategy</b></a></td>
      <td style="text-align:center;">Estrategia</td>
      <td style="text-align:justify;">Define una familia de algoritmos intercambiables que encapsulan un comportamiento, permitiendo cambiar la estrategia en tiempo de ejecución.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./template/README.md"><b>Template Method</b></a></td>
      <td style="text-align:center;">Método Plantilla</td>
      <td style="text-align:justify;">Define la estructura general de un algoritmo, delegando los pasos específicos a las subclases sin alterar el flujo principal.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./visitor/README.md"><b>Visitor</b></a></td>
      <td style="text-align:center;">Visitante</td>
      <td style="text-align:justify;">Permite agregar operaciones sobre una jerarquía de clases sin modificar sus definiciones originales.</td>
    </tr>
  </tbody>
</table>

---

<h2>🧠 <strong>Conceptos clave</strong></h2>

<h3>🔹 Comunicación desacoplada</h3>
<p style="text-align: justify;">
Los patrones de comportamiento promueven interacciones <b>independientes de la implementación concreta</b> de los objetos, garantizando que los cambios en un módulo no afecten a los demás.
</p>

<h3>🔹 Delegación y polimorfismo</h3>
<p style="text-align: justify;">
Estos patrones hacen uso extensivo de la <b>delegación</b> de responsabilidades y del <b>polimorfismo</b>, permitiendo reemplazar comportamientos en tiempo de ejecución sin modificar el código existente.
</p>

<h3>🔹 Escalabilidad y mantenibilidad</h3>
<p style="text-align: justify;">
La aplicación correcta de los patrones de comportamiento facilita el crecimiento controlado del sistema, manteniendo una estructura clara y adaptable al cambio.
</p>

---

<h2>🚀 <strong>Objetivos de aprendizaje</strong></h2>

<p style="text-align: justify;">
Al finalizar este módulo, el lector será capaz de:
</p>

<ol style="text-align: justify;">
  <li><b>Comprender</b> cómo los patrones de comportamiento reducen el acoplamiento entre objetos.</li>
  <li><b>Aplicar</b> estrategias de comunicación indirecta mediante <i>Mediator</i>, <i>Observer</i> y <i>Chain of Responsibility</i>.</li>
  <li><b>Diseñar</b> algoritmos extensibles empleando <i>Template Method</i> y <i>Strategy</i>.</li>
  <li><b>Implementar</b> mecanismos de historial y control con <i>Memento</i> y <i>Command</i>.</li>
  <li><b>Evaluar</b> qué patrón es más adecuado según el tipo de interacción o comportamiento deseado.</li>
</ol>

---

<h2>📎 <strong>Referencia</strong></h2>

<p style="text-align: justify;">
Este material forma parte del <b>Bloque II – Patrones de diseño orientado a objetos</b> del libro  
<i><b>Notas a mano sobre análisis orientado a objetos y patrones de diseño: Teoría y Aplicaciones</b></i> (Orozco, 2024).
</p>