<h1 style="text-align:center;">
  <strong> Fabricación Pura</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición</strong></h2>

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

<h2><strong> Propósito</strong></h2>

<p style="text-align:justify;">
El principio busca mantener la integridad del diseño orientado a objetos, evitando que las clases del dominio
se sobrecarguen con responsabilidades ajenas a su propósito. Al aplicar <b>Fabricación Pura</b>, se logra que el sistema
permanezca modular, flexible y fácil de mantener, incluso frente a cambios tecnológicos o de infraestructura.
</p>

<hr/>

<h2><strong> Ejemplos comunes de aplicación</strong></h2>

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

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Logs Personalizados** | Se solicita implementar una utilidad que permita generar logs personalizados para los distintos servicios del sistema. El objetivo es crear una librería independiente que proporcione una interfaz común para registrar mensajes informativos, de depuración y errores críticos, e integrarse fácilmente en cualquier servicio sin modificar su lógica principal. | [Ver diagramas y desplegar el código](fabricacion_pura-ejemplo.md) |

## Ejemplos y diagramas UML

### 1. Logs Personalizados

Se solicita implementar una utilidad que permita generar logs personalizados para los distintos servicios del sistema. El objetivo es crear una librería independiente que proporcione una interfaz común para registrar mensajes informativos, de depuración y errores críticos, e integrarse fácilmente en cualquier servicio sin modificar su lógica principal.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/fabricacion_pura_ejemplo.png" alt="Diagrama UML de Logs Personalizados">
  <figcaption><strong>Modelo UML.</strong> Logs Personalizados.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](fabricacion_pura-ejemplo.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | Una responsabilidad necesaria no encaja de forma natural en ninguna entidad del dominio. |
| **Escenario de aplicación** | Persistencia, registro, conversión, mensajería o integración técnica. |
| **Ventaja principal** | Protege la cohesión del modelo y facilita reutilizar servicios técnicos. |
| **Desventaja o precaución** | El exceso de servicios artificiales puede producir un modelo de dominio sin comportamiento. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/fabricacion_pura/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
