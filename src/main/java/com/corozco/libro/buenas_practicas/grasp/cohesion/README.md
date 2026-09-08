<h1 style="text-align:center;">
  <strong>🧭 Principio de Alta Cohesión</strong>
</h1>

<hr/>

<h2><strong>📘 Definición general</strong></h2>

<p style="text-align:justify;">
La <b>cohesión</b> representa el grado en que los elementos dentro de una unidad de software —ya sea una clase, módulo o componente— están <b>estrechamente relacionados</b> y <b>colaboran entre sí</b> para cumplir una única responsabilidad claramente definida.  
Este principio promueve que cada componente mantenga un <b>propósito específico</b> y que todas sus partes trabajen de forma conjunta hacia un mismo objetivo.
</p>

<p style="text-align:justify;">
En un diseño de software bien estructurado, la cohesión debe ser <b>alta</b>: es decir, el módulo realiza una sola tarea o un conjunto de tareas íntimamente relacionadas.  
Por el contrario, una <b>baja cohesión</b> sugiere que el módulo mezcla responsabilidades no relacionadas, lo que incrementa la complejidad, dificulta el mantenimiento y reduce la reutilización del código.
</p>

<hr/>

<h2><strong>⚙️ Tipos de cohesión (de más débil a más fuerte)</strong></h2>

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

<h2><strong>💡 Importancia de la alta cohesión</strong></h2>

<ul style="text-align:justify;">
  <li><b>Mantenimiento más sencillo:</b> los cambios en un módulo tienen un impacto mínimo en otros componentes.</li>
  <li><b>Mayor reutilización:</b> los módulos con una única responsabilidad son más fáciles de reutilizar en otros proyectos.</li>
  <li><b>Pruebas más efectivas:</b> cada módulo puede probarse de forma aislada y predecible.</li>
  <li><b>Claridad y legibilidad:</b> un módulo con alta cohesión expresa claramente su propósito, reduciendo la carga cognitiva del desarrollador.</li>
</ul>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>