<h1 style="text-align:center;"><strong> Facade (Fachada)</strong></h1>

<h4 style="text-align:center;"><em>“Ofrece una interfaz unificada y sencilla para acceder a un subsistema complejo, ocultando sus detalles internos.”</em></h4>


## Definición

<p style="text-align:justify;">
El patrón <b>Facade</b> tiene como objetivo <b>simplificar la interacción</b> con uno (o varios) subsistemas.
Proporciona un <b>punto de entrada único</b> que coordina llamadas, ordena pasos y encapsula complejidad, de modo que el código cliente no necesita conocer las clases, dependencias ni orden preciso de invocación dentro del subsistema.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
En proyectos reales, bibliotecas y módulos suelen exponer múltiples clases y operaciones con dependencias entre sí (autenticación, validaciones, adaptadores, conversores, etc.).
Sin una capa de <i>fachada</i>, el cliente debe orquestar pasos y lidiar con errores y estados intermedios.
<b>Facade</b> centraliza esa orquestación: agrupa llamadas, configura los módulos y devuelve resultados listos para usar, reduciendo el acoplamiento y mejorando la legibilidad.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La interfaz <b>IFachada</b> define operaciones de alto nivel.
La implementación <b>FachadaImpl</b> compone e invoca a uno o más <b>Subsistemas</b>, coordinando su ejecución y manejando errores/estados intermedios.
El <b>Cliente</b> interactúa solo con la fachada, sin conocer la complejidad interna del subsistema.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo6/facade.png" width="70%" height="auto" alt="Diagrama UML del patrón Facade"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Facade</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    final class SubsistemaA {
        void operacionA() { System.out.println("Subsistema A"); }
    }
    final class SubsistemaB {
        void operacionB() { System.out.println("Subsistema B"); }
    }
    
    interface IFachada { void operacion(); }
    
    final class FachadaImpl implements IFachada {
        private final SubsistemaA a = new SubsistemaA();
        private final SubsistemaB b = new SubsistemaB();
        public void operacion() {
            a.operacionA();
            b.operacionB();
        }
    }
    ```

=== "Python"

    ```python
    class SubsistemaA:
        def operacion_a(self): return "A"
    class SubsistemaB:
        def operacion_b(self): return "B"
    
    class IFachada:
        def operacion(self): raise NotImplementedError
    
    class FachadaImpl(IFachada):
        def __init__(self): self.a, self.b = SubsistemaA(), SubsistemaB()
        def operacion(self): return self.a.operacion_a() + self.b.operacion_b()
    ```

=== "C#"

    ```csharp
    class SubsistemaA { public void OperacionA() { } }
    
    class SubsistemaB { public void OperacionB() { } }
    
    interface IFachada { void Operacion(); }
    
    class FachadaImpl : IFachada {
        private readonly SubsistemaA a = new(); private readonly SubsistemaB b = new();
        public void Operacion() { a.OperacionA(); b.OperacionB(); }
    }
    ```

=== "Pseudocódigo"

    ```text
    CLASES SubsistemaA, SubsistemaB
    INTERFAZ IFachada: operacion()
    CLASE FachadaImpl IMPLEMENTA IFachada
        contiene SubsistemaA y SubsistemaB
        operacion(): coordinar operacionA() y operacionB()
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
      <td style="text-align:center;"><b>IFachada</b></td>
      <td style="text-align:justify;">Interfaz simplificada que expone operaciones de alto nivel al cliente.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>FachadaImpl</b></td>
      <td style="text-align:justify;">Implementa la interfaz de fachada; coordina y orquesta llamadas a los subsistemas.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>SubsistemaA / SubsistemaB / ...</b></td>
      <td style="text-align:justify;">Clases concretas con lógica especializada. Permanecen ocultas al cliente.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Cliente</b></td>
      <td style="text-align:justify;">Usa exclusivamente la fachada para ejecutar tareas complejas de forma sencilla.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Una empresa está pasando por un proceso de migración en el que busca adoptar prácticas de implementación y despliegue continuo. Sin embargo, el proceso de despliegue requiere que un operador ejecute manualmente cada uno de los pasos de validación durante las etapas de integración y pruebas (*stage*), los cuales siempre son iguales y se ejecutan en el mismo orden desde diferentes ambientes. Con el propósito de avanzar con la migración, se solicita implementar un servicio que encapsule todas las acciones que se deben disparar para desplegar nuevos cambios en el proyecto.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo6.facade;
    
    import capitulo6.facade.abstraccion.IValidador;
    import capitulo6.facade.abstraccion.ValidadorDespliegue;
    
    public class Cliente {
        public static void main(String[] args) {
            IValidador validador = new ValidadorDespliegue();
            validador.validar();
        }
    }
    ```

## Aplicabilidad

Utiliza Facade cuando:

- Un subsistema complejo necesite un punto de entrada simple para sus operaciones frecuentes.
- El cliente esté demasiado acoplado a numerosas clases internas y al orden de sus llamadas.
- Quieras dividir una aplicación en capas con dependencias bien delimitadas.
- Una secuencia repetible, como la validación de un despliegue, deba ejecutarse siempre de manera consistente.
- Necesites ofrecer una API estable mientras el subsistema continúa evolucionando.

## Cómo implementar

1. Identifica los casos de uso que obligan al cliente a coordinar varias clases del subsistema.
2. Crea una fachada con operaciones orientadas a esos casos de uso.
3. Traslada a la fachada la secuencia, configuración y manejo de errores de los colaboradores.
4. Conserva el acceso directo al subsistema solo para los clientes que realmente necesiten funciones avanzadas.
5. Evita que la fachada absorba reglas de negocio que pertenecen a otros componentes.
6. Divide la fachada si crece hasta convertirse en un objeto con demasiadas responsabilidades.

## Ventajas y desventajas

### Ventajas

- Reduce el acoplamiento del cliente con los detalles del subsistema.
- Evita duplicar secuencias de coordinación.
- Ofrece una API más clara, estable y fácil de probar.

### Desventajas

- Puede transformarse en una clase central con demasiadas responsabilidades.
- Una interfaz excesivamente reducida puede ocultar funciones necesarias.
- No elimina por sí sola las dependencias internas del subsistema.

## Relación con otros patrones

- [Adapter](adapter.md) traduce una interfaz; Facade define una entrada más simple a varias interfaces existentes.
- [Mediator](../capitulo-7/mediator.md) organiza la comunicación entre colegas, mientras Facade organiza el acceso de clientes externos.
- [Singleton](../capitulo-5/singleton.md) puede garantizar una única fachada cuando el subsistema comparte estado global.
- [Proxy](proxy.md) puede proteger o controlar el acceso a una fachada.
