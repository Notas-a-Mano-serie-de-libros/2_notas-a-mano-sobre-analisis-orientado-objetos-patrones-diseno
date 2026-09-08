<h1 style="text-align:center;">
  <strong> Variaciones Protegidas</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición</strong></h2>

<p style="text-align:justify;">
El principio de <b>Variaciones Protegidas</b> establece que los <b>puntos de cambio</b> en un sistema deben ser
<b>identificados y aislados</b> mediante el uso de <b>interfaces</b> o <b>abstracciones</b>.
Su propósito es reducir el impacto que generan las modificaciones inevitables durante el ciclo de vida del software,
garantizando que los cambios en un componente no se propaguen innecesariamente a otros módulos o clases.
</p>

<p style="text-align:justify;">
En esencia, este principio busca <b>proteger las partes estables del sistema</b> frente a las áreas susceptibles de cambio.
Cuando un diseño sigue el principio de variaciones protegidas, se facilita la evolución del sistema sin comprometer
su consistencia ni romper dependencias existentes.
</p>

<hr/>

<h2><strong> Propósito</strong></h2>

<p style="text-align:justify;">
El objetivo principal del principio de <b>Variaciones Protegidas</b> es <b>minimizar el impacto de las modificaciones</b>
y <b>promover la extensibilidad</b> del software a largo plazo.
Al encapsular los elementos variables detrás de una interfaz estable, los cambios en la implementación pueden realizarse
sin alterar el código de los clientes que dependen de ella.
</p>

<p style="text-align:justify;">
De esta manera, se logra un diseño <b>resistente a las variaciones</b>, altamente <b>modular</b> y preparado
para adaptarse a futuros requerimientos sin reescribir componentes ya probados.
</p>

<hr/>

<h2><strong> Aplicación del principio en GRASP</strong></h2>

<p style="text-align:justify;">
Dentro del marco de los principios <b>GRASP</b>, las <b>Variaciones Protegidas</b> se aplican cuando
se prevé que una parte del sistema —por ejemplo, un algoritmo, un proveedor externo o una regla de negocio—
pueda cambiar en el futuro.
</p>

<p style="text-align:justify;">
En lugar de acoplar directamente estos elementos a las clases que los utilizan, se define una <b>abstracción</b>
(como una interfaz o clase abstracta) que actúa como punto de estabilidad.
Las implementaciones concretas pueden variar libremente mientras la abstracción se mantenga inmutable.
</p>

<p style="text-align:justify;">
Por ejemplo, un sistema que permite el <b>procesamiento de pagos</b> puede definir una interfaz <code>ProcesadorPago</code>
con implementaciones como <code>PagoTarjeta</code>, <code>PagoTransferencia</code> y <code>PagoCriptomoneda</code>.
Si en el futuro se incorpora un nuevo método de pago, el cambio afectará únicamente a la nueva implementación,
sin alterar la lógica existente del sistema.
</p>

<hr/>

<h2><strong> Beneficios</strong></h2>

<ul style="text-align:justify;">
  <li>Reduce el riesgo de efectos colaterales ante cambios o ampliaciones del sistema.</li>
  <li>Facilita la integración de nuevas funcionalidades sin modificar las clases existentes.</li>
  <li>Promueve el diseño orientado a interfaces, favoreciendo el desacoplamiento estructural.</li>
  <li>Incrementa la mantenibilidad, escalabilidad y longevidad del software.</li>
  <li>Permite evolucionar el sistema con un costo mínimo de refactorización.</li>
</ul>

<hr/>

<h2><strong> Ejemplo conceptual</strong></h2>

<p style="text-align:justify;">
Un ejemplo clásico de aplicación de este principio se observa en los <b>patrones de diseño</b> como
<code>Strategy</code> o <code>Factory Method</code>, donde las variaciones en el comportamiento o
la creación de objetos están encapsuladas detrás de interfaces comunes.
</p>

<p style="text-align:justify;">
De esta forma, un sistema puede cambiar su algoritmo de cálculo, su proveedor de datos o su lógica de persistencia
simplemente reemplazando una implementación concreta, sin modificar las dependencias externas.
</p>

<hr/>

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Pasarela de pago** | Se solicita diseñar un sistema que permita realizar pagos utilizando distintos métodos, entre ellos: tarjeta de crédito , PayPal y pago seguro en línea (PSE) . Además, el cliente ha indicado que en el futuro podrían agregarse nuevos medios de pago, por lo que la solución debe ser fácilmente extensible sin requerir modificaciones en la lógica existente. | [Ver diagramas y desplegar el código](variacion_protegida-ejemplo.md) |

## Ejemplos y diagramas UML

### 1. Pasarela de pago

Se solicita diseñar un sistema que permita realizar pagos utilizando distintos métodos, entre ellos: tarjeta de crédito , PayPal y pago seguro en línea (PSE) . Además, el cliente ha indicado que en el futuro podrían agregarse nuevos medios de pago, por lo que la solución debe ser fácilmente extensible sin requerir modificaciones en la lógica existente.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/variacion_protegida_ejemplo.png" alt="Diagrama UML de Pasarela de pago">
  <figcaption><strong>Modelo UML.</strong> Pasarela de pago.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](variacion_protegida-ejemplo.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | Un elemento inestable expone sus cambios al resto del sistema. |
| **Escenario de aplicación** | APIs externas, formatos, motores de cálculo o políticas que evolucionan. |
| **Ventaja principal** | Una frontera estable concentra el impacto de la variación. |
| **Desventaja o precaución** | Predecir cambios inexistentes genera abstracciones especulativas. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/variacion_protegida/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
