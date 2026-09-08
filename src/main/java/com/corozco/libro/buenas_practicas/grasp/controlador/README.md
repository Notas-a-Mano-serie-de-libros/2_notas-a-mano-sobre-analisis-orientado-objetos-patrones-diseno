<h1 style="text-align:center;">
  <strong>🎛️ Principio de Controlador (Controller)</strong>
</h1>

<hr/>

<h2><strong>📘 Definición general</strong></h2>

<p style="text-align:justify;">
El principio de <b>Controller</b> establece que la <b>responsabilidad de manejar los eventos del sistema</b> —como solicitudes del usuario, acciones de la interfaz o mensajes del entorno— debe asignarse a una entidad especializada denominada <b>controlador</b>.  
El controlador actúa como un <b>intermediario</b> entre la capa de presentación (interfaz de usuario) y la capa de negocio o dominio, encapsulando la lógica de coordinación y flujo de datos entre ambas.
</p>

<p style="text-align:justify;">
El propósito de este principio es <b>centralizar la lógica de control</b> en clases específicas para mejorar la <b>modularidad</b>, la <b>reutilización</b> y la <b>mantenibilidad</b> del sistema.  
Al aplicar correctamente el patrón de controlador, se evita que las vistas o componentes de interfaz incluyan lógica de negocio, garantizando así una separación clara de responsabilidades.
</p>

<hr/>

<h2><strong>⚙️ Rol del controlador en la arquitectura</strong></h2>

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

<h2><strong>💡 Beneficios de aplicar el principio Controller</strong></h2>

<ul style="text-align:justify;">
  <li><b>Desacopla la interfaz del dominio:</b> la lógica de presentación no conoce los detalles internos del modelo, reduciendo dependencias innecesarias.</li>
  <li><b>Centraliza la coordinación de eventos:</b> todos los flujos del sistema pasan por un punto de control común, lo que facilita el mantenimiento y la trazabilidad.</li>
  <li><b>Fomenta la reutilización:</b> el mismo controlador puede ser utilizado por diferentes vistas o interfaces (por ejemplo, web, móvil o API).</li>
  <li><b>Promueve la extensibilidad:</b> nuevos comportamientos pueden añadirse sin alterar el modelo o la vista, manteniendo la arquitectura limpia y escalable.</li>
</ul>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>