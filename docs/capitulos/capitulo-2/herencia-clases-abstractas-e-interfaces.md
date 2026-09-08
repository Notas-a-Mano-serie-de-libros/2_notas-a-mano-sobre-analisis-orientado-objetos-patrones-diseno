# Herencia

La herencia expresa una relación de especialización: el subtipo debe poder utilizarse donde se espera el tipo general sin romper su contrato. Es apropiada cuando existe una relación conceptual **es-un** y cuando las variantes comparten expectativas estables; no debe emplearse solo para ahorrar líneas de código.

**Accesos directos a los ejemplos**

| Mecanismo | Acceso |
| --- | --- |
| Herencia de clases | [Explicación, figura y código](#herencia-de-clases) |
| Clase abstracta | [Explicación, figura y código](#clase-abstracta) |
| Interfaz | [Explicación, figura y código](#realizacion-de-una-interfaz) |

<a id="herencia-de-clases"></a>
### 2.4.1 Herencia de clases

Una subclase extiende el estado y el comportamiento de una superclase mediante `extends`. La flecha UML apunta hacia el tipo más general. La relación solo es válida si cada instancia del subtipo puede sustituir al tipo base sin modificar las expectativas del cliente.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia.png" alt="Relación de herencia entre una clase general y dos subclases">
  <figcaption><strong>Figura 2.9.</strong> `ClaseB` y `ClaseC` son especializaciones de `ClaseA`.</figcaption>
</figure>

??? example "Código genérico · herencia"

    ```java
    class Documento {
        String titulo;
        String describir() { return titulo; }
    }

    class Libro extends Documento {
        String isbn;
    }
    ```

<a id="clase-abstracta"></a>
### 2.4.2 Clase abstracta

Una clase abstracta no puede instanciarse. Puede compartir estado y operaciones implementadas, además de declarar pasos abstractos que cada subtipo debe completar. Es apropiada cuando existe una base conceptual común y parte del algoritmo pertenece realmente a esa base.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/clase_abstracta.png" alt="Clase abstracta con operaciones concretas y abstractas">
  <figcaption><strong>Figura 2.10.</strong> Las subclases heredan el comportamiento común y completan las operaciones abstractas.</figcaption>
</figure>

??? example "Código genérico · clase abstracta"

    ```java
    abstract class Notificacion {
        public final void enviar(String mensaje) {
            validar(mensaje);
            entregar(mensaje);
        }

        private void validar(String mensaje) {
            if (mensaje.isBlank()) throw new IllegalArgumentException();
        }

        protected abstract void entregar(String mensaje);
    }

    class NotificacionEmail extends Notificacion {
        protected void entregar(String mensaje) {
            System.out.println("Email: " + mensaje);
        }
    }
    ```

<a id="realizacion-de-una-interfaz"></a>
### 2.4.3 Realización de una interfaz

Una interfaz define un contrato sin obligar a compartir estado ni una implementación base. Las clases lo realizan con `implements`; por ello, tipos pertenecientes a jerarquías diferentes pueden colaborar mediante las mismas operaciones.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/interface.png" alt="Dos clases que realizan una interfaz común">
  <figcaption><strong>Figura 2.11.</strong> Las implementaciones satisfacen el contrato de la interfaz.</figcaption>
</figure>

??? example "Código genérico · interfaz"

    ```java
    interface Exportable {
        byte[] exportar();
    }

    class ReportePdf implements Exportable {
        public byte[] exportar() {
            return new byte[] { 37, 80, 68, 70 };
        }
    }
    ```

| Mecanismo | Úsalo cuando | Evítalo cuando |
| --- | --- | --- |
| Clase concreta | El concepto puede instanciarse y su comportamiento está completo. | Solo representa una categoría incompleta. |
| Clase abstracta | Las variantes comparten estado, reglas o una plantilla de comportamiento. | La jerarquía no representa sustitución real. |
| Interfaz | Distintos tipos deben cumplir el mismo contrato sin compartir implementación. | El contrato obliga a métodos que algunos clientes no necesitan. |
| Composición | Un objeto puede delegar una capacidad intercambiable a otro. | La relación de pertenencia o ciclo de vida no es clara. |

