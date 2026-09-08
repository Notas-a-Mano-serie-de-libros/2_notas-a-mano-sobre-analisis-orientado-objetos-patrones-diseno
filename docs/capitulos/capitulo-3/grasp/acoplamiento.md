<h1 style="text-align:center;">
  <strong> Bajo Acoplamiento</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición general</strong></h2>

<p style="text-align:justify;">
El <b>acoplamiento</b> se refiere al grado de dependencia o conexión que existe entre los componentes de un sistema.
Cuanto más dependientes sean los módulos entre sí, mayor será el acoplamiento y, por tanto, más difícil será modificar, probar o reutilizar el código sin afectar a otras partes del sistema.
</p>

<p style="text-align:justify;">
El <b>principio de bajo acoplamiento</b> promueve el diseño de <b>componentes autónomos y poco dependientes</b> entre sí, de modo que los cambios realizados en un módulo tengan un impacto mínimo en los demás.
En términos generales, un buen diseño de software busca maximizar la <b>cohesión interna</b> y minimizar el <b>acoplamiento externo</b>.
</p>

<hr/>

<h2><strong> Tipos de dependencia</strong></h2>

<p style="text-align:justify;">
En la práctica, la dependencia puede manifestarse de diferentes formas según cómo los módulos se relacionen entre sí:
</p>

<ul style="text-align:justify;">
  <li>
    <b>Dependencia externa:</b> ocurre cuando un módulo requiere información, servicios o resultados de otro módulo para completar su funcionamiento.
    Por ejemplo, un componente de <em>pago</em> que depende directamente de la respuesta de un módulo de <em>autenticación</em> antes de ejecutar su operación.
  </li>
  <li>
    <b>Dependencia bidireccional:</b> se presenta cuando dos módulos dependen mutuamente para su ejecución, lo que genera un acoplamiento fuerte y una arquitectura difícil de mantener.
    Por ejemplo, si un módulo <em>A</em> llama a funciones de <em>B</em> y viceversa, cualquier cambio en uno puede causar fallos en el otro.
  </li>
</ul>

<hr/>

<h2><strong> Beneficios del bajo acoplamiento</strong></h2>

<ul style="text-align:justify;">
  <li><b>Facilidad de mantenimiento:</b> los cambios en un módulo tienen un efecto mínimo en otros.</li>
  <li><b>Alta reutilización:</b> los componentes pueden ser utilizados en diferentes contextos sin requerir modificaciones.</li>
  <li><b>Pruebas más simples:</b> los módulos pueden probarse de manera independiente, facilitando la detección de errores.</li>
  <li><b>Escalabilidad y extensibilidad:</b> el sistema puede crecer o modificarse con mayor facilidad, al incorporar o reemplazar módulos sin romper el conjunto.</li>
</ul>

<hr/>

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Servicio de Notificaciones** | Se solicita diseñar un sistema que permita enviar alertas personalizadas a los usuarios. El sistema debe ser capaz de manejar distintos canales de comunicación, como correo electrónico , mensajes SMS y notificaciones push . Además, la arquitectura debe ser lo suficientemente flexible como para permitir la incorporación de nuevos tipos de mensajes en el futuro sin requerir modificaciones sustanciales en el código existente. | [Ver diagramas y desplegar el código](acoplamiento-ejemplo.md) |

## Ejemplos y diagramas UML

### 1. Servicio de Notificaciones

Se solicita diseñar un sistema que permita enviar alertas personalizadas a los usuarios. El sistema debe ser capaz de manejar distintos canales de comunicación, como correo electrónico , mensajes SMS y notificaciones push . Además, la arquitectura debe ser lo suficientemente flexible como para permitir la incorporación de nuevos tipos de mensajes en el futuro sin requerir modificaciones sustanciales en el código existente.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/alto_acoplamiento_ejemplo.png" alt="Diagrama UML de Servicio de Notificaciones">
  <figcaption><strong>Modelo UML.</strong> Servicio de Notificaciones, vista 1.</figcaption>
</figure>

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/bajo_acoplamiento_ejemplo.png" alt="Diagrama UML de Servicio de Notificaciones">
  <figcaption><strong>Modelo UML.</strong> Servicio de Notificaciones, vista 2.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](acoplamiento-ejemplo.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | Un cambio en un colaborador obliga a modificar muchos consumidores. |
| **Escenario de aplicación** | Integración con servicios de notificación, persistencia o proveedores sustituibles. |
| **Ventaja principal** | Los cambios quedan aislados detrás de contratos pequeños. |
| **Desventaja o precaución** | Demasiadas capas de indirección dificultan seguir el flujo. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/acoplamiento/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
