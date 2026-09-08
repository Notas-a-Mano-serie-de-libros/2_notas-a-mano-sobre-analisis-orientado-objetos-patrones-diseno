# Abstracción

Abstraer significa seleccionar las propiedades y operaciones relevantes de una entidad para el problema que se intenta resolver. Una misma entidad puede producir modelos distintos: para una biblioteca, una persona puede interesar como autora; para un sistema financiero, como titular de una cuenta. Ninguna abstracción es completa fuera de su contexto.

**Accesos directos a los ejemplos**

| Elemento | Acceso |
| --- | --- |
| Representación visual | [Figura de abstracción](#abstraccion-visual) |
| Modelo ejecutable | [Código genérico en Java](#codigo-abstraccion) |

<a id="abstraccion-visual"></a>

<figure class="uml-figure">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/abstraccion.png" alt="Representación UML del proceso de abstracción">
  <figcaption><strong>Figura 2.1.</strong> La abstracción conserva las características útiles para el propósito del sistema.</figcaption>
</figure>

!!! question "Problema que se aborda"
    Un modelo que reproduce todos los detalles del mundo real se vuelve inmanejable; uno que omite información esencial no puede cumplir sus casos de uso. La decisión consiste en conservar únicamente el conocimiento necesario para las responsabilidades actuales.

La abstracción aporta un vocabulario compartido, reduce la complejidad y permite razonar sobre el sistema. Su riesgo es confundir el modelo con la realidad: cuando cambia el propósito, también puede cambiar la abstracción adecuada.

<a id="codigo-abstraccion"></a>
??? example "Código genérico · una abstracción ajustada al propósito"

    ```java
    final class AutorBiblioteca {
        private final String nombre;
        private final String identificador;

        AutorBiblioteca(String nombre, String identificador) {
            this.nombre = nombre;
            this.identificador = identificador;
        }

        String referenciaBibliografica() {
            return nombre + " (" + identificador + ")";
        }
    }
    ```

El modelo conserva únicamente los datos y el comportamiento que necesita el catálogo. Otros rasgos de la persona, aunque existan en el mundo real, no pertenecen a esta abstracción.

