# Objeto

Un objeto materializa la clase durante la ejecución. Tiene identidad propia y valores concretos para su estado; por eso dos objetos de la misma clase pueden responder al mismo comportamiento con información diferente.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/objeto.png" alt="Representación UML de un objeto">
  <figcaption><strong>Figura 2.3.</strong> Un objeto mantiene valores concretos y una identidad.</figcaption>
</figure>

En UML, una clase suele representarse mediante tres compartimentos: nombre, atributos y operaciones. La visibilidad se expresa con `+` para público, `-` para privado, `#` para protegido y `~` para acceso de paquete. El detalle del diagrama debe responder a la pregunta que se estudia; no siempre es necesario mostrar todos los métodos.

<a id="detalle-de-clase"></a>
<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/clase_detalle.png" alt="Detalle de atributos, operaciones y visibilidad de una clase UML">
  <figcaption><strong>Figura 2.4.</strong> Notación detallada de una clase en UML.</figcaption>
</figure>

| Elemento | Pregunta de diseño | Error frecuente |
| --- | --- | --- |
| Identidad | ¿Dos instancias con el mismo estado siguen representando elementos distintos? | Comparar objetos únicamente por sus atributos. |
| Estado | ¿Qué información necesita conservar el objeto? | Exponer datos sin proteger sus invariantes. |
| Comportamiento | ¿Qué operaciones corresponden naturalmente a esta responsabilidad? | Crear clases que solo contienen datos y trasladar toda la lógica a servicios externos. |

<a id="codigo-clase-objeto"></a>
??? example "Código genérico · clase y objetos"

    ```java
    final class Cuenta {
        private final String numero;
        private double saldo;

        Cuenta(String numero, double saldoInicial) {
            this.numero = numero;
            this.saldo = saldoInicial;
        }

        void depositar(double valor) {
            if (valor <= 0) throw new IllegalArgumentException();
            saldo += valor;
        }

        double consultarSaldo() {
            return saldo;
        }
    }

    class Cliente {
        public static void main(String[] args) {
            Cuenta ahorros = new Cuenta("A-101", 1000);
            Cuenta nomina = new Cuenta("N-205", 2500);
            ahorros.depositar(300);
            System.out.println(ahorros.consultarSaldo());
            System.out.println(nomina.consultarSaldo());
        }
    }
    ```

