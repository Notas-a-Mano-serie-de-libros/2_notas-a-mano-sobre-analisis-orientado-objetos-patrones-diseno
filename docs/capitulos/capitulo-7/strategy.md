<h1 style="text-align:center;">
  <strong> Strategy (Estrategia)</strong>
</h1>

<h4 style="text-align:center;"><em>“Define una familia de algoritmos, encapsula cada uno y los hace intercambiables,
permitiendo que el algoritmo varíe independientemente de los clientes que lo utilizan.”</em></h4>


## Definición

<p style="text-align:justify;">
El <b>patrón Strategy</b> permite que un objeto modifique su comportamiento en tiempo de ejecución.
Este patrón encapsula diferentes algoritmos dentro de clases separadas que comparten una interfaz común, permitiendo intercambiarlas dinámicamente sin afectar la estructura del cliente que las usa.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
En muchos sistemas, un mismo proceso puede tener múltiples formas de ejecución dependiendo de las condiciones o preferencias del usuario.
Por ejemplo, un sistema de pago puede usar tarjetas de crédito, PayPal o criptomonedas; todos son métodos válidos, pero la lógica de cada uno difiere.
El <b>patrón Strategy</b> surge para abstraer esas variaciones, permitiendo seleccionar el algoritmo adecuado en tiempo de ejecución.
</p>

<p style="text-align:justify;">
En esencia, el patrón facilita la <b>inyección de comportamientos</b> —cada estrategia representa una variación posible de un algoritmo— logrando que el código del cliente permanezca simple y desacoplado de las implementaciones específicas.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
El <b>Contexto</b> es responsable de mantener una referencia a la interfaz <b>IEstrategia</b> y delegar en ella la ejecución de una operación.
Cada <b>EstrategiaConcreta</b> implementa una versión distinta del algoritmo definido por la interfaz, lo que permite cambiar el comportamiento del contexto en tiempo de ejecución sin modificar su código.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/strategy.png" alt="Diagrama UML del patrón Strategy" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Strategy</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IEstrategia { void algoritmo(); }
    
    final class EstrategiaConcretaA implements IEstrategia {
        public void algoritmo() { System.out.println("Estrategia A"); }
    }
    final class EstrategiaConcretaB implements IEstrategia {
        public void algoritmo() { System.out.println("Estrategia B"); }
    }
    
    final class Contexto {
        private IEstrategia estrategia;
        Contexto(IEstrategia estrategia) { this.estrategia = estrategia; }
        void cambiarEstrategia(IEstrategia estrategia) { this.estrategia = estrategia; }
        void ejecutar() { estrategia.algoritmo(); }
    }
    ```

=== "Python"

    ```python
    class IEstrategia:
        def algoritmo(self, datos): raise NotImplementedError
    class EstrategiaConcretaA(IEstrategia):
        def algoritmo(self, datos): return sorted(datos)
    class EstrategiaConcretaB(IEstrategia):
        def algoritmo(self, datos): return list(reversed(datos))
    class Contexto:
        def __init__(self, estrategia): self.estrategia = estrategia
        def ejecutar(self, datos): return self.estrategia.algoritmo(datos)
    ```

=== "C#"

    ```csharp
    interface IEstrategia { int[] Algoritmo(int[] datos); }
    
    class EstrategiaConcretaA : IEstrategia { public int[] Algoritmo(int[] d) { var r=(int[])d.Clone(); System.Array.Sort(r); return r; } }
    
    class EstrategiaConcretaB : IEstrategia { public int[] Algoritmo(int[] d) { var r=(int[])d.Clone(); System.Array.Reverse(r); return r; } }
    
    class Contexto {
        public IEstrategia Estrategia { get; set; }
        public int[] Ejecutar(int[] datos) => Estrategia.Algoritmo(datos);
    }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IEstrategia: algoritmo(datos)
    CLASES EstrategiaConcretaA y B IMPLEMENTAN IEstrategia
    CLASE Contexto: contiene IEstrategia
        cambiarEstrategia(nueva): estrategia ← nueva
        ejecutar(datos): RETORNAR estrategia.algoritmo(datos)
    ```

## Participantes

<table>
  <thead>
    <tr>
      <th style="text-align:center;">Elemento</th>
      <th style="text-align:justify;">Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:center;"><b>IEstrategia</b></td>
      <td style="text-align:justify;">Interfaz que define el método que todas las estrategias concretas deben implementar.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>EstrategiaConcreta</b></td>
      <td style="text-align:justify;">Implementa una variante específica del algoritmo definido por la interfaz <b>IEstrategia</b>.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Contexto</b></td>
      <td style="text-align:justify;">Mantiene una referencia a la estrategia actual y delega en ella la ejecución del comportamiento requerido.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Se solicita explicar a un grupo de estudiantes en qué consiste el patrón Strategy dentro de un curso de Ingeniería de Software.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo7.strategy;
    
    import capitulo7.strategy.algoritmo.Operacion;
    import capitulo7.strategy.algoritmo.implementacion.OrdenamientoBurbuja;
    import capitulo7.strategy.algoritmo.implementacion.OrdenamientoInsercion;
    import capitulo7.strategy.algoritmo.implementacion.OrdenamientoMezcla;
    import capitulo7.strategy.algoritmo.implementacion.OrdenamientoRadix;
    
    import java.util.Random;
    import java.util.stream.IntStream;
    
    public class Cliente {
        public static void main(String[] args) {
    
            Integer[] numeros = getRandomArr();
            final Operacion burbuja = new Operacion(new OrdenamientoBurbuja());
            burbuja.ordenar(numeros);
    
            numeros = getRandomArr();
            final Operacion insercion = new Operacion(new OrdenamientoInsercion());
            insercion.ordenar(numeros);
    
            numeros = getRandomArr();
            final Operacion radix = new Operacion(new OrdenamientoRadix());
            radix.ordenar(numeros);
    
            numeros = getRandomArr();
            final Operacion mezcla = new Operacion(new OrdenamientoMezcla());
            mezcla.ordenar(numeros);
        }
    
        private static Integer[] getRandomArr() {
            return IntStream.generate(() -> new Random().nextInt(100)).limit(10).boxed().toArray(Integer[]::new);
        }
    }
    ```

