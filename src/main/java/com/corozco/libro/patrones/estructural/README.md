<h1 style="text-align: center;">
<strong>Patrones Estructurales</strong><br/>
<strong>Composición flexible y organización de las dependencias</strong>
</h1>

<p style="text-align: justify;">
Los <b>patrones estructurales</b> definen la manera en que <b>las clases y los objetos se combinan</b> para formar estructuras más complejas, manteniendo al mismo tiempo una arquitectura flexible y coherente.  
Su propósito es facilitar la extensión de un sistema sin alterar su estructura base, promoviendo el <b>reuso de componentes</b> y la <b>cohesión entre módulos</b>.  
A través de ellos, un desarrollador puede construir sistemas donde las relaciones entre las partes —como dependencia, agregación o composición— sean claras, consistentes y fácilmente escalables.
</p>

---

<h2>🏗️ <strong>Definición</strong></h2>

<p style="text-align: justify;">
Los patrones estructurales se enfocan en <b>organizar las relaciones entre clases y objetos</b> para formar estructuras estables que permitan extender el comportamiento del sistema sin afectar su integridad.  
En otras palabras, actúan como <b>mecanismos de conexión</b> que definen cómo las piezas del sistema se ensamblan para crear nuevas funcionalidades.  
Gracias a ellos, es posible <b>combinar objetos existentes</b> de formas innovadoras y reutilizar código sin duplicación.
</p>

<p style="text-align: justify;">
Estos patrones aprovechan principios de diseño como la <b>composición sobre la herencia</b> y la <b>delegación controlada</b>, buscando siempre mantener la independencia entre los componentes y la claridad en las dependencias.
</p>

---

<h2>⚙️ <strong>Importancia</strong></h2>

<p style="text-align: justify;">
Una vez que las clases fundamentales y los mecanismos de creación de objetos han sido definidos, los sistemas comienzan a enfrentar un nuevo reto: <b>mantener la cohesión y evitar el acoplamiento excesivo</b>.  
A medida que las funcionalidades crecen, los módulos pueden empezar a depender entre sí de formas no deseadas, afectando la mantenibilidad del software.
</p>

<p style="text-align: justify;">
Los patrones estructurales ofrecen una solución elegante a este problema al <b>controlar cómo se relacionan las clases y los objetos</b>.  
Permiten <b>extender la funcionalidad</b> sin modificar el código existente, <b>envolver objetos</b> para agregar comportamientos, o incluso <b>reducir la complejidad</b> del sistema mediante la introducción de interfaces unificadas.
</p>

<p style="text-align: justify;">
En resumen, estos patrones constituyen una <b>caja de herramientas para la evolución estructural</b> del sistema, garantizando que las nuevas incorporaciones se integren de manera limpia, reutilizable y coherente con el diseño global.
</p>

---

<h2>📚 <strong>Listado de patrones estructurales</strong></h2>

<p style="text-align: justify;">
La siguiente tabla resume los principales patrones estructurales del GoF, junto con su nombre en español y una breve descripción de su propósito:
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
      <td style="text-align:center;"><a href="./adapter/README.md"><b>Adapter</b></a></td>
      <td style="text-align:center;">Adaptador</td>
      <td style="text-align:justify;">Permite que dos interfaces incompatibles trabajen juntas, actuando como un traductor entre clases que de otro modo no podrían colaborar.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./bridge/README.md"><b>Bridge</b></a></td>
      <td style="text-align:center;">Puente</td>
      <td style="text-align:justify;">Separa una abstracción de su implementación, permitiendo que ambas evolucionen de manera independiente.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./composite/README.md"><b>Composite</b></a></td>
      <td style="text-align:center;">Compuesto</td>
      <td style="text-align:justify;">Permite tratar objetos individuales y compuestos de manera uniforme, representando jerarquías de tipo árbol.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./decorator/README.md"><b>Decorator</b></a></td>
      <td style="text-align:center;">Decorador</td>
      <td style="text-align:justify;">Agrega dinámicamente responsabilidades adicionales a un objeto sin modificar su estructura base.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./facade/README.md"><b>Facade</b></a></td>
      <td style="text-align:center;">Fachada</td>
      <td style="text-align:justify;">Proporciona una interfaz simplificada que unifica un conjunto de interfaces de un subsistema complejo.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./flyweight/README.md"><b>Flyweight</b></a></td>
      <td style="text-align:center;">Peso Ligero</td>
      <td style="text-align:justify;">Reduce el consumo de memoria compartiendo objetos comunes entre múltiples instancias, optimizando el rendimiento.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><a href="./proxy/README.md"><b>Proxy</b></a></td>
      <td style="text-align:center;">Intermediario</td>
      <td style="text-align:justify;">Actúa como sustituto o representante de otro objeto, controlando su acceso o añadiendo lógica adicional antes de la llamada real.</td>
    </tr>
  </tbody>
</table>

---

<h2>🧠 <strong>Conceptos clave</strong></h2>

<h3>🔹 Composición sobre herencia</h3>
<p style="text-align: justify;">
Los patrones estructurales promueven la <b>composición</b> como alternativa a la herencia, lo que permite combinar comportamientos de forma flexible y evitar jerarquías rígidas.
</p>

<h3>🔹 Flexibilidad arquitectónica</h3>
<p style="text-align: justify;">
Estos patrones facilitan la expansión del sistema mediante la <b>interconexión de clases y objetos</b> sin necesidad de alterar su código fuente original.
</p>

<h3>🔹 Reutilización y extensibilidad</h3>
<p style="text-align: justify;">
Gracias al encapsulamiento de dependencias, los componentes pueden ser <b>reutilizados en distintos contextos</b>, mejorando la mantenibilidad y la coherencia del diseño.
</p>

---

<h2>🚀 <strong>Objetivos de aprendizaje</strong></h2>

<p style="text-align: justify;">
Al finalizar este módulo, el lector será capaz de:
</p>

<ol style="text-align: justify;">
  <li><b>Comprender</b> las relaciones estructurales entre clases y objetos en el diseño orientado a objetos.</li>
  <li><b>Aplicar</b> patrones de composición como <i>Composite</i> y <i>Decorator</i> para extender funcionalidades dinámicamente.</li>
  <li><b>Diseñar</b> subsistemas desacoplados usando <i>Facade</i>, <i>Bridge</i> y <i>Adapter</i>.</li>
  <li><b>Optimizar</b> el uso de recursos mediante <i>Flyweight</i> y controlar accesos con <i>Proxy</i>.</li>
  <li><b>Evaluar</b> qué patrón estructural se adapta mejor a la necesidad de integración o extensión de cada módulo.</li>
</ol>

---

<h2>📎 <strong>Referencia</strong></h2>

<p style="text-align: justify;">
Este material forma parte del <b>Bloque II – Patrones de diseño orientado a objetos</b> del libro  
<i><b>Notas a mano sobre análisis orientado a objetos y patrones de diseño: Teoría y Aplicaciones</b></i> (Orozco, 2024).
</p>