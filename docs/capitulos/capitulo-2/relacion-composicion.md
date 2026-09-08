# Composición

La composición es una relación todo-parte fuerte. El todo crea o controla el ciclo de vida de la parte y esta no se comparte con otro propietario. UML utiliza un rombo negro del lado del compuesto.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/relaciones/composicion/composicion_ejemplo1.png" alt="Composición entre Humano y Corazon"><figcaption><strong>Figura 2.19.</strong> El corazón se modela como parte inseparable del humano.</figcaption></figure>

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/relaciones/composicion/composicion_ejemplo2.png" alt="Ejemplo de una composición debilitada por un setter"><figcaption><strong>Figura 2.20.</strong> Permitir reemplazar la parte con `null` debilita la invariante de composición.</figcaption></figure>

??? example "Código genérico · composición"

    ```java
    final class Corazon { }

    class Humano {
        private final Corazon corazon;
        Humano() { this.corazon = new Corazon(); }
        Corazon getCorazon() { return corazon; }
    }

    class Cliente {
        public static void main(String[] args) {
            Humano humano = new Humano();
            System.out.println(humano.getCorazon());
        }
    }
    ```

<a id="generalizacion"></a>
