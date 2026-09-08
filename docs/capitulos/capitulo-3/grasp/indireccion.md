<h1 style="text-align:center;">
  <strong> Indirección</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición</strong></h2>

<p style="text-align:justify;">
El principio de <b>Indirección</b> (<i>Indirection</i>) establece que, cuando dos o más clases necesitan colaborar,
es preferible introducir un <b>objeto intermediario</b> que gestione su comunicación, en lugar de permitir una interacción directa entre ellas.
Este intermediario actúa como un <b>mediador</b> o <b>enlace</b> que desacopla las dependencias, facilitando el mantenimiento, la extensión y la reutilización del sistema.
</p>

<p style="text-align:justify;">
La <b>indirección</b> es una herramienta fundamental para alcanzar un diseño con <b>bajo acoplamiento</b>,
ya que permite que las clases colaboren sin conocer los detalles de implementación unas de otras.
De esta forma, los cambios en una clase no afectan directamente a las demás, promoviendo una arquitectura más estable y adaptable a la evolución del sistema.
</p>

<hr/>

<h2><strong> Propósito</strong></h2>

<p style="text-align:justify;">
El propósito de este principio es <b>reducir las dependencias directas</b> entre componentes del sistema.
En lugar de que una clase conozca y utilice directamente otra, se introduce un elemento intermedio que administra la colaboración.
Esto facilita la evolución del código, la sustitución de componentes y la integración de nuevos comportamientos sin alterar las clases originales.
</p>

<p style="text-align:justify;">
En la práctica, la <b>indirección</b> suele manifestarse mediante el uso de interfaces, controladores, servicios, adaptadores o mediadores.
Estas estructuras se encargan de orquestar las interacciones entre las clases, asegurando que cada una mantenga una única responsabilidad y permanezca desacoplada del resto.
</p>

<hr/>

<h2><strong> Ejemplos comunes de aplicación</strong></h2>

<ul style="text-align:justify;">
  <li><b>Controladores o servicios intermedios:</b> Gestionan la comunicación entre la capa de presentación y el dominio, evitando dependencias cruzadas.</li>
  <li><b>Patrón Mediator:</b> Un objeto centralizado que coordina la interacción entre múltiples objetos sin que estos se conozcan directamente.</li>
  <li><b>Patrón Facade:</b> Proporciona una interfaz simplificada para acceder a un subsistema complejo, actuando como capa de indirección.</li>
  <li><b>Patrón Repository:</b> Oculta la lógica de acceso a datos detrás de una interfaz uniforme, desacoplando la aplicación del motor de persistencia.</li>
</ul>

<hr/>

<h2><strong> Beneficios</strong></h2>

<ul style="text-align:justify;">
  <li>Disminuye el acoplamiento directo entre componentes, incrementando la modularidad.</li>
  <li>Permite la sustitución o actualización de componentes sin afectar a las clases consumidoras.</li>
  <li>Favorece la reutilización de código al aislar responsabilidades y definir contratos claros entre capas.</li>
  <li>Facilita las pruebas unitarias, al permitir el uso de <i>mocks</i> o <i>stubs</i> que simulan el comportamiento de las dependencias reales.</li>
</ul>

<hr/>

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Capa de Control de Acceso a Datos** | Se solicita implementar un módulo genérico que permita almacenar, editar y eliminar entidades de cualquier tipo dentro de una base de datos. Por convención, todas las entidades del sistema deben poseer un identificador único para su gestión unificada. | [Ver diagramas y desplegar el código](indireccion-ejemplo.md) |

## Ejemplos y diagramas UML

### 1. Capa de Control de Acceso a Datos

Se solicita implementar un módulo genérico que permita almacenar, editar y eliminar entidades de cualquier tipo dentro de una base de datos. Por convención, todas las entidades del sistema deben poseer un identificador único para su gestión unificada.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/indireccion_ejemplo.png" alt="Diagrama UML de Capa de Control de Acceso a Datos">
  <figcaption><strong>Modelo UML.</strong> Capa de Control de Acceso a Datos.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](indireccion-ejemplo.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | Dos componentes dependen directamente y cualquier cambio se propaga entre ellos. |
| **Escenario de aplicación** | Adaptación de proveedores, repositorios, pasarelas o mecanismos de comunicación. |
| **Ventaja principal** | El intermediario reduce el conocimiento mutuo y concentra la traducción. |
| **Desventaja o precaución** | La indirección sin una variación real agrega saltos y dificulta el diagnóstico. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/indireccion/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
