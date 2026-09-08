<h1 style="text-align:center;"><strong> Adapter (Adaptador)</strong></h1>

<h4 style="text-align:center;"><em>“Permite que clases con interfaces incompatibles colaboren entre sí mediante un
intermediario que traduce sus interacciones.”</em></h4>


## Definición

<p style="text-align:justify;">
El patrón <b>Adapter</b> pertenece a la familia de los <b>patrones estructurales</b> y tiene como propósito <b>convertir la interfaz de una clase existente</b> en otra que el cliente espera.
De esta forma, dos clases que no podrían trabajar juntas debido a incompatibilidades pueden hacerlo mediante un <b>adaptador</b> que actúa como traductor entre ambas interfaces.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
En muchos sistemas, existen clases o componentes que realizan funciones similares, pero cuya interfaz difiere debido a decisiones de diseño o evolución tecnológica.
El patrón <b>Adapter</b> permite integrar estos componentes sin modificar su código fuente, implementando un intermediario que traduce las llamadas de una interfaz a otra.
Esto es especialmente útil al incorporar <b>APIs externas, bibliotecas de terceros o código legado</b>.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La interfaz <b>IObjetivo</b> define las operaciones esperadas por el cliente.
El <b>Adaptador</b> implementa esta interfaz y traduce las solicitudes del cliente a un formato que pueda entender el <b>ProductoIncompatible</b>.
De esta forma, se consigue una colaboración transparente entre clases originalmente incompatibles.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo6/adapter.png" alt="Diagrama UML del patrón Adapter" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Adapter</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IObjetivo {
        void operacionEsperada();
    }
    
    final class ProductoIncompatible {
        void operacionExistente() { System.out.println("Operación existente"); }
    }
    
    final class Adaptador implements IObjetivo {
        private final ProductoIncompatible adaptado;
        Adaptador(ProductoIncompatible adaptado) { this.adaptado = adaptado; }
        public void operacionEsperada() { adaptado.operacionExistente(); }
    }
    ```

=== "Python"

    ```python
    class IObjetivo:
        def operacion_esperada(self): raise NotImplementedError
    
    class ProductoIncompatible:
        def operacion_existente(self): return "existente"
    
    class Adaptador(IObjetivo):
        def __init__(self, adaptado): self.adaptado = adaptado
        def operacion_esperada(self): return self.adaptado.operacion_existente()
    ```

=== "C#"

    ```csharp
    interface IObjetivo { string OperacionEsperada(); }
    
    class ProductoIncompatible { public string OperacionExistente() => "existente"; }
    
    class Adaptador : IObjetivo {
        private readonly ProductoIncompatible adaptado;
        public Adaptador(ProductoIncompatible adaptado) => this.adaptado = adaptado;
        public string OperacionEsperada() => adaptado.OperacionExistente();
    }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IObjetivo: operacionEsperada()
    CLASE ProductoIncompatible: operacionExistente()
    CLASE Adaptador IMPLEMENTA IObjetivo
        adaptado ← ProductoIncompatible
        operacionEsperada(): RETORNAR adaptado.operacionExistente()
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
      <td style="text-align:center;"><b>IObjetivo</b></td>
      <td style="text-align:justify;">Define la interfaz esperada por el cliente, centralizando las operaciones entre dos clases inicialmente incompatibles.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Producto</b></td>
      <td style="text-align:justify;">Clase que representa la estructura conocida por el sistema cliente.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ProductoIncompatible</b></td>
      <td style="text-align:justify;">Clase existente con una interfaz diferente, que necesita ser adaptada para trabajar con el sistema.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Adaptador</b></td>
      <td style="text-align:justify;">Implementa la interfaz <b>IObjetivo</b> y traduce las llamadas del cliente al formato esperado por <b>ProductoIncompatible</b>.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Cliente</b></td>
      <td style="text-align:justify;">Utiliza la interfaz <b>IObjetivo</b> sin preocuparse de las conversiones internas entre productos incompatibles.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Una empresa cuenta con un sistema para cargar la nómina de sus empleados. Por decisiones de negocio, el sistema necesita importar empleados que provienen de una fuente de datos externa. En este sentido, se solicita establecer un mecanismo que permita cargar la información al sistema.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo6.adapter;
    
    import capitulo6.adapter.dominio.Empleado;
    import capitulo6.adapter.dominio.IEmpleado;
    import capitulo6.adapter.dominio.Trabajador;
    import capitulo6.adapter.dominio.TrabajadorAdapter;
    
    public class Cliente {
        public static void main(String[] args) {
            final IEmpleado empleadoA = new Empleado("11", "Pedro Perez", "+1234");
            final IEmpleado empleadoB = new Empleado("22", "Carlos López", "+5678");
            final IEmpleado empleadoC = new Empleado("33", "Cesar García", "+7890");
            final IEmpleado empleadoD = new Empleado("44", "Andrea Díaz", "+1252");
    
            System.out.println("Empleados");
            System.out.println("\t" + empleadoA);
            System.out.println("\t" + empleadoB);
            System.out.println("\t" + empleadoC);
            System.out.println("\t" + empleadoD);
    
            System.out.println("Trabajador adaptado");
            final IEmpleado empleadoE = new TrabajadorAdapter(
                    new Trabajador(55, "Luisa", "", "Ramirez", null, 6789L, 57));
            System.out.println("\t" + empleadoE);
        }
    }
    ```
