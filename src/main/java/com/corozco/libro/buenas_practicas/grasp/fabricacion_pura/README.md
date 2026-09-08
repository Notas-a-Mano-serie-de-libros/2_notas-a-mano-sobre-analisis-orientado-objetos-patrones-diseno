<h1 style="text-align:center;">
  <strong>⚙️ Fabricación Pura</strong>
</h1>

<hr/>

<h2><strong>📘 Definición</strong></h2>

<p style="text-align:justify;">
El principio de <b>Fabricación Pura</b> (<i>Pure Fabrication</i>) propone la creación de clases que no forman parte del <b>modelo de dominio</b>,  
pero que son necesarias para soportar los aspectos técnicos, de infraestructura o de mantenimiento de un sistema.  
Su propósito es <b>preservar la cohesión y reducir el acoplamiento</b> dentro del modelo principal,  
trasladando ciertas responsabilidades a componentes auxiliares especialmente diseñados para ello.
</p>

<p style="text-align:justify;">
En esencia, una clase fabricada o "artificial" surge cuando una responsabilidad no encaja de manera natural  
en ninguna de las clases del dominio. En lugar de forzar su incorporación —lo que generaría clases con múltiples  
responsabilidades o dependencias innecesarias—, se opta por crear una nueva entidad cuya única función es  
gestionar dicha tarea de forma aislada y reutilizable.
</p>

<hr/>

<h2><strong>🎯 Propósito</strong></h2>

<p style="text-align:justify;">
El principio busca mantener la integridad del diseño orientado a objetos, evitando que las clases del dominio  
se sobrecarguen con responsabilidades ajenas a su propósito. Al aplicar <b>Fabricación Pura</b>, se logra que el sistema  
permanezca modular, flexible y fácil de mantener, incluso frente a cambios tecnológicos o de infraestructura.
</p>

<hr/>

<h2><strong>💡 Ejemplos comunes de aplicación</strong></h2>

<ul style="text-align:justify;">
  <li><b>Registro y auditoría:</b> Clases dedicadas al manejo de logs o trazabilidad del sistema, separadas del dominio principal.</li>
  <li><b>Gestión de transacciones:</b> Componentes que coordinan la persistencia o confirmación de operaciones.</li>
  <li><b>Notificaciones y mensajería:</b> Servicios especializados en el envío de correos electrónicos, mensajes SMS o alertas.</li>
  <li><b>Adaptadores de infraestructura:</b> Clases que encapsulan detalles técnicos de bases de datos, redes o servicios externos.</li>
</ul>

<p style="text-align:justify;">
Estos ejemplos ilustran cómo las clases fabricadas contribuyen a un <b>código limpio</b>,  
<b>desacoplado</b> y <b>cohesivo</b>, ya que encapsulan los detalles técnicos y permiten  
que las clases del dominio se enfoquen exclusivamente en las reglas de negocio.
</p>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>