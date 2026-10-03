# Abstracción

<span class="chapter-kicker">Capítulo 2 · Pilares de la programación orientada a objetos</span>

La abstracción es el proceso de identificar las características relevantes de una entidad y representarlas mediante un modelo que pueda utilizarse para resolver un problema concreto. Abstraer no consiste en copiar la realidad completa: implica observarla, seleccionar aquello que aporta al propósito del sistema y omitir los detalles que no intervienen en él.

Una misma entidad puede originar modelos diferentes. Una biblioteca puede representar a una persona mediante su nombre y código de autor; un hospital necesita otros datos; y una plataforma educativa se concentra en su identificación y progreso académico. Ninguna de esas abstracciones es universal: cada una es adecuada dentro del contexto para el cual fue creada.

**Accesos directos a los ejemplos**

| Elemento | Acceso |
| --- | --- |
| Representación visual | [Figura de abstracción](#abstraccion-visual) |
| Abstracción equilibrada | [Clase `Persona`](#abstraccion-basica) |
| Subabstracción | [Demasiados detalles](#subabstraccion) |
| Sobreabstracción | [Pérdida de información esencial](#sobreabstraccion) |

<a id="abstraccion-visual"></a>

<figure class="uml-figure">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/abstraccion.svg" alt="Representación UML del proceso de abstracción">
  <figcaption><strong>Figura 2.1.</strong> La abstracción conserva las características útiles para el propósito del sistema.</figcaption>
</figure>

**Discusión.** El modelo `Persona` reúne las propiedades que permiten distinguir y describir individuos dentro del dominio. La figura no intenta reproducir cada rasgo biológico, social o histórico de una persona; conserva un conjunto deliberado de datos y comportamientos que el sistema puede utilizar. El resultado es una representación más sencilla que la realidad, pero suficientemente precisa para su propósito.

!!! question "Problema que se aborda"
    Un modelo que reproduce todos los detalles del mundo real se vuelve inmanejable; uno que omite información esencial no puede cumplir sus casos de uso. Una abstracción correcta se encuentra entre ambos extremos.

<a id="abstraccion-basica"></a>
## 2.2.1 Abstracción básica: la clase `Persona`

Supóngase que se diseña un registro sencillo de participantes. Para identificar a cada persona y mostrar una presentación basta con conservar su nombre y su edad. La nacionalidad, el número de calzado o su historia clínica existen en el mundo real, pero no forman parte de este problema.

=== "Java"

    ```java
    public final class Persona {
        private final String nombre;
        private final int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String presentarse() {
            return "Soy " + nombre + " y tengo " + edad + " años";
        }
    }
    ```

=== "Python"

    ```python
    class Persona:
        def __init__(self, nombre: str, edad: int) -> None:
            self.nombre = nombre
            self.edad = edad

        def presentarse(self) -> str:
            return f"Soy {self.nombre} y tengo {self.edad} años"
    ```

=== "C++"

    ```cpp
    #include <string>
    #include <utility>

    class Persona {
    private:
        std::string nombre;
        int edad;

    public:
        Persona(std::string nombre, int edad)
            : nombre(std::move(nombre)), edad(edad) {}

        std::string presentarse() const {
            return "Soy " + nombre + " y tengo "
                + std::to_string(edad) + " años";
        }
    };
    ```

La clase expresa una abstracción equilibrada porque cada elemento tiene relación directa con el caso de uso. El modelo puede evolucionar si aparecen nuevas responsabilidades, pero no anticipa información que todavía no necesita.

<a id="subabstraccion"></a>
## 2.2.2 Subabstracción

La **subabstracción** se presenta cuando la clase conserva demasiados detalles irrelevantes para el dominio. El modelo pierde claridad, se vuelve rígido y obliga a los clientes a conocer información que no necesitan. En un registro de participantes, almacenar preferencias, medidas físicas, documentos de viaje y datos clínicos es una decisión desproporcionada.

=== "Java"

    ```java
    class PersonaSubabstraida {
        String nombre;
        int edad;
        String colorFavorito;
        double tallaCalzado;
        String tipoSangre;
        String numeroPasaporte;
        String comidaFavorita;
    }
    ```

=== "Python"

    ```python
    class PersonaSubabstraida:
        def __init__(self, nombre, edad, color_favorito, talla_calzado,
                     tipo_sangre, numero_pasaporte, comida_favorita):
            self.nombre = nombre
            self.edad = edad
            self.color_favorito = color_favorito
            self.talla_calzado = talla_calzado
            self.tipo_sangre = tipo_sangre
            self.numero_pasaporte = numero_pasaporte
            self.comida_favorita = comida_favorita
    ```

=== "C++"

    ```cpp
    class PersonaSubabstraida {
    public:
        std::string nombre;
        int edad;
        std::string colorFavorito;
        double tallaCalzado;
        std::string tipoSangre;
        std::string numeroPasaporte;
        std::string comidaFavorita;
    };
    ```

**Discusión.** Los atributos adicionales no ayudan a registrar ni presentar participantes. Además de incrementar el acoplamiento, algunos introducen riesgos de privacidad y validaciones que el sistema no debería asumir. La corrección consiste en retirar del modelo todo detalle que no respalde una responsabilidad real.

<a id="sobreabstraccion"></a>
## 2.2.3 Sobreabstracción

La **sobreabstracción** ocurre cuando se eliminan detalles importantes en busca de una generalidad excesiva. El modelo deja de utilizar el lenguaje del dominio y se convierte en una estructura vaga que no garantiza que los datos requeridos estén presentes ni que las operaciones tengan un significado preciso.

=== "Java"

    ```java
    import java.util.Map;

    class EntidadSobreabstraida {
        Map<String, Object> datos;

        Object ejecutar(String operacion) {
            return datos.get(operacion);
        }
    }
    ```

=== "Python"

    ```python
    class EntidadSobreabstraida:
        def __init__(self, datos: dict) -> None:
            self.datos = datos

        def ejecutar(self, operacion: str):
            return self.datos.get(operacion)
    ```

=== "C++"

    ```cpp
    #include <any>
    #include <string>
    #include <unordered_map>

    class EntidadSobreabstraida {
        std::unordered_map<std::string, std::any> datos;
    public:
        std::any ejecutar(const std::string& operacion) const {
            return datos.at(operacion);
        }
    };
    ```

**Discusión.** La estructura puede almacenar cualquier cosa, pero ya no comunica qué es una persona, qué información necesita ni qué significa presentarse. La supuesta flexibilidad traslada los errores al tiempo de ejecución y obliga a cada cliente a interpretar cadenas y valores sin un contrato claro.

!!! note "Nota de los autores"
    La abstracción es una actividad contextual. No existe una cantidad universal de atributos correcta: el equilibrio se alcanza cuando el modelo contiene toda la información necesaria para sus responsabilidades y ninguna que pertenezca a problemas ajenos.
