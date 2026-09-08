<h1 style="text-align:center;">
  <strong> Polimorfismo</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Definición</strong></h2>

<p style="text-align:justify;">
El principio de <b>Polimorfismo</b> propone utilizar la capacidad de los objetos para
<b>adoptar diferentes comportamientos</b> según su tipo concreto en tiempo de ejecución.
A través de la <b>sobrescritura</b> y la <b>sobredefinición</b> de métodos, las clases derivadas pueden modificar
o especializar el comportamiento definido por sus superclases o interfaces.
</p>

<p style="text-align:justify;">
Este principio constituye uno de los <b>cuatro pilares fundamentales</b> de la programación orientada a objetos
(estudiados en el <i>Capítulo 2</i>), junto con la abstracción, la encapsulación y la herencia.
El polimorfismo permite construir sistemas extensibles, en los que el comportamiento de los objetos puede variar
sin que sea necesario modificar el código que los utiliza.
</p>

<hr/>

<h2><strong> Propósito</strong></h2>

<p style="text-align:justify;">
El propósito del principio de <b>Polimorfismo</b> es <b>reducir las dependencias condicionales</b> entre componentes,
reemplazando las estructuras de control rígidas (como condicionales o sentencias <code>switch</code>)
por llamadas a métodos polimórficos.
De esta manera, se delega el comportamiento en las subclases, haciendo que el sistema sea más <b>abierto a la extensión</b>
y <b>cerrado a la modificación</b>, en coherencia con el principio <i>Open/Closed</i>.
</p>

<hr/>

<h2><strong> Aplicación del principio en GRASP</strong></h2>

<p style="text-align:justify;">
En el contexto de los principios <b>GRASP</b>, el <b>Polimorfismo</b> se aplica cuando existen
<b>comportamientos que varían según el tipo de objeto</b> pero comparten una misma interfaz o contrato.
En lugar de incluir lógica condicional para distinguir entre tipos,
cada clase concreta implementa su propia versión del comportamiento.
</p>

<p style="text-align:justify;">
Esto promueve un diseño más flexible y robusto, donde el sistema puede incorporar nuevas variantes de comportamiento
sin alterar el código existente. Por ejemplo, una interfaz <code>Notificador</code> podría ser implementada por
<code>EmailNotificador</code>, <code>SMSNotificador</code> o <code>PushNotificador</code>,
cada una con su propia lógica de envío de mensajes.
</p>

<hr/>

<h2><strong> Beneficios</strong></h2>

<ul style="text-align:justify;">
  <li>Elimina la necesidad de estructuras condicionales extensas para manejar distintos tipos de objetos.</li>
  <li>Favorece la <b>extensibilidad</b> del sistema: agregar nuevos comportamientos no implica modificar el código existente.</li>
  <li>Incrementa la <b>cohesión</b> y reduce el <b>acoplamiento</b> entre clases.</li>
  <li>Facilita la integración de nuevos módulos o estrategias de comportamiento dinámico.</li>
  <li>Permite aplicar patrones de diseño basados en interfaces, como <i>Strategy</i> o <i>State</i>.</li>
</ul>

<hr/>

<h2><strong> Ejemplo conceptual</strong></h2>

<p style="text-align:justify;">
Un ejemplo clásico del principio de <b>Polimorfismo</b> se presenta en sistemas que gestionan diferentes tipos de pagos.
Cada subclase —<code>PagoTarjeta</code>, <code>PagoEfectivo</code>, <code>PagoDigital</code>—
implementa su propio método <code>procesar()</code>, pero todas comparten la misma interfaz <code>Pago</code>.
El cliente del sistema invoca <code>pago.procesar()</code> sin conocer el tipo concreto de pago,
logrando así un comportamiento dinámico y flexible.
</p>

<hr/>

## Accesos directos a los ejemplos

| Ejemplo | Qué permite analizar | Acceso |
| --- | --- | --- |
| **Calcular el área de varias figuras geométricas** | Se solicita diseñar una aplicación capaz de calcular el área de distintas figuras geométricas . El sistema debe ser extensible, de modo que se puedan incorporar nuevas figuras sin necesidad de modificar el código existente. Entre las figuras iniciales se incluyen el cuadrado y el círculo . | [Ver diagramas y desplegar el código](polimorfismo-ejemplo.md) |

## Ejemplos y diagramas UML

### 1. Calcular el área de varias figuras geométricas

Se solicita diseñar una aplicación capaz de calcular el área de distintas figuras geométricas . El sistema debe ser extensible, de modo que se puedan incorporar nuevas figuras sin necesidad de modificar el código existente. Entre las figuras iniciales se incluyen el cuadrado y el círculo .

<figure class="uml-figure uml-figure--wide">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/polimorfismo_ejemplo.png" alt="Diagrama UML de Calcular el área de varias figuras geométricas">
  <figcaption><strong>Modelo UML.</strong> Calcular el área de varias figuras geométricas.</figcaption>
</figure>

[Estudiar el caso y desplegar su código Java](polimorfismo-ejemplo.md){ .md-button }

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | Condicionales repetidos seleccionan comportamiento según el tipo de objeto. |
| **Escenario de aplicación** | Variantes de cálculo, pago, exportación, notificación o procesamiento. |
| **Ventaja principal** | El cliente usa un contrato común y nuevas variantes pueden agregarse con menor impacto. |
| **Desventaja o precaución** | Un contrato demasiado general puede ocultar diferencias que los clientes sí necesitan conocer. |


<hr/>

## Bibliografía
<ul style="text-align:justify;">
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development.</i> Prentice Hall.</li>
  <li>Stevens, W. P., Myers, G. J., & Constantine, L. L. (1974). <i>Structured Design.</i></li>
  <li>Yourdon, E., & Constantine, L. L. (1979). <i>Structured Design: Fundamentals of a Discipline of Computer Program and System Design.</i></li>
</ul>

---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo3/grasp/polimorfismo/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
