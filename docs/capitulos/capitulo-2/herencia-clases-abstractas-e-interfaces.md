# Herencia

<span class="chapter-kicker">Capítulo 2 · Pilares de la programación orientada a objetos</span>

La herencia es el mecanismo mediante el cual una clase, denominada **subclase** o clase derivada, adquiere los atributos y métodos de otra, denominada **superclase** o clase base. Expresa una relación de especialización: el subtipo debe poder utilizarse donde se espera el tipo general sin romper su contrato.

La herencia surge de forma natural cuando los conceptos del dominio pueden organizarse mediante jerarquías. También favorece la reutilización, porque una subclase declara únicamente aquello que la diferencia de su superclase. No debe utilizarse solo para ahorrar líneas de código: la relación debe representar un vínculo conceptual **es-un**.

**Accesos directos a los ejemplos**

| Mecanismo | Acceso |
| --- | --- |
| Generalización de aves | [Primer ejemplo y código](#generalizacion-de-aves) |
| Herencia simple | [Figura, código y discusión](#herencia-simple) |
| Clase abstracta | [Figura, código y discusión](#clase-abstracta) |
| Interfaz | [Figura, código y discusión](#realizacion-de-una-interfaz) |

<a id="generalizacion-de-aves"></a>
## 2.4.1 Generalización: de aves concretas a `Ave`

Un pato, un pingüino y un avestruz comparten atributos como el tipo de pico y de plumaje. También comen, duermen, caminan y emiten un sonido, aunque cada especie lo haga de manera diferente. La generalización reúne esos elementos comunes en la clase `Ave`; las propiedades particulares permanecen en cada especialización.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_1.svg" alt="Proceso de generalización desde aves específicas hacia la abstracción Ave">
  <figcaption>La generalización traslada a `Ave` los atributos y comportamientos que comparten las especies.</figcaption>
</figure>

???+ example "Ver código"
    === "Java"

        ```java linenums="1"
        class Ave {
            protected String tipoPico;
            protected String tipoPlumaje;

            void comer() {
                System.out.println("El ave come");
            }

            void dormir() {
                System.out.println("El ave duerme");
            }

            void caminar() {
                System.out.println("El ave camina");
            }

            void emitirSonido() {
                System.out.println("Sonido de ave");
            }
        }

        class Pato extends Ave {
            boolean esRapaz;
            void nadar() {
                System.out.println("El pato nada");
            }

            @Override
            void emitirSonido() {
                System.out.println("Cuac");
            }
        }

        class Pinguino extends Ave {
            double capaGrasa;
            void nadar() {
                System.out.println("El pingüino nada");
            }
        }

        class Avestruz extends Ave {
            double altura;
        }
        ```

    === "Python"

        ```python linenums="1"
        class Ave:
            def comer(self):
                print("El ave come")

            def dormir(self):
                print("El ave duerme")

            def caminar(self):
                print("El ave camina")

            def emitir_sonido(self):
                print("Sonido de ave")

        class Pato(Ave):
            def nadar(self):
                print("El pato nada")

            def emitir_sonido(self):
                print("Cuac")

        class Pinguino(Ave):
            def nadar(self):
                print("El pingüino nada")

        class Avestruz(Ave):
            pass
        ```

    === "C++"

        ```cpp linenums="1"
        class Ave {
        public:
            void comer() const {}
            void dormir() const {}
            void caminar() const {}
            virtual void emitirSonido() const {}
            virtual ~Ave() = default;
        };

        class Pato : public Ave {
        public:
            void nadar() const {}
            void emitirSonido() const override {}
        };

        class Pinguino : public Ave {
        public:
            void nadar() const {}
        };

        class Avestruz : public Ave {
        };
        ```


**Discusión.** La clase general solo contiene capacidades compartidas. `nadar()` no pertenece a `Ave` porque el avestruz no puede satisfacer ese contrato; incluirlo obligaría a crear implementaciones vacías o engañosas.

<a id="herencia-simple"></a>
## 2.4.2 Herencia simple

La herencia simple establece que una subclase extiende una única superclase. En UML se representa mediante una línea continua terminada en un triángulo vacío que apunta hacia el tipo más general.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_2.svg" alt="Relación de herencia simple entre Ave, Pato, Pingüino y Avestruz">
  <figcaption>`Pato`, `Pingüino` y `Avestruz` especializan a `Ave` mediante herencia simple.</figcaption>
</figure>

???+ example "Ver código"
    === "Java"

        ```java linenums="1"
        class ClaseA {
            protected int atributo;
            void operacionA() {
                System.out.println("Comportamiento común");
            }
        }

        class ClaseB extends ClaseA {
            void operacionB() {
                atributo++;
            }
        }

        class ClaseC extends ClaseA {
            void operacionC() {
                atributo--;
            }
        }
        ```

    === "Python"

        ```python linenums="1"
        class ClaseA:
            def __init__(self):
                self.atributo = 0

            def operacion_a(self):
                print("Comportamiento común")

        class ClaseB(ClaseA):
            def operacion_b(self):
                self.atributo += 1

        class ClaseC(ClaseA):
            def operacion_c(self):
                self.atributo -= 1
        ```

    === "C++"

        ```cpp linenums="1"
        class ClaseA {
        protected:
            int atributo = 0;
        public:
            void operacionA() const {}
        };

        class ClaseB : public ClaseA {
        public:
            void operacionB() {
                ++atributo;
            }
        };

        class ClaseC : public ClaseA {
        public:
            void operacionC() {
                --atributo;
            }
        };
        ```


**Discusión.** `ClaseB` y `ClaseC` reutilizan el estado y la operación común de `ClaseA`, pero cada una incorpora su responsabilidad particular. La jerarquía es válida si cualquier cliente que espere una `ClaseA` puede recibir una instancia de cualquiera de sus subclases.

### Variantes y límites de la herencia

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_3.svg" alt="Ejemplo de herencia simple en Java con ClaseA, ClaseB y ClaseC">
  <figcaption>Java expresa la herencia simple con `extends`; cada subclase tiene una única superclase directa.</figcaption>
</figure>

**Discusión.** Esta forma mantiene una jerarquía fácil de seguir. Las operaciones heredadas deben conservar su significado en todos los subtipos para que la sustitución sea segura.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_4.svg" alt="Ejemplo de herencia múltiple admitida por C++">
  <figcaption>C++ permite que una clase herede de más de una clase base.</figcaption>
</figure>

**Discusión.** La herencia múltiple puede reunir capacidades independientes, pero también introduce ambigüedad cuando las clases base ofrecen miembros con el mismo nombre. El diseñador debe resolverla de forma explícita.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_5.svg" alt="Jerarquía de herencia múltiple con forma de diamante">
  <figcaption>El diamante aparece cuando dos ramas comparten una base y vuelven a reunirse en una subclase.</figcaption>
</figure>

**Discusión.** El diamante puede duplicar el estado de la clase base o volver ambiguo su acceso. Por esta razón, muchos diseños prefieren composición o contratos pequeños antes que jerarquías múltiples profundas.

<a id="clase-abstracta"></a>
## 2.4.3 Herencia con clases abstractas

Una clase abstracta representa una generalización incompleta: no admite instanciación directa y puede declarar métodos abstractos que las subclases están obligadas a implementar. También puede compartir estado y operaciones ya resueltas.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_6.svg" alt="Clase abstracta con operaciones concretas y abstractas">
  <figcaption>Las clases concretas heredan el comportamiento común y completan la operación abstracta.</figcaption>
</figure>

???+ example "Ver código"
    === "Java"

        ```java linenums="1"
        abstract class Figura {
            public abstract double calcularArea();

            public String describir() {
                return "Área: " + calcularArea();
            }
        }

        class Circulo extends Figura {
            private final double radio;
            Circulo(double radio) {
                this.radio = radio;
            }

            @Override
            public double calcularArea() {
                return Math.PI * radio * radio;
            }
        }
        ```

    === "Python"

        ```python linenums="1"
        from abc import ABC, abstractmethod
        from math import pi

        class Figura(ABC):
            @abstractmethod
            def calcular_area(self) -> float:
                pass

            def describir(self) -> str:
                return f"Área: {self.calcular_area()}"

        class Circulo(Figura):
            def __init__(self, radio: float):
                self.radio = radio

            def calcular_area(self) -> float:
                return pi * self.radio ** 2
        ```

    === "C++"

        ```cpp linenums="1"
        #include <numbers>

        class Figura {
        public:
            virtual double calcularArea() const = 0;
            virtual ~Figura() = default;
        };

        class Circulo : public Figura {
            double radio;
        public:
            explicit Circulo(double radio)
                : radio(radio) {
            }

            double calcularArea() const override {
                return std::numbers::pi * radio * radio;
            }
        };
        ```


**Discusión.** `Figura` expresa el concepto y el contrato para calcular el área, pero no posee información suficiente para resolverlo. `Circulo` aporta el estado y la fórmula que convierten esa abstracción parcial en una clase concreta.

<a id="realizacion-de-una-interfaz"></a>
## 2.4.4 Caso particular: implementación de interfaces

Una interfaz define un contrato sin obligar a compartir estado ni una implementación base. La relación entre una clase y una interfaz se denomina **realización** y se representa mediante una línea punteada con un triángulo que apunta hacia la interfaz.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_7.svg" alt="Dos clases que realizan una interfaz común">
  <figcaption>Dos implementaciones distintas satisfacen el mismo contrato.</figcaption>
</figure>

???+ example "Ver código"
    === "Java"

        ```java linenums="1"
        interface Exportable {
            byte[] exportar();
        }

        class ReportePdf implements Exportable {
            @Override
            public byte[] exportar() {
                return new byte[] { 37, 80, 68, 70 };
            }
        }

        class ReporteTexto implements Exportable {
            @Override
            public byte[] exportar() {
                return "reporte".getBytes();
            }
        }
        ```

    === "Python"

        ```python linenums="1"
        from abc import ABC, abstractmethod

        class Exportable(ABC):
            @abstractmethod
            def exportar(self) -> bytes:
                pass

        class ReportePdf(Exportable):
            def exportar(self) -> bytes:
                return b"%PDF"

        class ReporteTexto(Exportable):
            def exportar(self) -> bytes:
                return b"reporte"
        ```

    === "C++"

        ```cpp linenums="1"
        #include <string>

        class Exportable {
        public:
            virtual std::string exportar() const = 0;
            virtual ~Exportable() = default;
        };

        class ReportePdf : public Exportable {
        public:
            std::string exportar() const override {
                return "%PDF";
            }
        };

        class ReporteTexto : public Exportable {
        public:
            std::string exportar() const override {
                return "reporte";
            }
        };
        ```


**Discusión.** Los clientes pueden depender de `Exportable` sin conocer el formato concreto. La interfaz desacopla el contrato de sus implementaciones y permite incorporar nuevas variantes sin modificar a quienes ya utilizan la abstracción.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_8.svg" alt="Clase que implementa dos interfaces independientes">
  <figcaption>Una clase puede realizar varios contratos sin heredar estado de ellos.</figcaption>
</figure>

**Discusión.** La realización de varias interfaces combina capacidades sin formar una jerarquía de estado. Cada interfaz debe conservar un propósito cohesivo para no imponer operaciones ajenas a sus implementaciones.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/herencia/herencia_9.svg" alt="Interfaz con una operación predeterminada y una clase que la implementa">
  <figcaption>Una operación predeterminada aporta comportamiento reutilizable sin convertir la interfaz en una clase base con estado.</figcaption>
</figure>

**Discusión.** Los métodos predeterminados permiten evolucionar un contrato y compartir una implementación pequeña. No deben utilizarse para ocultar responsabilidades que pertenecen a una clase o colaborador concreto.

| Mecanismo | Úsalo cuando | Evítalo cuando |
| --- | --- | --- |
| Clase concreta | El concepto puede instanciarse y su comportamiento está completo. | Solo representa una categoría incompleta. |
| Herencia simple | Existe una relación estable **es-un** y el subtipo respeta el contrato base. | La relación solo busca reutilizar código. |
| Clase abstracta | Las variantes comparten estado, reglas o una plantilla de comportamiento. | La jerarquía no representa sustitución real. |
| Interfaz | Tipos diferentes deben cumplir el mismo contrato sin compartir estado. | El contrato obliga a métodos que algunos tipos no pueden satisfacer. |
| Composición | Una capacidad puede delegarse y cambiar de manera independiente. | El colaborador no representa una responsabilidad propia. |
