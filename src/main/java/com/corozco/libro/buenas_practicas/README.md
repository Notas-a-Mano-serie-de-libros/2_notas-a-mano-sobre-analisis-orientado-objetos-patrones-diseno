<h1 style="text-align: center;">
<strong>Principios y buenas prácticas de diseño</strong>
</h1>

<p style="text-align: justify;">
Este bloque presenta los <b>fundamentos de calidad en diseño orientado a objetos</b> y las <b>buenas prácticas</b> que los acompañan.  
El objetivo es ofrecer criterios claros para <b>encapsular correctamente</b>, <b>reducir el acoplamiento</b>, <b>aumentar la cohesión</b> y <b>facilitar la extensibilidad</b> antes de introducir los patrones del GoF.  
Cada sección incluye explicación conceptual y <b>ejemplos en Java</b>.
</p>

---

<h2>🧭 Estructura del bloque</h2>

<table>
  <thead>
    <tr>
      <th style="text-align: center;">Carpeta</th>
      <th style="text-align: center;">Contenido</th>
      <th>Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align: center;"><a href="./solid/README.md"><b>solid</b></a></td>
      <td style="text-align: center;"><p>Principios SOLID</p></td>
      <td><p style="text-align: justify;">Cinco principios que orientan diseños mantenibles y extensibles: <i>SRP, OCP, LSP, ISP, DIP</i>. Se muestran anti-patrones comunes y refactorizaciones típicas.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="./grasp/README.md"><b>grasp</b></a></td>
      <td style="text-align: center;"><p>Patrones GRASP</p></td>
      <td><p style="text-align: justify;">Asignación coherente de responsabilidades entre objetos: <i>Information Expert, Creator, Low Coupling, High Cohesion, Controller</i>, entre otros.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="./dry/README.md"><b>dry</b></a></td>
      <td style="text-align: center;"><p>DRY (Don’t Repeat Yourself)</p></td>
      <td><p style="text-align: justify;">Estrategias para eliminar duplicación lógica mediante abstracciones estables, utilidades bien definidas y reutilización segura.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="./kiss/README.md"><b>kiss</b></a></td>
      <td style="text-align: center;"><p>KISS (Keep It Simple, Stupid)</p></td>
      <td><p style="text-align: justify;">Prioriza soluciones simples y claras; evita sobreingeniería, configuraciones innecesarias y dependencias superfluas.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="./yagni/README.md"><b>yagni</b></a></td>
      <td style="text-align: center;"><p>YAGNI (You Aren’t Gonna Need It)</p></td>
      <td><p style="text-align: justify;">Implementa solo lo necesario para los requisitos actuales; pospone extensiones hipotéticas que elevan el costo de mantenimiento.</p></td>
    </tr>
    <tr>
      <td style="text-align: center;"><a href="./demeter/README.md"><b>demeter</b></a></td>
      <td style="text-align: center;"><p>Ley de Demeter</p></td>
      <td><p style="text-align: justify;">Reduce la exposición de estructura interna y evita “train wrecks”. Promueve mensajes cortos y objetos verdaderamente encapsulados.</p></td>
    </tr>
  </tbody>
</table>

<h2>📚 Accesos directos</h2>

<p style="text-align: justify;">
Accede rápidamente a los contenidos de este bloque mediante los siguientes enlaces:
</p>

<ul style="text-align: justify;">
  <li>🧠 <a href="./solid/README.md"><b>Principios SOLID</b></a></li>
  <li>🎯 <a href="./grasp/README.md"><b>Patrones GRASP</b></a></li>
  <li>🔁 <a href="./dry/README.md"><b>DRY – Don’t Repeat Yourself</b></a></li>
  <li>⚙️ <a href="./kiss/README.md"><b>KISS – Keep It Simple, Stupid</b></a></li>
  <li>🧮 <a href="./yagni/README.md"><b>YAGNI – You Aren’t Gonna Need It</b></a></li>
  <li>🔣 <a href="./demeter/README.md"><b>Ley de Demeter</b></a></li>
</ul>

---

<h2>🧠 Conceptos clave</h2>

<h3>🔹 Cohesión y acoplamiento</h3>
<p style="text-align: justify;">
La <b>cohesión</b> mide el enfoque de un módulo en una única responsabilidad; el <b>acoplamiento</b> mide su dependencia respecto de otros.  
Los principios de este bloque buscan <b>alta cohesión</b> y <b>bajo acoplamiento</b>.
</p>

<h3>🔹 Composición sobre herencia</h3>
<p style="text-align: justify;">
Favorece combinar objetos para extender comportamiento sin romper contratos ni introducir fragilidad por jerarquías profundas.
</p>

<h3>🔹 Responsabilidades claras</h3>
<p style="text-align: justify;">
SOLID y GRASP ayudan a asignar responsabilidades explícitas y a definir límites estables que facilitan el cambio.
</p>

---

<h2>🚀 Objetivos de aprendizaje</h2>

<p style="text-align: justify;">
Al finalizar este bloque, el lector será capaz de:
</p>

<ol style="text-align: justify;">
  <li><b>Diagnosticar</b> code smells relacionados con bajo nivel de cohesión, alto acoplamiento y violaciones de SOLID.</li>
  <li><b>Aplicar</b> GRASP para distribuir responsabilidades y mejorar la comunicación entre objetos.</li>
  <li><b>Refactorizar</b> duplicaciones (DRY), simplificar diseños (KISS) y evitar sobreingeniería (YAGNI).</li>
  <li><b>Encapsular</b> correctamente siguiendo la Ley de Demeter.</li>
  <li><b>Preparar</b> el terreno para introducir patrones del GoF sobre una base limpia y mantenible.</li>
</ol>

---

<h2>📎 Referencia</h2>

<p style="text-align: justify;">
Este material corresponde al <b>Bloque I – Principios y buenas prácticas de diseño OO</b> del libro  
<i><b>Notas a mano sobre análisis orientado a objetos y patrones de diseño: Teoría y Aplicaciones</b></i> (Orozco, 2024).
</p>