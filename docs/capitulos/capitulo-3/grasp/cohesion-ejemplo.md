<h1 style="text-align:center;">
  <strong> Ejemplo: Cohesión en una Clase de Utilidades</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
La empresa busca reducir la <b>deuda técnica</b> acumulada en uno de sus proyectos más críticos.
Durante la revisión del código, se detectó que varios módulos presentan <b>baja cohesión</b>: cada clase realiza múltiples tareas sin una responsabilidad claramente definida, lo que dificulta su mantenimiento y evolución.
El objetivo del desarrollador es <b>identificar los puntos de mejora</b> en la cohesión de las clases y aplicar <b>acciones correctivas</b> que fortalezcan la arquitectura general del sistema.
</p>

<p style="text-align:justify;">
La <b>cohesión</b> se refiere al grado en que las responsabilidades de un módulo o clase están relacionadas entre sí.
Una clase con alta cohesión tiene <b>una única responsabilidad bien definida</b>, mientras que una clase con baja cohesión tiende a agrupar comportamientos dispares, actuando como un “contenedor de todo”.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Baja cohesión</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Alta cohesión</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          Clase monolítica con múltiples responsabilidades (parcheo rápido, difícil de mantener).
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-ejemplo-baja-cohesion-utilidades-java"><b>Utilidades.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          Responsabilidades separadas por dominio técnico; clases pequeñas, enfocadas y testeables.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-ejemplo-alta-cohesion-utilidadesarchivo-java"><b>UtilidadesArchivo.java</b></a></li>
          <li>▶️ <a href="#codigo-ejemplo-alta-cohesion-utilidadesdb-java"><b>UtilidadesDB.java</b></a></li>
          <li>▶️ <a href="#codigo-ejemplo-alta-cohesion-utilidadeshttp-java"><b>UtilidadesHttp.java</b></a></li>
          <li>▶️ <a href="#codigo-ejemplo-alta-cohesion-utilidadeslog-java"><b>UtilidadesLog.java</b></a></li>
          <li>▶️ <a href="#codigo-ejemplo-alta-cohesion-utilidadesparseo-java"><b>UtilidadesParseo.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML con baja cohesión</strong></h2>

<p style="text-align:justify;">
En el diseño original, la clase <code>Utilidades</code> agrupa funciones sin relación directa entre ellas, como cálculos financieros, validaciones de datos y operaciones de texto.
Esto genera una clase monolítica y difícil de mantener, ya que cualquier cambio en una de sus funciones puede afectar otras partes del sistema.
Además, el código viola el <b>Principio de Responsabilidad Única (SRP)</b> del diseño orientado a objetos.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/baja_cohesion_ejemplo_clase.png"
       width="60%" height="auto" alt="Diagrama UML de baja cohesión en una clase de utilidades"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Clase con baja cohesión: múltiples responsabilidades mezcladas.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```text
    Este ejemplo presenta clases de apoyo; no incluye un método `main` ejecutable.
    ```
=== "Correcto"

    ```text
    Este ejemplo presenta clases de apoyo; no incluye un método `main` ejecutable.
    ```
