<h1 style="text-align:center;"><strong> Flyweight (Peso Ligero)</strong></h1>

<h4 style="text-align:center;"><em>“Minimiza el uso de memoria compartiendo información común entre múltiples
objetos.”</em></h4>


## Definición

<p style="text-align:justify;">
El patrón <b>Flyweight</b> se utiliza para reducir el consumo de recursos en sistemas que manejan una gran cantidad de objetos similares.
Su principio fundamental es <b>compartir estados inmutables</b> (intrínsecos) entre múltiples instancias, evitando almacenar información duplicada.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
En contextos donde existen miles de objetos con datos repetidos —por ejemplo, caracteres de texto, partículas gráficas o entidades de un mapa—, el patrón <b>Flyweight</b> evita crear una copia completa de cada objeto.
En su lugar, extrae la información común y la comparte a través de una fábrica (<b>Fabrica</b>), que administra las instancias ligeras reutilizables.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La clase <b>Fabrica</b> centraliza la gestión de objetos ligeros compartidos.
El <b>ObjetoLigero</b> define la interfaz común, mientras que los objetos concretos (<b>Compartido</b> y <b>NoCompartido</b>) almacenan el estado <b>intrínseco</b> (compartido) y el <b>extrínseco</b> (variable según el contexto).
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo6/flyweight.png" alt="Diagrama UML del patrón Flyweight" width="70%" height="auto"/>
</p>

