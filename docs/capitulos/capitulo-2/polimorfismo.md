# Polimorfismo

<span class="chapter-kicker">Capítulo 2 · Pilares de la programación orientada a objetos</span>

El polimorfismo permite enviar el mismo mensaje a objetos diferentes y obtener el comportamiento correspondiente a su tipo concreto. Evita que el cliente acumule condicionales para distinguir cada variante y prepara el terreno para principios como OCP y patrones como Strategy, State o Factory Method.

**Accesos directos a los ejemplos**

| Forma | Acceso |
| --- | --- |
| Polimorfismo de subtipos | [Explicación, figura y código](#polimorfismo-de-subtipos) |
| Sobrecarga | [Explicación, figura y código](#sobrecarga) |
| Sobrescritura | [Explicación, figura y código](#sobrescritura) |

<a id="polimorfismo-de-subtipos"></a>
## 2.5.1 Polimorfismo de subtipos

Una referencia del tipo general puede apuntar a una instancia concreta. El cliente programa contra el contrato y la operación ejecutada corresponde al objeto real en tiempo de ejecución.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/polimorfismo/polimorfismo_basico.png" alt="Referencia de un tipo general que contiene una instancia de un subtipo"><figcaption>Una referencia de `ClaseA` contiene una instancia de `ClaseB`.</figcaption></figure>

???+ example "Ver código"
    === "Java"

        ```java linenums="1"
        interface Figura {
            double area();
        }

        class Circulo implements Figura {
            private final double radio;

            Circulo(double radio) {
                this.radio = radio;
            }

            @Override
            public double area() {
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
            def area(self) -> float:
                pass

        class Circulo(Figura):
            def __init__(self, radio: float) -> None:
                self.radio = radio

            def area(self) -> float:
                return pi * self.radio ** 2
        ```

    === "C++"

        ```cpp linenums="1"
        #include <numbers>

        class Figura {
        public:
            virtual double area() const = 0;
            virtual ~Figura() = default;
        };

        class Circulo : public Figura {
            double radio;

        public:
            explicit Circulo(double radio)
                : radio(radio) {
            }

            double area() const override {
                return std::numbers::pi * radio * radio;
            }
        };
        ```


<a id="sobrecarga"></a>
## 2.5.2 Sobrecarga

La sobrecarga mantiene el mismo nombre de operación, pero cambia la lista de parámetros. La selección se realiza en compilación según los argumentos; no depende del tipo concreto del objeto en tiempo de ejecución.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/polimorfismo/sobrecarga.png" alt="Tres operaciones sobrecargadas con firmas distintas"><figcaption>Mismo nombre y diferentes firmas.</figcaption></figure>

???+ example "Ver código"
    === "Java"

        ```java linenums="1"
        class Saludo {
            void saludar() {
                System.out.println("Hola");
            }

            void saludar(String nombre) {
                System.out.println("Hola " + nombre);
            }
        }
        ```

    === "Python"

        ```python linenums="1"
        class Saludo:
            def saludar(self, nombre: str | None = None) -> None:
                mensaje = "Hola" if nombre is None else f"Hola {nombre}"
                print(mensaje)
        ```

    === "C++"

        ```cpp linenums="1"
        #include <iostream>
        #include <string>

        class Saludo {
        public:
            void saludar() const {
                std::cout << "Hola";
            }

            void saludar(const std::string& nombre) const {
                std::cout << "Hola " << nombre;
            }
        };
        ```


<a id="sobrescritura"></a>
## 2.5.3 Sobrescritura

La sobrescritura conserva la firma heredada y reemplaza su implementación en un subtipo. El despacho dinámico selecciona el comportamiento de la instancia concreta, aunque la variable esté declarada con el tipo general.

<figure class="uml-figure uml-figure--wide"><img src="../../../assets/images/contenido/capitulos/capitulo2/polimorfismo/sobrescritura.png" alt="Subclases que sobrescriben una operación heredada"><figcaption>Las subclases pueden conservar o redefinir la operación del tipo base.</figcaption></figure>

???+ example "Ver código"
    === "Java"

        ```java linenums="1"
        class Mensaje {
            String contenido() {
                return "Mensaje genérico";
            }
        }

        class MensajeUrgente extends Mensaje {
            @Override
            String contenido() {
                return "URGENTE";
            }
        }
        ```

    === "Python"

        ```python linenums="1"
        class Mensaje:
            def contenido(self) -> str:
                return "Mensaje genérico"

        class MensajeUrgente(Mensaje):
            def contenido(self) -> str:
                return "URGENTE"
        ```

    === "C++"

        ```cpp linenums="1"
        #include <string>

        class Mensaje {
        public:
            virtual std::string contenido() const {
                return "Mensaje genérico";
            }

            virtual ~Mensaje() = default;
        };

        class MensajeUrgente : public Mensaje {
        public:
            std::string contenido() const override {
                return "URGENTE";
            }
        };
        ```


La ventaja principal es separar al cliente de las decisiones concretas. El costo aparece cuando la jerarquía no conserva un contrato coherente: una implementación que sorprende al cliente introduce errores aunque el código compile.
