# Asociación

Una asociación representa un vínculo estructural que el objeto conserva normalmente como atributo. Los participantes pueden existir de forma independiente y la relación puede cambiar durante la ejecución.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/relaciones/asociacion/asociacion_ejemplo.png" alt="Asociación entre Persona y TarjetaCredito"><figcaption><strong>Figura 2.15.</strong> Una persona puede asociar o no una tarjeta de crédito.</figcaption></figure>

??? example "Código genérico · asociación"

    ```java
    class TarjetaCredito { }

    class Persona {
        private TarjetaCredito tarjeta;
        void asociar(TarjetaCredito tarjeta) { this.tarjeta = tarjeta; }
    }

    class Cliente {
        public static void main(String[] args) {
            Persona persona = new Persona();
            persona.asociar(new TarjetaCredito());
        }
    }
    ```

<a id="dependencia"></a>