<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Flyweight</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface Flyweight {
        String obtenerEstadoIntrinseco();
    }
    
    final class Compartido implements Flyweight {
        private final String estadoIntrinseco;
        Compartido(String estadoIntrinseco) { this.estadoIntrinseco = estadoIntrinseco; }
        public String obtenerEstadoIntrinseco() { return estadoIntrinseco; }
    }
    
    final class NoCompartido {
        private final String estadoExtrinseco;
        NoCompartido(String estadoExtrinseco) { this.estadoExtrinseco = estadoExtrinseco; }
    }
    
    final class ObjetoLigero {
        private final Compartido compartido;
        private final NoCompartido noCompartido;
    
        ObjetoLigero(Compartido compartido, NoCompartido noCompartido) {
            this.compartido = compartido;
            this.noCompartido = noCompartido;
        }
    }
    
    final class Fabrica {
        private final java.util.Map<String, Compartido> compartidos = new java.util.HashMap<>();
    
        ObjetoLigero crear(String estadoIntrinseco, String estadoExtrinseco) {
            Compartido compartido = compartidos.computeIfAbsent(
                    estadoIntrinseco, Compartido::new);
            return new ObjetoLigero(compartido, new NoCompartido(estadoExtrinseco));
        }
    }
    ```

=== "Python"

    ```python
    class Flyweight: pass
    class Compartido(Flyweight):
        def __init__(self, intrinseco): self.intrinseco = intrinseco
    class NoCompartido:
        def __init__(self, extrinseco): self.extrinseco = extrinseco
    class ObjetoLigero:
        def __init__(self, compartido, no_compartido):
            self.compartido, self.no_compartido = compartido, no_compartido
    class Fabrica:
        def __init__(self): self.compartidos = {}
        def crear(self, intrinseco, extrinseco):
            compartido = self.compartidos.setdefault(intrinseco, Compartido(intrinseco))
            return ObjetoLigero(compartido, NoCompartido(extrinseco))
    ```

=== "C#"

    ```csharp
    interface Flyweight { string ObtenerEstadoIntrinseco(); }
    
    class Compartido : Flyweight {
        private readonly string intrinseco; public Compartido(string e) => intrinseco = e;
        public string ObtenerEstadoIntrinseco() => intrinseco;
    }
    
    record NoCompartido(string Extrinseco);
    
    record ObjetoLigero(Compartido Compartido, NoCompartido NoCompartido);
    
    class Fabrica {
        private readonly System.Collections.Generic.Dictionary<string, Compartido> compartidos = new();
        public ObjetoLigero Crear(string i, string e) {
            if (!compartidos.ContainsKey(i)) compartidos[i] = new Compartido(i);
            return new ObjetoLigero(compartidos[i], new NoCompartido(e));
        }
    }
    ```

=== "Pseudocódigo"

    ```text
    CLASE Compartido: estadoIntrinseco inmutable
    CLASE ObjetoLigero: Compartido + estadoExtrinseco
    CLASE Fabrica: mapa de objetos Compartido
        crear(intrinseco, extrinseco)
            compartido ← buscar o crear por intrinseco
            RETORNAR ObjetoLigero(compartido, extrinseco)
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
      <td style="text-align:center;"><b>Fabrica</b></td>
      <td style="text-align:justify;">Administra los objetos ligeros y se encarga de crear o reutilizar instancias existentes.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ObjetoLigero</b></td>
      <td style="text-align:justify;">Define la interfaz común para todos los objetos que pueden ser compartidos.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ObjetoLigeroCompartido</b></td>
      <td style="text-align:justify;">Contiene el estado intrínseco (inmutable y compartido entre varios objetos).</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ObjetoLigeroNoCompartido</b></td>
      <td style="text-align:justify;">Contiene el estado extrínseco, específico de cada instancia o contexto.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Cliente</b></td>
      <td style="text-align:justify;">Solicita objetos ligeros a la fábrica y maneja los estados extrínsecos de forma externa.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Una empresa de telefonía cuenta con un sistema que almacena la información básica de diferentes modelos de teléfonos inteligentes —identificador, RAM, disco y costo— y ofrece descuentos a sus clientes en varias épocas del año. Cuando el sistema comenzó a crecer, el equipo de desarrollo notó que el rendimiento de la aplicación se vio perjudicado. Se solicita identificar posibles brechas de rendimiento y proponer acciones de mejora en caso de ser necesario.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo6.flyweight;
    
    import capitulo6.flyweight.dominio.Smartphone;
    import capitulo6.flyweight.dominio.SmartphoneLigero;
    import capitulo6.flyweight.fabrica.FabricaSmartphone;
    
    public class Cliente {
        public static void main(String[] args) {
            flyweight_sin_patron();
            flyweight_con_patron();
        }
    
        public static void flyweight_sin_patron() {
            System.out.println("Objeto completo");
    
            final Smartphone iphone = new Smartphone("1", "8GB", "500GB", 8000);
            System.out.println("\t" + iphone);
    
            final Smartphone samsungS22 = new Smartphone("2", "8GB", "256GB", 6500);
            System.out.println("\t" + samsungS22);
    
            final Smartphone xiaomi = new Smartphone("3", "8GB", "128GB", 1800);
            System.out.println("\t" + xiaomi);
    
            float descuentoSamsungC22 = samsungS22.aplicarDescuento(20);
            float descuentoXiaomi = xiaomi.aplicarDescuento(15);
    
            System.out.println("\n\tCosto con descuento por temporada");
            System.out.println("\t\tSamsungS22 -> Costo original: " + samsungS22.getCosto() + "; Costo con descuento: " + descuentoSamsungC22);
            System.out.println("\t\tXiaomi -> Costo original: " + xiaomi.getCosto() + "; Costo con descuento: " + descuentoXiaomi);
        }
    
        public static void flyweight_con_patron() {
            System.out.println("Objeto ligero");
    
            final SmartphoneLigero iphone12 = FabricaSmartphone.crear("1", "8GB",
                    "500GB", 10000);
            final SmartphoneLigero samsungS21 = FabricaSmartphone.crear("2", "8GB",
                    "500GB", 10000);
            final SmartphoneLigero xiaomi24 = FabricaSmartphone.crear("3", "4GB",
                    "256GB", 5500);
    
            System.out.println("\t" + iphone12 + "\n");
            System.out.println("\t" + samsungS21 + "\n");
            System.out.println("\t" + xiaomi24 + "\n");
    
            float descuentoIphone12 = iphone12.getHardware().aplicarDescuento(50);
            float descuentoXiaomiX = xiaomi24.getHardware().aplicarDescuento(25);
    
            System.out.println("\tCosto con descuento por temporada");
            System.out.println("\t\tIphone12 -> Costo original: "
                    + iphone12.getHardware().getCosto() + "; Costo con descuento: "
                    + descuentoIphone12);
            System.out.println("\t\tXiaomi24 -> Costo original: "
                    + xiaomi24.getHardware().getCosto() + "; Costo con descuento: "
                    + descuentoXiaomiX);
        }
    }
    ```

## Aplicabilidad

Utiliza Flyweight cuando:

- La aplicación mantenga una cantidad muy grande de objetos semejantes.
- El consumo de memoria provenga principalmente de datos repetidos entre esas instancias.
- El estado repetido pueda hacerse inmutable y compartirse de forma segura.
- El estado variable pueda permanecer fuera del objeto compartido y proporcionarse en cada operación.
- El ahorro esperado justifique la complejidad de separar estado intrínseco y extrínseco.

## Cómo implementar

1. Mide el consumo para confirmar que la duplicación de objetos constituye un problema real.
2. Separa el estado intrínseco compartible del estado extrínseco propio de cada contexto.
3. Haz inmutable la clase flyweight y recibe el estado extrínseco como argumento de sus operaciones.
4. Crea una fábrica o caché que identifique y reutilice flyweights existentes.
5. Sustituye las copias repetidas por referencias al objeto compartido.
6. Vuelve a medir memoria y tiempo para comprobar que el intercambio ofrece un beneficio neto.

## Ventajas y desventajas

### Ventajas

- Reduce el consumo de memoria cuando muchas instancias comparten información.
- Centraliza y mantiene consistente el estado intrínseco.
- Puede disminuir el costo de creación de objetos repetidos.

### Desventajas

- Aumenta el costo de calcular, almacenar o transferir el estado extrínseco.
- Hace más complejo el modelo y exige inmutabilidad o sincronización cuidadosa.
- No aporta beneficios si la cantidad de objetos o el estado compartido son pequeños.

## Relación con otros patrones

- [Factory Method](../capitulo-5/factory.md) o una fábrica dedicada puede localizar y devolver flyweights compartidos.
- [Composite](composite.md) puede reutilizar flyweights como hojas cuando muchas contienen el mismo estado.
- Flyweight comparte datos entre múltiples contextos; [Singleton](../capitulo-5/singleton.md) restringe una clase completa a una única instancia.
