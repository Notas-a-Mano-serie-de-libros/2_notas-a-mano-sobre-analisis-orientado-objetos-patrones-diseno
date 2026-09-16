<h1 style="text-align:center;">
  <strong> Observer (Observador)</strong>
</h1>

<h4 style="text-align:center;"><em>“Define una dependencia uno-a-muchos entre objetos, de modo que cuando uno cambia su
estado, todos sus dependientes son notificados automáticamente.”</em></h4>


## Definición

<p style="text-align:justify;">
El <b>patrón Observer</b> tiene como propósito <b>mantener sincronizados múltiples objetos</b> sin generar acoplamiento fuerte entre ellos.
Permite que un objeto (denominado <b>Observable</b> o <i>Sujeto</i>) notifique automáticamente a otros objetos (<b>Observadores</b>) sobre cambios en su estado, sin que ninguno conozca los detalles internos del otro.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
Sin el patrón Observer, los objetos dependientes tendrían que consultar continuamente al objeto principal para saber si su estado ha cambiado, generando sobrecarga de procesamiento y alto acoplamiento.
El patrón <b>Observer</b> soluciona este problema al permitir que los observadores se “suscriban” a un sujeto y sean notificados de manera automática cada vez que ocurre un cambio relevante.
</p>

<p style="text-align:justify;">
Este enfoque es ideal para escenarios donde varios componentes deben reaccionar de forma coordinada ante un mismo evento —por ejemplo, interfaces gráficas, sistemas de notificaciones, o plataformas financieras en tiempo real.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La interfaz <b>IObservable</b> declara las operaciones para registrar, eliminar y notificar observadores.
La clase <b>ObservableConcreto</b> gestiona la lista de observadores y notifica los cambios de estado.
Por su parte, la interfaz <b>IObservador</b> define el método que cada observador debe implementar para reaccionar ante las actualizaciones.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/observer.png" alt="Diagrama UML del patrón Observer" width="70%" height="auto"/>
</p>

<p style="text-align:justify;">
La relación entre el <b>Observable</b> y el <b>Observador</b> puede variar según el contexto: puede tratarse de una asociación simple (existencia independiente), una agregación (dependencia temporal) o una composición (dependencia estructural).
El modelo mostrado utiliza agregación para enfatizar la flexibilidad de la relación.
</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IObservador { void actualizar(String evento); }
    interface IObservable {
        void suscribir(IObservador observador);
        void desuscribir(IObservador observador);
        void notificar(String evento);
    }
    
    final class ObservableConcreto implements IObservable {
        private final java.util.List<IObservador> observadores = new java.util.ArrayList<>();
        public void suscribir(IObservador o) { observadores.add(o); }
        public void desuscribir(IObservador o) { observadores.remove(o); }
        public void notificar(String evento) { observadores.forEach(o -> o.actualizar(evento)); }
    }
    
    final class ObservadorConcreto implements IObservador {
        public void actualizar(String evento) { System.out.println(evento); }
    }
    ```

=== "Python"

    ```python
    class IObservador:
        def actualizar(self, evento): raise NotImplementedError
    class IObservable:
        def suscribir(self, observador): raise NotImplementedError
        def notificar(self, evento): raise NotImplementedError
    class ObservableConcreto(IObservable):
        def __init__(self): self.observadores = []
        def suscribir(self, observador): self.observadores.append(observador)
        def notificar(self, evento):
            for observador in self.observadores: observador.actualizar(evento)
    class ObservadorConcreto(IObservador):
        def actualizar(self, evento): self.ultimo = evento
    ```

=== "C#"

    ```csharp
    interface IObservador { void Actualizar(string evento); }
    
    interface IObservable { void Suscribir(IObservador o); void Notificar(string evento); }
    
    class ObservableConcreto : IObservable {
        private readonly System.Collections.Generic.List<IObservador> observadores = new();
        public void Suscribir(IObservador o) => observadores.Add(o);
        public void Notificar(string e) { foreach (var o in observadores) o.Actualizar(e); }
    }
    
    class ObservadorConcreto : IObservador { public void Actualizar(string evento) { } }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IObservador: actualizar(evento)
    INTERFAZ IObservable: suscribir(), desuscribir(), notificar()
    CLASE ObservableConcreto: lista de IObservador
        notificar(evento): PARA CADA observador HACER actualizar(evento)
    CLASE ObservadorConcreto IMPLEMENTA IObservador
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
      <td style="text-align:center;"><b>IObservador</b></td>
      <td style="text-align:justify;">Interfaz que define el contrato que deben implementar los observadores para recibir notificaciones.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ObservadorConcreto</b></td>
      <td style="text-align:justify;">Implementa la acción a ejecutar cuando el observador recibe una notificación del sujeto observado.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>IObservable</b></td>
      <td style="text-align:justify;">Interfaz que define las operaciones necesarias para registrar, eliminar y notificar observadores.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ObservableConcreto</b></td>
      <td style="text-align:justify;">Mantiene una lista de observadores y se encarga de informarles sobre los cambios de estado.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Se solicita implementar un sistema de venta de libros a través de un portal web. El sistema debe contar con una función que permita a los usuarios recibir notificaciones cuando lleguen nuevos libros a la tienda.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo7.observer;
    
    import capitulo7.observer.observable.concreto.Libreria;
    import capitulo7.observer.observador.concreto.Comprador;
    
    public class Cliente {
        public static void main(String[] args) {
    
            final Libreria libreria = new Libreria();
    
            // Los usuarios están suscritos a la librería por defecto
            final Comprador carlos = new Comprador("Carlos", libreria);
            final Comprador julian = new Comprador("Julian", libreria);
    
            libreria.agregarLibro("Clean code");
            libreria.eliminarSuscriptor(julian);
            libreria.agregarLibro("The pragmatic programmer");
            libreria.eliminarSuscriptor(carlos);
            libreria.agregarLibro("Code complete");
            System.out.println("\nLibros en el sistema");
            libreria.getInfoLibros();
        }
    }
    ```