## Aplicabilidad

Utiliza Strategy cuando:

- Existan varios algoritmos intercambiables para resolver la misma operación.
- El algoritmo deba seleccionarse o cambiarse en tiempo de ejecución.
- Una clase contenga condicionales extensos para elegir entre variantes de comportamiento.
- Quieras probar cada algoritmo de forma independiente.
- Los detalles internos de los algoritmos deban quedar ocultos para el contexto y sus clientes.

## Cómo implementar

1. Identifica el comportamiento variable y los datos que necesita.
2. Define una interfaz común para todas las estrategias.
3. Extrae cada algoritmo a una estrategia concreta.
4. Haz que el contexto mantenga una referencia a la interfaz y delegue la operación.
5. Permite configurar la estrategia mediante el constructor, un método o una fábrica.
6. Evita que el contexto conozca condiciones específicas de las estrategias concretas.

## Ventajas y desventajas

### Ventajas

- Permite intercambiar algoritmos sin modificar el contexto.
- Sustituye condicionales por composición y polimorfismo.
- Facilita probar, extender y reutilizar cada estrategia.

### Desventajas

- Añade clases y configuración para algoritmos que podrían ser triviales.
- El cliente debe conocer las diferencias para elegir correctamente.
- Las estrategias pueden requerir que el contexto les exponga datos adicionales.

## Relación con otros patrones

- [State](state.md) comparte la delegación por composición, aunque la selección de estado forma parte del ciclo de vida del contexto.
- [Template Method](template.md) varía pasos mediante herencia; Strategy intercambia el algoritmo completo mediante composición.
- [Factory Method](../capitulo-5/factory.md) puede encapsular la selección y creación de la estrategia adecuada.
- [Bridge](../capitulo-6/bridge.md) usa una estructura parecida para separar dimensiones de abstracción e implementación.
