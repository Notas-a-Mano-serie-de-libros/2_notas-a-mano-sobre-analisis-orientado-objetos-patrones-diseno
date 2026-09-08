# Polimorfismo

El polimorfismo permite enviar el mismo mensaje a objetos diferentes y obtener el comportamiento correspondiente a su tipo concreto. Evita que el cliente acumule condicionales para distinguir cada variante y prepara el terreno para principios como OCP y patrones como Strategy, State o Factory Method.

**Accesos directos a los ejemplos**

| Forma | Acceso |
| --- | --- |
| Polimorfismo de subtipos | [Explicación, figura y código](#polimorfismo-de-subtipos) |
| Sobrecarga | [Explicación, figura y código](#sobrecarga) |
| Sobrescritura | [Explicación, figura y código](#sobrescritura) |

<a id="polimorfismo-de-subtipos"></a>
### 2.5.1 Polimorfismo de subtipos

Una referencia del tipo general puede apuntar a una instancia concreta. El cliente programa contra el contrato y la operación ejecutada corresponde al objeto real en tiempo de ejecución.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/polimorfismo/polimorfismo_basico.png" alt="Referencia de un tipo general que contiene una instancia de un subtipo"><figcaption><strong>Figura 2.12.</strong> Una referencia de `ClaseA` contiene una instancia de `ClaseB`.</figcaption></figure>

??? example "Código genérico · polimorfismo de subtipos"

    ```java
    interface Figura { double area(); }

    class Circulo implements Figura {
        private final double radio;
        Circulo(double radio) { this.radio = radio; }
        public double area() { return Math.PI * radio * radio; }
    }

    class Cliente {
        public static void main(String[] args) {
            Figura figura = new Circulo(2);
            System.out.println(figura.area());
        }
    }
    ```

<a id="sobrecarga"></a>
### 2.5.2 Sobrecarga

La sobrecarga mantiene el mismo nombre de operación, pero cambia la lista de parámetros. La selección se realiza en compilación según los argumentos; no depende del tipo concreto del objeto en tiempo de ejecución.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/polimorfismo/sobrecarga.png" alt="Tres operaciones sobrecargadas con firmas distintas"><figcaption><strong>Figura 2.13.</strong> Mismo nombre y diferentes firmas.</figcaption></figure>

??? example "Código genérico · sobrecarga"

    ```java
    class Saludo {
        void saludar() { System.out.println("Hola"); }
        void saludar(String nombre) { System.out.println("Hola " + nombre); }
        void saludar(String nombre, String apellido) {
            System.out.println("Hola " + nombre + " " + apellido);
        }
    }
    ```

<a id="sobrescritura"></a>
### 2.5.3 Sobrescritura

La sobrescritura conserva la firma heredada y reemplaza su implementación en un subtipo. El despacho dinámico selecciona el comportamiento de la instancia concreta, aunque la variable esté declarada con el tipo general.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/polimorfismo/sobrescritura.png" alt="Subclases que sobrescriben una operación heredada"><figcaption><strong>Figura 2.14.</strong> Las subclases pueden conservar o redefinir la operación del tipo base.</figcaption></figure>

??? example "Código genérico · sobrescritura"

    ```java
    class Mensaje {
        String contenido() { return "Mensaje genérico"; }
    }

    class MensajeUrgente extends Mensaje {
        @Override
        String contenido() { return "URGENTE"; }
    }

    class Cliente {
        public static void main(String[] args) {
            Mensaje mensaje = new MensajeUrgente();
            System.out.println(mensaje.contenido()); // URGENTE
        }
    }
    ```

La ventaja principal es separar al cliente de las decisiones concretas. El costo aparece cuando la jerarquía no conserva un contrato coherente: una implementación que sorprende al cliente introduce errores aunque el código compile.

