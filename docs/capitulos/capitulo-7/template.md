<h1 style="text-align:center;">
  <strong> Template Method (Método Plantilla)</strong>
</h1>

<h4 style="text-align:center;"><em>“Define el esqueleto de un algoritmo en una operación, delegando algunos pasos a las subclases.”</em></h4>


## Definición

<p style="text-align:justify;">
El <b>patrón Template Method</b> permite definir una estructura general (plantilla) para resolver un problema, dejando que las subclases redefinan pasos específicos sin alterar la secuencia global del algoritmo.
De esta manera, se garantiza consistencia entre las implementaciones, promoviendo la reutilización de código y la extensión controlada del comportamiento.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
En muchos sistemas, los algoritmos comparten una misma secuencia de pasos, pero algunos detalles varían dependiendo del contexto o la implementación concreta.
El <b>Template Method</b> proporciona una solución elegante a este escenario al definir una <b>plantilla</b> en una clase base que establece el flujo general del proceso, permitiendo a las subclases sobrescribir las partes específicas que necesitan personalización.
</p>

<p style="text-align:justify;">
Este patrón sigue el principio de <b>Inversión de control</b>: la superclase controla la estructura del algoritmo y las subclases definen los detalles, invirtiendo así el flujo tradicional de ejecución.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La clase <b>Plantilla</b> define un método principal (el “método plantilla”) que establece el orden de ejecución de los pasos de un algoritmo.
Cada subclase concreta (<b>Implementación</b>) puede redefinir uno o más de esos pasos sin modificar la estructura global.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/template_method.png" alt="Diagrama UML del patrón Template Method" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Template Method</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    abstract class Plantilla {
        public final void algoritmo() {
            pasoFijo();
            pasoVariable();
            gancho();
        }
    
        private void pasoFijo() { System.out.println("Paso común"); }
        protected abstract void pasoVariable();
        protected void gancho() { }
    }
    
    final class ImplementacionA extends Plantilla {
        protected void pasoVariable() { System.out.println("Variante A"); }
    }
    
    final class ImplementacionB extends Plantilla {
        protected void pasoVariable() { System.out.println("Variante B"); }
    }
    ```

=== "Python"

    ```python
    class Plantilla:
        def algoritmo(self):
            self.paso_fijo(); self.paso_variable(); self.gancho()
        def paso_fijo(self): pass
        def paso_variable(self): raise NotImplementedError
        def gancho(self): pass
    class ImplementacionA(Plantilla):
        def paso_variable(self): return "A"
    class ImplementacionB(Plantilla):
        def paso_variable(self): return "B"
    ```

=== "C#"

    ```csharp
    abstract class Plantilla {
        public void Algoritmo() { PasoFijo(); PasoVariable(); Gancho(); }
        private void PasoFijo() { }
        protected abstract void PasoVariable();
        protected virtual void Gancho() { }
    }
    
    class ImplementacionA : Plantilla { protected override void PasoVariable() { } }
    
    class ImplementacionB : Plantilla { protected override void PasoVariable() { } }
    ```

=== "Pseudocódigo"

    ```text
    CLASE ABSTRACTA Plantilla
        algoritmo FINAL(): pasoFijo(); pasoVariable(); gancho()
        pasoFijo(): implementación común
        pasoVariable(): ABSTRACTO
    CLASE ImplementacionA EXTIENDE Plantilla: redefine pasoVariable()
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
      <td style="text-align:center;"><b>Plantilla</b></td>
      <td style="text-align:justify;">Define el flujo genérico del algoritmo y declara los pasos que las subclases pueden sobrescribir. Contiene el método plantilla que define la secuencia de pasos.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Implementación</b></td>
      <td style="text-align:justify;">Sobrescribe los pasos definidos como “personalizables” dentro de la plantilla para ajustar la solución a un caso concreto.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Una empresa necesita implementar la lógica que facilite el acceso a diferentes bases de datos. Por diseño, la conexión a cualquier base de datos realiza los siguientes pasos en el mismo orden: (i) establecer el controlador de la base de datos, (ii) realizar el proceso de autenticación, (iii) realizar la autorización y, finalmente, (iv) conectar la instancia de la base de datos. Se solicita definir un modelo que facilite la creación de conexiones a cualquier base de datos utilizando controladores genéricos. Sin embargo, el sistema también debe permitir la creación de instancias con controladores personalizados. Inicialmente, la empresa necesita crear conexiones para Oracle, MySQL, PostgreSQL y una base de datos propietaria llamada CustomSQL. Además, el sistema debe permitir crear conexiones para la base de datos no relacional DynamoDB.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo7.template;
    
    import capitulo7.template.conexion.Conexion;
    import capitulo7.template.conexion.implementacion.ConexionDynamoDB;
    import capitulo7.template.conexion.implementacion.ConexionMySQLDB;
    import capitulo7.template.conexion.implementacion.ConexionOracleDB;
    import capitulo7.template.conexion.implementacion.ConexionPersonalizadaDB;
    
    public class Cliente {
        public static void main(String[] args) {
            (new Conexion()).start(); //Conexion generica
            (new ConexionMySQLDB()).start(); //Conexion MySQL
            (new ConexionOracleDB()).start(); //Conexion Oracle
            (new Conexion()).start(); //Conexion PostgreSQL
            (new ConexionPersonalizadaDB()).start(); //Conexion personalizada
            (new ConexionDynamoDB()).start(); //Conexion Dynamo
        }
    }
    ```

## Aplicabilidad

Utiliza Template Method cuando:

- Varios algoritmos compartan una secuencia estable, pero difieran en algunos pasos.
- Quieras evitar duplicar el esqueleto de un proceso entre subclases.
- Determinadas etapas deban ejecutarse siempre en el mismo orden.
- Un framework necesite ofrecer puntos de extensión controlados.
- Procesos como la conexión a distintas bases de datos compartan autenticación, autorización y conexión.

## Cómo implementar

1. Identifica la secuencia común y los pasos que pueden variar.
2. Crea una clase base con el método plantilla que invoque esos pasos en orden.
3. Declara como abstractos los pasos obligatorios que cada subclase debe implementar.
4. Proporciona implementaciones por defecto para los pasos opcionales.
5. Añade hooks vacíos cuando las subclases necesiten intervenir sin alterar el flujo completo.
6. Protege el método plantilla frente a sobrescrituras si la secuencia constituye una regla invariable.

## Ventajas y desventajas

### Ventajas

- Reutiliza la parte común de varios algoritmos.
- Mantiene en un solo lugar el orden y las invariantes del proceso.
- Ofrece puntos de extensión explícitos y controlados.

### Desventajas

- Acopla las variantes a una clase base mediante herencia.
- Una plantilla con demasiados pasos puede ser difícil de entender y mantener.
- Los cambios en la clase base pueden afectar a todas las subclases.

## Relación con otros patrones

- [Strategy](strategy.md) representa una alternativa basada en composición cuando debe sustituirse el algoritmo completo.
- [Factory Method](../capitulo-5/factory.md) puede aparecer como un paso del método plantilla para variar el objeto creado.
