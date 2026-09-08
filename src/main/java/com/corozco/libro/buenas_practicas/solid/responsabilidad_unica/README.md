<h1 style="text-align:center;">
  <strong>🧩 S: Single Responsibility Principle (SRP)</strong>
</h1>

<hr/>

<h3 style="text-align:center;">
  <em>"Una clase debería tener solo una razón para cambiar"</em>
</h3>

<hr/>

<h2><strong>📘 Descripción general</strong></h2>

<p style="text-align:justify;">
El <b>Principio de Responsabilidad Única (SRP)</b> establece que una clase debe tener <b>una única razón para cambiar</b>.  
Esto significa que cada módulo, clase o componente debe concentrarse exclusivamente en una <b>parte específica de la funcionalidad</b> del sistema.  
Si una clase asume múltiples responsabilidades, los cambios en una de ellas pueden afectar inadvertidamente las demás,  
aumentando el riesgo de errores y el acoplamiento entre componentes.
</p>

<p style="text-align:justify;">
En otras palabras, el SRP busca que las clases sean <b>altamente cohesivas</b> y <b>bajo acopladas</b>, fomentando un diseño modular, mantenible y fácil de probar.  
Este principio es la base de una arquitectura orientada a la separación clara de responsabilidades dentro del código.
</p>

<hr/>

<h2><strong>📖 Relación con los principios GRASP</strong></h2>

<p style="text-align:justify;">
Históricamente, el SRP puede considerarse una evolución directa del principio de <b>Alta Cohesión</b> de los patrones <b>GRASP</b>.  
Mientras la <i>Alta Cohesión</i> promueve que los objetos agrupen responsabilidades estrechamente relacionadas,  
el SRP va un paso más allá al exigir que <b>cada clase tenga una sola razón para cambiar</b>.
</p>

<p style="text-align:justify;">
Cumplir con el SRP implica que cada clase encapsula un único propósito dentro del sistema.  
Esto reduce el impacto de los cambios, mejora la legibilidad del código y permite escalar o extender las funcionalidades sin alterar el comportamiento existente.
</p>

<hr/>

<h2><strong>🧠 Analogía: el sujeto multidisciplinar</strong></h2>

<p style="text-align:justify;">
Para comprender este principio de forma intuitiva, consideremos a <b>José</b>, una persona con múltiples habilidades que desempeña diferentes funciones dentro de su equipo de trabajo.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/responsabilidad_unica/srp_analogia_caso1.png" width="90%" height="auto" alt="Caso 1: José asume múltiples responsabilidades"/>
</p>

<p style="text-align:justify;">
A primera vista, parece ventajoso contar con alguien que pueda hacerlo todo.  
Sin embargo, cuando sus compañeros necesitan apoyo, <b>José se convierte en un cuello de botella</b>, ya que su tiempo y atención se dividen entre demasiadas tareas.  
El entorno de José viola el SRP porque una sola entidad (José) concentra múltiples responsabilidades.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/responsabilidad_unica/srp_analogia_caso2.png" width="90%" height="auto" alt="Caso 2: entorno con baja cohesión"/>
</p>

<p style="text-align:justify;">
Para solucionar el problema, el equipo distribuye las tareas entre diferentes personas especializadas,  
cada una encargada de un área concreta.  
El resultado es un sistema más eficiente, predecible y escalable, donde cada miembro tiene una sola razón para cambiar.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/responsabilidad_unica/srp_analogia_caso3.png" width="90%" height="auto" alt="Caso 3: entorno que cumple el SRP"/>
</p>

<p style="text-align:justify;">
De la misma forma, en la ingeniería de software, <b>cada clase o módulo debe ser el “especialista” de su responsabilidad</b>.  
Separar las funciones de manera adecuada fomenta una arquitectura clara, cohesiva y resistente al cambio.
</p>

<hr/>

<h2><strong>📂 Accesos directos a los ejemplos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Ejemplo</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Descripción</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Acceso</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;"><b>Ejemplo 1</b><br/>Figuras Geométricas</td>
      <td style="border:1px solid #ddd; padding:8px; text-align:justify;">
        Contrasta una clase que calcula áreas y perímetros de múltiples figuras (violando SRP)
        con una versión que delega el cálculo a cada figura individual (aplicando SRP).
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo1_figuras_geometricas/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
    <tr>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;"><b>Ejemplo 2</b><br/>Manipulación de Facturas</td>
      <td style="border:1px solid #ddd; padding:8px; text-align:justify;">
        Muestra cómo dividir una clase monolítica que valida, guarda y envía facturas
        en componentes especializados que asumen responsabilidades distintas.
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo2_manipulacion_facturas/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong>💡 Conclusión</strong></h2>

<p style="text-align:justify;">
El <b>Principio de Responsabilidad Única (SRP)</b> constituye el fundamento de un diseño orientado a objetos limpio y sostenible.  
Aplicarlo correctamente mejora la cohesión, minimiza el impacto de los cambios y promueve la reutilización del código.  
En términos arquitectónicos, cada clase debe representar una unidad de propósito única y bien definida.
</p>

<p style="text-align:justify;">
Cumplir el SRP implica asumir una mentalidad de <b>especialización y delegación</b>:  
cada componente se ocupa de una única tarea, facilitando la comprensión del sistema y su evolución futura.
</p>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Martin, R. C. (2003). <i>Agile Software Development: Principles, Patterns, and Practices.</i> Prentice Hall.</li>
  <li>Martin, R. C. (2009). <i>Clean Code: A Handbook of Agile Software Craftsmanship.</i> Prentice Hall.</li>
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design.</i> Prentice Hall.</li>
</ul>