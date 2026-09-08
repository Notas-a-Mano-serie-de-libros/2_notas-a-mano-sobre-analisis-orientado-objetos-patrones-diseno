<h1 style="text-align:center;">
  <strong>🔗 Principio de Bajo Acoplamiento</strong>
</h1>

<hr/>

<h2><strong>📘 Definición general</strong></h2>

<p style="text-align:justify;">
El <b>acoplamiento</b> se refiere al grado de dependencia o conexión que existe entre los componentes de un sistema.  
Cuanto más dependientes sean los módulos entre sí, mayor será el acoplamiento y, por tanto, más difícil será modificar, probar o reutilizar el código sin afectar a otras partes del sistema.
</p>

<p style="text-align:justify;">
El <b>principio de bajo acoplamiento</b> promueve el diseño de <b>componentes autónomos y poco dependientes</b> entre sí, de modo que los cambios realizados en un módulo tengan un impacto mínimo en los demás.  
En términos generales, un buen diseño de software busca maximizar la <b>cohesión interna</b> y minimizar el <b>acoplamiento externo</b>.
</p>

<hr/>

<h2><strong>⚙️ Tipos de dependencia</strong></h2>

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

<h2><strong>💡 Beneficios del bajo acoplamiento</strong></h2>

<ul style="text-align:justify;">
  <li><b>Facilidad de mantenimiento:</b> los cambios en un módulo tienen un efecto mínimo en otros.</li>
  <li><b>Alta reutilización:</b> los componentes pueden ser utilizados en diferentes contextos sin requerir modificaciones.</li>
  <li><b>Pruebas más simples:</b> los módulos pueden probarse de manera independiente, facilitando la detección de errores.</li>
  <li><b>Escalabilidad y extensibilidad:</b> el sistema puede crecer o modificarse con mayor facilidad, al incorporar o reemplazar módulos sin romper el conjunto.</li>
</ul>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>