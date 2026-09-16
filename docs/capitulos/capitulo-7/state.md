<h1 style="text-align:center;">
  <strong> State (Estado)</strong>
</h1>

<h4 style="text-align:center;"><em>“Permite que un objeto altere su comportamiento cuando cambia su estado interno, dando la ilusión de que su clase ha cambiado.”</em></h4>


## Definición

<p style="text-align:justify;">
El <b>patrón State</b> se utiliza cuando un objeto debe cambiar su comportamiento dinámicamente en función de su estado interno.
En lugar de manejar múltiples condicionales o estructuras de control, el patrón encapsula los distintos comportamientos en clases separadas, haciendo que el objeto delegado (el <b>Contexto</b>) cambie su referencia de estado en tiempo de ejecución.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
En un sistema, los objetos pueden tener múltiples comportamientos dependiendo de las condiciones actuales. Por ejemplo, un pedido puede estar en estado <i>Nuevo</i>, <i>Procesado</i> o <i>Entregado</i>; cada uno de estos estados determina las acciones permitidas o restringidas.
Sin el patrón <b>State</b>, estos cambios suelen implementarse con grandes estructuras <code>if-else</code> o <code>switch</code>, que terminan haciendo el código rígido y difícil de mantener.
</p>

<p style="text-align:justify;">
El patrón <b>State</b> propone encapsular los comportamientos en clases separadas, delegando la lógica específica del estado a dichas clases.
De este modo, el <b>Contexto</b> delega las operaciones al estado actual, pudiendo cambiar de comportamiento sin alterar su estructura.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La interfaz <b>IEstado</b> define las operaciones que representan los posibles comportamientos.
Cada <b>EstadoConcreto</b> implementa una versión específica de esas operaciones.
El <b>Contexto</b> mantiene una referencia al estado actual y la cambia dinámicamente conforme el objeto evoluciona.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/state.png" alt="Diagrama UML del patrón State" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>State</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IEstado { void manejar(Contexto contexto); }
    
    final class EstadoConcretoA implements IEstado {
        public void manejar(Contexto contexto) { contexto.cambiarEstado(new EstadoConcretoB()); }
    }
    final class EstadoConcretoB implements IEstado {
        public void manejar(Contexto contexto) { contexto.cambiarEstado(new EstadoConcretoA()); }
    }
    
    final class Contexto {
        private IEstado estado;
        Contexto(IEstado estado) { this.estado = estado; }
        void cambiarEstado(IEstado estado) { this.estado = estado; }
        void solicitud() { estado.manejar(this); }
    }
    ```

=== "Python"

    ```python
    class IEstado:
        def manejar(self, contexto): raise NotImplementedError
    class EstadoConcretoA(IEstado):
        def manejar(self, contexto): contexto.estado = EstadoConcretoB()
    class EstadoConcretoB(IEstado):
        def manejar(self, contexto): contexto.estado = EstadoConcretoA()
    class Contexto:
        def __init__(self, estado): self.estado = estado
        def solicitud(self): self.estado.manejar(self)
    ```

=== "C#"

    ```csharp
    interface IEstado { void Manejar(Contexto contexto); }
    
    class EstadoConcretoA : IEstado { public void Manejar(Contexto c) => c.Estado = new EstadoConcretoB(); }
    
    class EstadoConcretoB : IEstado { public void Manejar(Contexto c) => c.Estado = new EstadoConcretoA(); }
    
    class Contexto { public IEstado Estado { get; set; } public void Solicitud() => Estado.Manejar(this); }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IEstado: manejar(contexto)
    CLASES EstadoConcretoA y EstadoConcretoB IMPLEMENTAN IEstado
    CLASE Contexto: contiene IEstado actual
        solicitud(): estado.manejar(esteContexto)
        cambiarEstado(nuevo): estado ← nuevo
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
      <td style="text-align:center;"><b>IEstado</b></td>
      <td style="text-align:justify;">Interfaz que define las operaciones que todos los estados concretos deben implementar.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>EstadoConcreto</b></td>
      <td style="text-align:justify;">Implementa el comportamiento específico asociado a un estado particular del contexto.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Contexto</b></td>
      <td style="text-align:justify;">Mantiene una referencia al estado actual y delega las operaciones a dicho estado.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Una empresa solicita implementar una aplicación que permita gestionar las solicitudes realizadas por diferentes usuarios en una ventanilla virtual. El sistema debe cumplir las siguientes condiciones:

- La ventanilla puede estar **abierta**: cualquier usuario puede ser atendido.
- La ventanilla puede estar **suspendida**: solo atiende usuarios mayores de 60 años.
- La ventanilla puede estar **cerrada**: no se atiende a ningún usuario.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo7.state;
    
    import capitulo7.state.modelo.Usuario;
    import capitulo7.state.ventanilla.Ventanilla;
    
    public class Cliente {
        public static void main(String[] args) {
            final Usuario carlos = new Usuario(1L, "Carlos Garces", 28);
            final Usuario isabel = new Usuario(2L, "Isabel Lopez", 27);
            final Usuario camilo = new Usuario(3L, "Camilo Perez", 19);
            final Usuario juan = new Usuario(4L, "Juan Narvaez", 65);
            final Usuario andrea = new Usuario(5L, "Andrea Ramirez", 23);
    
            final Ventanilla ventanilla = new Ventanilla();
    
            ventanilla.atender(carlos);
            ventanilla.atender(isabel);
    
            ventanilla.suspender();
            ventanilla.atender(camilo);
            ventanilla.atender(juan);
    
            ventanilla.cerrar();
            ventanilla.atender(andrea);
    
            ventanilla.abrir();
            ventanilla.atender(andrea);
        }
    }
    ```

## Aplicabilidad

Utiliza State cuando:

- El comportamiento de un objeto cambie significativamente según su estado interno.
- Existan condicionales extensos que repitan comprobaciones del mismo estado.
- Cada estado tenga reglas y transiciones propias.
- Quieras incorporar nuevos estados sin modificar todas las operaciones del contexto.
- Escenarios como una ventanilla abierta, suspendida o cerrada necesiten responder de manera diferente a la misma solicitud.

## Cómo implementar

1. Identifica los estados y las operaciones cuyo comportamiento cambia.
2. Define una interfaz de estado con esas operaciones.
3. Extrae cada rama condicional a una clase de estado concreta.
4. Haz que el contexto conserve el estado actual y delegue en él las solicitudes.
5. Decide si las transiciones las controla el contexto o los propios estados.
6. Valida las transiciones permitidas y evita compartir estados que contengan datos mutables del contexto.

## Ventajas y desventajas

### Ventajas

- Sustituye condicionales complejos por comportamiento polimórfico.
- Mantiene juntas las reglas y transiciones de cada estado.
- Facilita añadir estados y probarlos de forma aislada.

### Desventajas

- Incrementa el número de clases cuando existen pocos estados simples.
- Las transiciones pueden quedar distribuidas y ser difíciles de visualizar.
- Un cambio que afecte a todos los estados obliga a actualizar varias clases.

## Relación con otros patrones

```mermaid
flowchart LR
    State((State)) --- Strategy
    State --- Singleton
    State --- Observer
```

- [Strategy](strategy.md) tiene una estructura semejante, pero representa algoritmos elegidos externamente; State modela cambios internos y transiciones.
- [Singleton](../capitulo-5/singleton.md) puede reutilizar estados inmutables compartidos por varios contextos.
- [Observer](observer.md) permite anunciar las transiciones a otros objetos interesados.
