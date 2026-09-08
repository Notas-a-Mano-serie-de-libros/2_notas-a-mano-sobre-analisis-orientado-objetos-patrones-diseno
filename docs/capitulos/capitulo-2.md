<nav class="chapter-nav" aria-label="Navegación superior entre capítulos"><a href="../capitulo-1/">← Capítulo 1</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-3/">Capítulo 3 →</a></nav>

# Capítulo 2 · Introducción al diseño orientado a objetos

<span class="chapter-kicker">Conceptos y relaciones</span>

Este capítulo establece el lenguaje con el que se describen los diseños del resto de la obra. La orientación a objetos no consiste únicamente en agrupar datos dentro de clases: exige reconocer conceptos del dominio, asignarles responsabilidades y expresar con precisión cómo colaboran.

<div class="lab-action" markdown>
[:octicons-codespaces-16: Preparar los ejemplos de este capítulo](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub con acceso a Codespaces. El entorno instala Java 11 y prepara Maven automáticamente. Consulta la <a href="../codespaces/">guía de preparación</a> y ejecuta <code>./mvnw -q test</code> antes de explorar los ejemplos.</span>
</div>

## 2.1 Abstracción: elegir qué representa el modelo

Abstraer significa seleccionar las propiedades y operaciones relevantes de una entidad para el problema que se intenta resolver. Una misma entidad puede producir modelos distintos: para una biblioteca, una persona puede interesar como autora; para un sistema financiero, como titular de una cuenta. Ninguna abstracción es completa fuera de su contexto.

<figure class="uml-figure">
  <img src="../../assets/images/contenido/poo/abstraccion.png" alt="Representación UML del proceso de abstracción">
  <figcaption><strong>Figura 2.1.</strong> La abstracción conserva las características útiles para el propósito del sistema.</figcaption>
</figure>

!!! question "Problema que se aborda"
    Un modelo que reproduce todos los detalles del mundo real se vuelve inmanejable; uno que omite información esencial no puede cumplir sus casos de uso. La decisión consiste en conservar únicamente el conocimiento necesario para las responsabilidades actuales.

La abstracción aporta un vocabulario compartido, reduce la complejidad y permite razonar sobre el sistema. Su riesgo es confundir el modelo con la realidad: cuando cambia el propósito, también puede cambiar la abstracción adecuada.

## 2.2 Clases y objetos

Una **clase** define la estructura y el comportamiento común de un conjunto de elementos. Un **objeto** es una instancia concreta que posee identidad, estado y comportamiento durante la ejecución. La clase describe posibilidades; el objeto materializa una configuración particular.

<div class="uml-gallery">
  <figure class="uml-figure">
    <img src="../../assets/images/contenido/poo/clase.png" alt="Representación UML de una clase">
    <figcaption><strong>Figura 2.2.</strong> Nombre, atributos y operaciones de una clase.</figcaption>
  </figure>
  <figure class="uml-figure">
    <img src="../../assets/images/contenido/poo/objeto.png" alt="Representación UML de un objeto">
    <figcaption><strong>Figura 2.3.</strong> Un objeto mantiene valores concretos y una identidad.</figcaption>
  </figure>
</div>

En UML, una clase suele representarse mediante tres compartimentos: nombre, atributos y operaciones. La visibilidad se expresa con `+` para público, `-` para privado, `#` para protegido y `~` para acceso de paquete. El detalle del diagrama debe responder a la pregunta que se estudia; no siempre es necesario mostrar todos los métodos.

<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/clase_detalle.png" alt="Detalle de atributos, operaciones y visibilidad de una clase UML">
  <figcaption><strong>Figura 2.4.</strong> Notación detallada de una clase en UML.</figcaption>
</figure>

| Elemento | Pregunta de diseño | Error frecuente |
| --- | --- | --- |
| Identidad | ¿Dos instancias con el mismo estado siguen representando elementos distintos? | Comparar objetos únicamente por sus atributos. |
| Estado | ¿Qué información necesita conservar el objeto? | Exponer datos sin proteger sus invariantes. |
| Comportamiento | ¿Qué operaciones corresponden naturalmente a esta responsabilidad? | Crear clases que solo contienen datos y trasladar toda la lógica a servicios externos. |

## 2.3 Encapsulamiento y visibilidad

Encapsular significa mantener juntas la información y las operaciones que protegen su consistencia, ocultando decisiones internas detrás de una interfaz estable. Declarar atributos privados es una herramienta, no el objetivo completo: un objeto también debe impedir estados inválidos y evitar que sus clientes dependan de detalles que pueden cambiar.

<div class="uml-gallery uml-gallery--four">
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/encapsulamiento/private.png" alt="Visibilidad privada en UML"><figcaption>Privado (`-`)</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/encapsulamiento/protected.png" alt="Visibilidad protegida en UML"><figcaption>Protegido (`#`)</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/encapsulamiento/default.png" alt="Visibilidad de paquete en UML"><figcaption>Paquete (`~`)</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/encapsulamiento/public.png" alt="Visibilidad pública en UML"><figcaption>Público (`+`)</figcaption></figure>
</div>

Una interfaz pública pequeña reduce el acoplamiento y facilita cambiar la representación interna. Sin embargo, ocultar indiscriminadamente también puede producir objetos difíciles de usar. La visibilidad correcta es la mínima que permite la colaboración prevista.

## 2.4 Herencia, clases abstractas e interfaces

La herencia expresa una relación de especialización: el subtipo debe poder utilizarse donde se espera el tipo general sin romper su contrato. Es apropiada cuando existe una relación conceptual **es-un** y cuando las variantes comparten expectativas estables; no debe emplearse solo para ahorrar líneas de código.

<div class="uml-gallery">
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/herencia/herencia.png" alt="Relación de herencia en UML"><figcaption><strong>Figura 2.5.</strong> Generalización entre tipos.</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/herencia/clase_abstracta.png" alt="Clase abstracta en UML"><figcaption><strong>Figura 2.6.</strong> Una clase abstracta comparte estado o implementación.</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/herencia/interface.png" alt="Realización de una interfaz en UML"><figcaption><strong>Figura 2.7.</strong> Una interfaz define un contrato realizable por varios tipos.</figcaption></figure>
</div>

| Mecanismo | Úsalo cuando | Evítalo cuando |
| --- | --- | --- |
| Clase concreta | El concepto puede instanciarse y su comportamiento está completo. | Solo representa una categoría incompleta. |
| Clase abstracta | Las variantes comparten estado, reglas o una plantilla de comportamiento. | La jerarquía no representa sustitución real. |
| Interfaz | Distintos tipos deben cumplir el mismo contrato sin compartir implementación. | El contrato obliga a métodos que algunos clientes no necesitan. |
| Composición | Un objeto puede delegar una capacidad intercambiable a otro. | La relación de pertenencia o ciclo de vida no es clara. |

## 2.5 Polimorfismo

El polimorfismo permite enviar el mismo mensaje a objetos diferentes y obtener el comportamiento correspondiente a su tipo concreto. Evita que el cliente acumule condicionales para distinguir cada variante y prepara el terreno para principios como OCP y patrones como Strategy, State o Factory Method.

<div class="uml-gallery">
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/polimorfismo/polimorfismo_basico.png" alt="Polimorfismo mediante un contrato común"><figcaption><strong>Figura 2.8.</strong> Variantes detrás de un contrato común.</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/polimorfismo/sobrecarga.png" alt="Sobrecarga de operaciones"><figcaption><strong>Figura 2.9.</strong> Sobrecarga: mismo nombre, firmas distintas.</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/polimorfismo/sobrescritura.png" alt="Sobrescritura de una operación heredada"><figcaption><strong>Figura 2.10.</strong> Sobrescritura: un subtipo especializa el comportamiento.</figcaption></figure>
</div>

La ventaja principal es separar al cliente de las decisiones concretas. El costo aparece cuando la jerarquía no conserva un contrato coherente: una implementación que sorprende al cliente introduce errores aunque el código compile.

## 2.6 Relaciones entre clases y objetos

Las relaciones UML comunican quién conoce a quién, quién depende de quién y qué ocurre con el ciclo de vida de las partes. Elegir la relación correcta evita que el diagrama oculte decisiones importantes.

### 2.6.1 Asociación y dependencia

Una **asociación** representa un vínculo estructural que suele conservarse como atributo. Una **dependencia** es más débil y temporal: aparece, por ejemplo, cuando una clase recibe otra como parámetro o la usa dentro de una operación.

<div class="uml-gallery">
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/relaciones/asociacion/asociacion.png" alt="Notación UML de una asociación"><figcaption><strong>Figura 2.11.</strong> Asociación estructural.</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/relaciones/dependencia/dependencia.png" alt="Notación UML de una dependencia"><figcaption><strong>Figura 2.12.</strong> Dependencia temporal.</figcaption></figure>
</div>

### 2.6.2 Agregación y composición

Ambas expresan relaciones entre un todo y sus partes. En la **agregación**, la parte puede existir y compartirse independientemente del todo. En la **composición**, el todo controla el ciclo de vida de la parte y su pertenencia suele ser exclusiva.

<div class="uml-gallery">
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/relaciones/agregacion/agregacion_ejemplo1.png" alt="Ejemplo UML de agregación"><figcaption><strong>Figura 2.13.</strong> Agregación: la parte conserva independencia.</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/relaciones/composicion/composicion_ejemplo1.png" alt="Ejemplo UML de composición"><figcaption><strong>Figura 2.14.</strong> Composición: ciclo de vida controlado por el todo.</figcaption></figure>
</div>

### 2.6.3 Generalización y realización

La **generalización** conecta un subtipo con una clase más general. La **realización** indica que una clase concreta cumple el contrato definido por una interfaz. En ambos casos debe existir sustitución válida, no solo semejanza estructural.

<div class="uml-gallery">
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/relaciones/generalizacion/generalizacion.png" alt="Generalización entre clases en UML"><figcaption><strong>Figura 2.15.</strong> Generalización de clases.</figcaption></figure>
  <figure class="uml-figure"><img src="../../assets/images/contenido/poo/relaciones/generalizacion/generalizacion_interfaz.png" alt="Realización de interfaz en UML"><figcaption><strong>Figura 2.16.</strong> Realización de una interfaz.</figcaption></figure>
</div>

| Relación | Señal en el código | Pregunta para reconocerla |
| --- | --- | --- |
| Dependencia | Parámetro, variable local o llamada puntual. | ¿El colaborador solo se necesita durante una operación? |
| Asociación | Campo o referencia persistente. | ¿Los objetos deben conocerse durante parte de su vida? |
| Agregación | El todo recibe o comparte una parte ya creada. | ¿La parte puede existir sin este todo? |
| Composición | El todo crea y administra la parte. | ¿La parte pierde sentido o vida al desaparecer el todo? |
| Generalización | `extends`. | ¿El subtipo cumple todas las expectativas del tipo base? |
| Realización | `implements`. | ¿La clase satisface un contrato sin heredar implementación? |

## 2.7 Del modelo al código

Los diagramas UML no sustituyen el código ni deben reproducirlo línea por línea. Su función es mostrar las decisiones que ayudan a comprender un problema: responsabilidades, contratos, dependencias, multiplicidades y puntos de variación. En Java, esas decisiones se materializan mediante clases, interfaces, campos, parámetros, composición y jerarquías.

!!! success "Criterio de cierre"
    Antes de avanzar a GRASP y SOLID, comprueba que puedes justificar quién conoce cada dato, quién crea cada objeto, qué relación controla el ciclo de vida y qué contrato permite sustituir una implementación.

[Explorar el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro){ .md-button }

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../capitulo-1/">← Capítulo 1</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-3/">Capítulo 3 →</a></nav>
