# Agregación

La agregación es una relación todo-parte débil. La parte se crea fuera del todo, puede sobrevivirle y, si el dominio lo permite, puede compartirse. El rombo blanco se coloca del lado del agregado.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/relaciones/agregacion/agregacion_ejemplo1.png" alt="Agregación entre Persona y Ropa"><figcaption><strong>Figura 2.17.</strong> La ropa existe independientemente de la persona.</figcaption></figure>

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/relaciones/agregacion/agregacion_ejemplo2.png" alt="Ejemplos de agregación con colecciones"><figcaption><strong>Figura 2.18.</strong> Una casa agrega muebles y una empresa agrega empleados sin controlar necesariamente su existencia.</figcaption></figure>

??? example "Código genérico · agregación"

    ```java
    class Empleado { }

    class Empresa {
        private final java.util.List<Empleado> empleados;
        Empresa(java.util.List<Empleado> empleados) {
            this.empleados = new java.util.ArrayList<>(empleados);
        }
    }

    class Cliente {
        public static void main(String[] args) {
            Empleado ana = new Empleado();
            Empresa empresa = new Empresa(java.util.List.of(ana));
        }
    }
    ```

<a id="composicion"></a>
