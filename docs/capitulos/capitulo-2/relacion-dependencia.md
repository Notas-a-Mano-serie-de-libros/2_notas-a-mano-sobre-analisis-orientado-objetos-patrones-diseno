# Dependencia

Una dependencia expresa un uso puntual: el colaborador llega como parámetro, variable local o valor de retorno, pero no queda almacenado como parte estable del estado del objeto. UML la representa con una flecha discontinua.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/relaciones/dependencia/dependencia_ejemplo.png" alt="Dependencias temporales de una impresora"><figcaption><strong>Figura 2.16.</strong> `Impresora` utiliza `Papel` durante la operación y produce un `Documento`.</figcaption></figure>

??? example "Código genérico · dependencia"

    ```java
    class Documento { }
    class Papel { void preparar() { } }

    class Impresora {
        Documento imprimir(Papel papel) {
            papel.preparar();
            return new Documento();
        }
    }
    ```

<a id="agregacion"></a>
