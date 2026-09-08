# Generalización

La generalización conecta un subtipo con una clase más general. La línea continua termina en un triángulo vacío que apunta a la superclase y en Java se materializa con `extends`.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/relaciones/generalizacion/generalizacion.png" alt="Generalización de tres subclases hacia una clase base"><figcaption><strong>Figura 2.21.</strong> Varios subtipos comparten un contrato definido por la clase general.</figcaption></figure>

??? example "Código genérico · generalización"

    ```java
    class MedioPago { void pagar(double valor) { } }
    class Tarjeta extends MedioPago { }
    class Transferencia extends MedioPago { }
    ```

<a id="realizacion"></a>
