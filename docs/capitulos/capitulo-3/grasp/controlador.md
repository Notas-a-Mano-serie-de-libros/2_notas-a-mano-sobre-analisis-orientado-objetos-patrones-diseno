<h1 style="text-align:center;">
  <strong> Controlador (Controller)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición general</strong></h2>

<p style="text-align:justify;">
El principio de <b>Controller</b> establece que la <b>responsabilidad de manejar los eventos del sistema</b> —como solicitudes del usuario, acciones de la interfaz o mensajes del entorno— debe asignarse a una entidad especializada denominada <b>controlador</b>.
El controlador actúa como un <b>intermediario</b> entre la capa de presentación (interfaz de usuario) y la capa de negocio o dominio, encapsulando la lógica de coordinación y flujo de datos entre ambas.
</p>

<p style="text-align:justify;">
El propósito de este principio es <b>centralizar la lógica de control</b> en clases específicas para mejorar la <b>modularidad</b>, la <b>reutilización</b> y la <b>mantenibilidad</b> del sistema.
Al aplicar correctamente el patrón de controlador, se evita que las vistas o componentes de interfaz incluyan lógica de negocio, garantizando así una separación clara de responsabilidades.
</p>

<hr/>

<h2><strong> Rol del controlador en la arquitectura</strong></h2>

<p style="text-align:justify;">
En un diseño arquitectónico basado en capas, el controlador tiene un papel clave dentro del flujo de ejecución:
</p>

<ol style="text-align:justify;">
  <li>Recibe las solicitudes generadas por el usuario o por la interfaz.</li>
  <li>Interpreta el evento y determina la acción que debe realizarse.</li>
  <li>Coordina la comunicación con el modelo del dominio o los servicios del sistema.</li>
  <li>Actualiza o notifica a la vista sobre los resultados o cambios en el estado del sistema.</li>
</ol>

<p style="text-align:justify;">
De esta manera, el controlador sirve como un <b>punto de orquestación</b> que gestiona el flujo entre los diferentes componentes del sistema sin violar el principio de <b>bajo acoplamiento</b>.
</p>

<hr/>

<h2><strong> Beneficios de aplicar el principio Controller</strong></h2>

<ul style="text-align:justify;">
  <li><b>Desacopla la interfaz del dominio:</b> la lógica de presentación no conoce los detalles internos del modelo, reduciendo dependencias innecesarias.</li>
  <li><b>Centraliza la coordinación de eventos:</b> todos los flujos del sistema pasan por un punto de control común, lo que facilita el mantenimiento y la trazabilidad.</li>
  <li><b>Fomenta la reutilización:</b> el mismo controlador puede ser utilizado por diferentes vistas o interfaces (por ejemplo, web, móvil o API).</li>
  <li><b>Promueve la extensibilidad:</b> nuevos comportamientos pueden añadirse sin alterar el modelo o la vista, manteniendo la arquitectura limpia y escalable.</li>
</ul>

<hr/>

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Sistema de Reserva de Habitaciones** | Se solicita implementar un sistema que permita gestionar las reservas de un hotel . El sistema debe ofrecer las operaciones básicas para crear y eliminar reservas , asociando cada una a un usuario y a un tipo de habitación . El hotel dispone de tres categorías de habitaciones: | [Ver diagramas y desplegar el código](controlador-ejemplo_reserva_habitacion.md) |

## Ejemplos y diagramas UML

### 1. Sistema de Reserva de Habitaciones

Se solicita implementar un sistema que permita gestionar las reservas de un hotel . El sistema debe ofrecer las operaciones básicas para crear y eliminar reservas , asociando cada una a un usuario y a un tipo de habitación . El hotel dispone de tres categorías de habitaciones:

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/controlador_ejemplo.png" alt="Diagrama UML de Sistema de Reserva de Habitaciones">
  <figcaption><strong>Modelo UML.</strong> Sistema de Reserva de Habitaciones.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](controlador-ejemplo_reserva_habitacion.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | La interfaz de usuario o las entidades reciben directamente eventos del sistema. |
| **Escenario de aplicación** | Coordinación de un caso de uso como reservar una habitación. |
| **Ventaja principal** | Se separan entrada, coordinación y reglas del dominio. |
| **Desventaja o precaución** | Un único controlador para todo el sistema puede convertirse en un objeto omnipotente. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/controlador/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
