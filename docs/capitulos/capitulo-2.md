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

**Accesos directos a los ejemplos**

| Elemento | Acceso |
| --- | --- |
| Representación visual | [Figura de abstracción](#abstraccion-visual) |
| Modelo ejecutable | [Código genérico en Java](#codigo-abstraccion) |

<a id="abstraccion-visual"></a>

<figure class="uml-figure">
  <img src="../../assets/images/contenido/poo/abstraccion.png" alt="Representación UML del proceso de abstracción">
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

## 2.2 Clases y objetos

Una **clase** define la estructura y el comportamiento común de un conjunto de elementos. Un **objeto** es una instancia concreta que posee identidad, estado y comportamiento durante la ejecución. La clase describe posibilidades; el objeto materializa una configuración particular.

**Accesos directos a los ejemplos**

| Elemento | Acceso |
| --- | --- |
| Clase | [Representación UML](#representacion-de-clase) |
| Objeto | [Representación UML](#representacion-de-objeto) |
| Notación detallada | [Atributos, operaciones y visibilidad](#detalle-de-clase) |
| Instanciación | [Código genérico en Java](#codigo-clase-objeto) |

<a id="representacion-de-clase"></a>
### 2.2.1 Representación de una clase

Una clase reúne el nombre del concepto, los atributos que conforman su estado y las operaciones que expresan sus responsabilidades. El diagrama describe el tipo; todavía no asigna valores a una instancia específica.

<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/clase.png" alt="Representación UML de una clase">
  <figcaption><strong>Figura 2.2.</strong> Nombre, atributos y operaciones de una clase.</figcaption>
</figure>

<a id="representacion-de-objeto"></a>
### 2.2.2 Representación de un objeto

Un objeto materializa la clase durante la ejecución. Tiene identidad propia y valores concretos para su estado; por eso dos objetos de la misma clase pueden responder al mismo comportamiento con información diferente.

<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/objeto.png" alt="Representación UML de un objeto">
  <figcaption><strong>Figura 2.3.</strong> Un objeto mantiene valores concretos y una identidad.</figcaption>
</figure>

En UML, una clase suele representarse mediante tres compartimentos: nombre, atributos y operaciones. La visibilidad se expresa con `+` para público, `-` para privado, `#` para protegido y `~` para acceso de paquete. El detalle del diagrama debe responder a la pregunta que se estudia; no siempre es necesario mostrar todos los métodos.

<a id="detalle-de-clase"></a>
<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/clase_detalle.png" alt="Detalle de atributos, operaciones y visibilidad de una clase UML">
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

## 2.3 Encapsulamiento y visibilidad

Encapsular significa mantener juntas la información y las operaciones que protegen su consistencia, ocultando decisiones internas detrás de una interfaz estable. Declarar atributos privados es una herramienta, no el objetivo completo: un objeto también debe impedir estados inválidos y evitar que sus clientes dependan de detalles que pueden cambiar.

**Accesos directos a los ejemplos**

| Elemento | Acceso |
| --- | --- |
| Privado (`-`) | [Explicación y figura](#visibilidad-privada) |
| Protegido (`#`) | [Explicación y figura](#visibilidad-protegida) |
| Paquete (`~`) | [Explicación y figura](#visibilidad-de-paquete) |
| Público (`+`) | [Explicación y figura](#visibilidad-publica) |
| Comparación en Java | [Código genérico](#codigo-visibilidad) |

<a id="visibilidad-privada"></a>
### 2.3.1 Visibilidad privada

Un miembro `private` solo puede utilizarse directamente desde la clase que lo declara. Las subclases y los colaboradores deben interactuar mediante operaciones públicas o protegidas, lo que permite validar cambios y conservar invariantes. En UML se identifica con el signo `-`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/encapsulamiento/private.png" alt="Acceso permitido y denegado para un atributo privado">
  <figcaption><strong>Figura 2.5.</strong> Solo la clase que declara el atributo privado tiene acceso directo; los demás objetos utilizan su interfaz pública.</figcaption>
</figure>

<a id="visibilidad-protegida"></a>
### 2.3.2 Visibilidad protegida

Un miembro `protected` es accesible desde las clases del mismo paquete y desde subclases, incluso cuando estas pertenecen a otro paquete. No constituye una interfaz pública general: las clases externas que no heredan del tipo no pueden acceder directamente. En UML se representa con `#`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/encapsulamiento/protected.png" alt="Acceso permitido y denegado para un atributo protegido">
  <figcaption><strong>Figura 2.6.</strong> El acceso protegido alcanza al paquete y a la jerarquía de herencia.</figcaption>
</figure>

<a id="visibilidad-de-paquete"></a>
### 2.3.3 Visibilidad de paquete

Cuando una declaración Java no incluye modificador, utiliza acceso de paquete o *package-private*. Cualquier clase del mismo paquete puede acceder al miembro, exista o no herencia; desde otro paquete no es visible. UML utiliza el símbolo `~`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/encapsulamiento/default.png" alt="Acceso permitido y denegado para un atributo con visibilidad de paquete">
  <figcaption><strong>Figura 2.7.</strong> La frontera de acceso coincide con la frontera del paquete.</figcaption>
</figure>

<a id="visibilidad-publica"></a>
### 2.3.4 Visibilidad pública

Un miembro `public` forma parte del contrato disponible para cualquier cliente que pueda referenciar la clase. Debe reservarse para operaciones estables y necesarias, pues ampliar la interfaz pública también amplía los compromisos de compatibilidad. UML lo representa con `+`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../assets/images/contenido/poo/encapsulamiento/public.png" alt="Acceso permitido para un atributo público">
  <figcaption><strong>Figura 2.8.</strong> Todas las clases pueden acceder al miembro público.</figcaption>
</figure>

<a id="codigo-visibilidad"></a>
??? example "Código genérico · modificadores de acceso"

    ```java
    class Cuenta {
        private double saldo;       // Solo Cuenta.
        protected String titular;   // Paquete y subclases.
        String moneda;              // Solo el mismo paquete.
        public void depositar(double valor) {
            if (valor <= 0) throw new IllegalArgumentException();
            saldo += valor;
        }
    }

    class CuentaPremium extends Cuenta {
        void mostrarTitular() {
            System.out.println(titular); // Acceso protegido válido.
        }
    }
    ```

Una interfaz pública pequeña reduce el acoplamiento y facilita cambiar la representación interna. Sin embargo, ocultar indiscriminadamente también puede producir objetos difíciles de usar. La visibilidad correcta es la mínima que permite la colaboración prevista.

## 2.4 Herencia, clases abstractas e interfaces

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
  <img src="../../assets/images/contenido/poo/herencia/herencia.png" alt="Relación de herencia entre una clase general y dos subclases">
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
  <img src="../../assets/images/contenido/poo/herencia/clase_abstracta.png" alt="Clase abstracta con operaciones concretas y abstractas">
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
  <img src="../../assets/images/contenido/poo/herencia/interface.png" alt="Dos clases que realizan una interfaz común">
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

## 2.5 Polimorfismo

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

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/polimorfismo/polimorfismo_basico.png" alt="Referencia de un tipo general que contiene una instancia de un subtipo"><figcaption><strong>Figura 2.12.</strong> Una referencia de `ClaseA` contiene una instancia de `ClaseB`.</figcaption></figure>

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

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/polimorfismo/sobrecarga.png" alt="Tres operaciones sobrecargadas con firmas distintas"><figcaption><strong>Figura 2.13.</strong> Mismo nombre y diferentes firmas.</figcaption></figure>

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

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/polimorfismo/sobrescritura.png" alt="Subclases que sobrescriben una operación heredada"><figcaption><strong>Figura 2.14.</strong> Las subclases pueden conservar o redefinir la operación del tipo base.</figcaption></figure>

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

## 2.6 Relaciones entre clases y objetos

Las relaciones UML comunican quién conoce a quién, quién depende de quién y qué ocurre con el ciclo de vida de las partes. Elegir la relación correcta evita que el diagrama oculte decisiones importantes.

**Accesos directos a los ejemplos**

| Relación | Acceso |
| --- | --- |
| Asociación | [Explicación, figura y código](#asociacion) |
| Dependencia | [Explicación, figura y código](#dependencia) |
| Agregación | [Explicación, figuras y código](#agregacion) |
| Composición | [Explicación, figuras y código](#composicion) |
| Generalización | [Explicación, figura y código](#generalizacion) |
| Realización | [Explicación, figura y código](#realizacion) |

<a id="asociacion"></a>
### 2.6.1 Asociación

Una asociación representa un vínculo estructural que el objeto conserva normalmente como atributo. Los participantes pueden existir de forma independiente y la relación puede cambiar durante la ejecución.

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/asociacion/asociacion_ejemplo.png" alt="Asociación entre Persona y TarjetaCredito"><figcaption><strong>Figura 2.15.</strong> Una persona puede asociar o no una tarjeta de crédito.</figcaption></figure>

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
### 2.6.2 Dependencia

Una dependencia expresa un uso puntual: el colaborador llega como parámetro, variable local o valor de retorno, pero no queda almacenado como parte estable del estado del objeto. UML la representa con una flecha discontinua.

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/dependencia/dependencia_ejemplo.png" alt="Dependencias temporales de una impresora"><figcaption><strong>Figura 2.16.</strong> `Impresora` utiliza `Papel` durante la operación y produce un `Documento`.</figcaption></figure>

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
### 2.6.3 Agregación

La agregación es una relación todo-parte débil. La parte se crea fuera del todo, puede sobrevivirle y, si el dominio lo permite, puede compartirse. El rombo blanco se coloca del lado del agregado.

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/agregacion/agregacion_ejemplo1.png" alt="Agregación entre Persona y Ropa"><figcaption><strong>Figura 2.17.</strong> La ropa existe independientemente de la persona.</figcaption></figure>

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/agregacion/agregacion_ejemplo2.png" alt="Ejemplos de agregación con colecciones"><figcaption><strong>Figura 2.18.</strong> Una casa agrega muebles y una empresa agrega empleados sin controlar necesariamente su existencia.</figcaption></figure>

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
### 2.6.4 Composición

La composición es una relación todo-parte fuerte. El todo crea o controla el ciclo de vida de la parte y esta no se comparte con otro propietario. UML utiliza un rombo negro del lado del compuesto.

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/composicion/composicion_ejemplo1.png" alt="Composición entre Humano y Corazon"><figcaption><strong>Figura 2.19.</strong> El corazón se modela como parte inseparable del humano.</figcaption></figure>

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/composicion/composicion_ejemplo2.png" alt="Ejemplo de una composición debilitada por un setter"><figcaption><strong>Figura 2.20.</strong> Permitir reemplazar la parte con `null` debilita la invariante de composición.</figcaption></figure>

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
### 2.6.5 Generalización

La generalización conecta un subtipo con una clase más general. La línea continua termina en un triángulo vacío que apunta a la superclase y en Java se materializa con `extends`.

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/generalizacion/generalizacion.png" alt="Generalización de tres subclases hacia una clase base"><figcaption><strong>Figura 2.21.</strong> Varios subtipos comparten un contrato definido por la clase general.</figcaption></figure>

??? example "Código genérico · generalización"

    ```java
    class MedioPago { void pagar(double valor) { } }
    class Tarjeta extends MedioPago { }
    class Transferencia extends MedioPago { }
    ```

<a id="realizacion"></a>
### 2.6.6 Realización

La realización indica que una clase cumple el contrato declarado por una interfaz. Se dibuja con línea discontinua y triángulo vacío hacia la interfaz; en Java corresponde a `implements`.

<figure class="uml-figure uml-figure--wide"><img src="../../assets/images/contenido/poo/relaciones/generalizacion/generalizacion_interfaz.png" alt="Dos implementaciones que realizan una interfaz"><figcaption><strong>Figura 2.22.</strong> Las clases concretas realizan el mismo contrato sin compartir una superclase concreta.</figcaption></figure>

??? example "Código genérico · realización"

    ```java
    interface Repositorio { void guardar(String valor); }
    class RepositorioArchivo implements Repositorio {
        public void guardar(String valor) { }
    }
    class RepositorioMemoria implements Repositorio {
        public void guardar(String valor) { }
    }
    ```

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

**Accesos directos a los ejemplos**

| Elemento | Acceso |
| --- | --- |
| Verificación del modelo | [Criterio de cierre](#criterio-de-cierre) |
| Modelo integrado | [Código genérico en Java](#codigo-modelo-integrado) |

<a id="criterio-de-cierre"></a>
!!! success "Criterio de cierre"
    Antes de avanzar a GRASP y SOLID, comprueba que puedes justificar quién conoce cada dato, quién crea cada objeto, qué relación controla el ciclo de vida y qué contrato permite sustituir una implementación.

<a id="codigo-modelo-integrado"></a>
??? example "Código genérico · del modelo UML a una colaboración ejecutable"

    ```java
    interface CanalNotificacion {
        void enviar(String destinatario, String mensaje);
    }

    final class CanalEmail implements CanalNotificacion {
        @Override
        public void enviar(String destinatario, String mensaje) {
            System.out.println("Email para " + destinatario + ": " + mensaje);
        }
    }

    final class ServicioAlertas {
        private final CanalNotificacion canal;

        ServicioAlertas(CanalNotificacion canal) {
            this.canal = canal;
        }

        void alertar(String destinatario) {
            canal.enviar(destinatario, "Revise el estado de su cuenta");
        }
    }

    class Aplicacion {
        public static void main(String[] args) {
            CanalNotificacion canal = new CanalEmail();
            ServicioAlertas alertas = new ServicioAlertas(canal);
            alertas.alertar("lector@ejemplo.com");
        }
    }
    ```

El ejemplo conserva una interfaz pequeña, realiza el contrato mediante una clase concreta y utiliza asociación para inyectar la variante. Así, el código expresa las mismas responsabilidades y relaciones que deben verse en el modelo.

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../capitulo-1/">← Capítulo 1</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-3/">Capítulo 3 →</a></nav>
