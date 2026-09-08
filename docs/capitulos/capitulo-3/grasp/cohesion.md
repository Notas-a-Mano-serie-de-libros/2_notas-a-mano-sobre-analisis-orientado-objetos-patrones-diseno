<h1 style="text-align:center;">
  <strong> Alta Cohesión</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición general</strong></h2>

<p style="text-align:justify;">
La <b>cohesión</b> representa el grado en que los elementos dentro de una unidad de software —ya sea una clase, módulo o componente— están <b>estrechamente relacionados</b> y <b>colaboran entre sí</b> para cumplir una única responsabilidad claramente definida.
Este principio promueve que cada componente mantenga un <b>propósito específico</b> y que todas sus partes trabajen de forma conjunta hacia un mismo objetivo.
</p>

<p style="text-align:justify;">
En un diseño de software bien estructurado, la cohesión debe ser <b>alta</b>: es decir, el módulo realiza una sola tarea o un conjunto de tareas íntimamente relacionadas.
Por el contrario, una <b>baja cohesión</b> sugiere que el módulo mezcla responsabilidades no relacionadas, lo que incrementa la complejidad, dificulta el mantenimiento y reduce la reutilización del código.
</p>

<hr/>

<h2><strong> Tipos de cohesión (de más débil a más fuerte)</strong></h2>

<table style="width:100%; border-collapse:collapse; border:1px solid #ccc; font-size:15px;">
  <thead style="background-color:#f2f2f2;">
    <tr>
      <th style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Tipo de cohesión</b></th>
      <th style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Descripción</b></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Coincidental</b></td>
      <td style="border:1px solid #ccc; padding:8px; text-align:justify;">Los métodos o funciones de un módulo no guardan relación alguna entre sí. Es el nivel más bajo de cohesión.</td>
    </tr>
    <tr>
      <td style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Lógica</b></td>
      <td style="border:1px solid #ccc; padding:8px; text-align:justify;">Las operaciones están agrupadas por similitud lógica (por ejemplo, entrada/salida), aunque no compartan datos o propósito común.</td>
    </tr>
    <tr>
      <td style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Temporal</b></td>
      <td style="border:1px solid #ccc; padding:8px; text-align:justify;">Los métodos se agrupan porque ocurren en el mismo momento o fase del programa (por ejemplo, inicialización).</td>
    </tr>
    <tr>
      <td style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Procedimental</b></td>
      <td style="border:1px solid #ccc; padding:8px; text-align:justify;">Los elementos están relacionados porque se ejecutan secuencialmente dentro de un mismo flujo, sin necesariamente compartir un mismo objetivo.</td>
    </tr>
    <tr>
      <td style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Comunicacional</b></td>
      <td style="border:1px solid #ccc; padding:8px; text-align:justify;">Las operaciones comparten los mismos datos o estructuras de información, trabajando de forma conjunta hacia un objetivo común.</td>
    </tr>
    <tr>
      <td style="border:1px solid #ccc; padding:8px; text-align:center;"><b>Funcional</b></td>
      <td style="border:1px solid #ccc; padding:8px; text-align:justify;">Todas las operaciones contribuyen directamente a una única función o tarea principal. Representa el nivel más alto de cohesión.</td>
    </tr>
  </tbody>
</table>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Tabla 1.</b> Clasificación de los niveles de cohesión según Stevens, Myers y Constantine (1974).
</p>

<hr/>

<h2><strong> Importancia de la alta cohesión</strong></h2>

<ul style="text-align:justify;">
  <li><b>Mantenimiento más sencillo:</b> los cambios en un módulo tienen un impacto mínimo en otros componentes.</li>
  <li><b>Mayor reutilización:</b> los módulos con una única responsabilidad son más fáciles de reutilizar en otros proyectos.</li>
  <li><b>Pruebas más efectivas:</b> cada módulo puede probarse de forma aislada y predecible.</li>
  <li><b>Claridad y legibilidad:</b> un módulo con alta cohesión expresa claramente su propósito, reduciendo la carga cognitiva del desarrollador.</li>
</ul>

<hr/>

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Cohesión en una Clase de Utilidades** | La empresa busca reducir la deuda técnica acumulada en uno de sus proyectos más críticos. Durante la revisión del código, se detectó que varios módulos presentan baja cohesión : cada clase realiza múltiples tareas sin una responsabilidad claramente definida, lo que dificulta su mantenimiento y evolución. El objetivo del desarrollador es identificar los puntos de mejora en la cohesión de las clases y aplicar acciones correctivas que fortalezcan la arquitectura general del sistema. | [Ver diagramas y desplegar el código](cohesion-ejemplo.md) |

## Ejemplos y diagramas UML

### 1. Cohesión en una Clase de Utilidades

La empresa busca reducir la deuda técnica acumulada en uno de sus proyectos más críticos. Durante la revisión del código, se detectó que varios módulos presentan baja cohesión : cada clase realiza múltiples tareas sin una responsabilidad claramente definida, lo que dificulta su mantenimiento y evolución. El objetivo del desarrollador es identificar los puntos de mejora en la cohesión de las clases y aplicar acciones correctivas que fortalezcan la arquitectura general del sistema.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/baja_cohesion_ejemplo_clase.png" alt="Diagrama UML de Cohesión en una Clase de Utilidades">
  <figcaption><strong>Modelo UML.</strong> Cohesión en una Clase de Utilidades, vista 1.</figcaption>
</figure>

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/alta_cohesion_ejemplo_clase.png" alt="Diagrama UML de Cohesión en una Clase de Utilidades">
  <figcaption><strong>Modelo UML.</strong> Cohesión en una Clase de Utilidades, vista 2.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](cohesion-ejemplo.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | Una clase reúne operaciones que cambian por motivos distintos. |
| **Escenario de aplicación** | Separación de utilidades de archivos, base de datos, HTTP, registro y conversión. |
| **Ventaja principal** | Cada componente conserva un propósito reconocible y puede probarse de forma aislada. |
| **Desventaja o precaución** | Dividir sin criterio produce clases diminutas y lógica fragmentada. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/cohesion/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
