<h1 style="text-align:center;"><strong> Prototype (Prototipo)</strong></h1>

<h4 style="text-align:center;"><em>“Crea nuevos objetos clonando instancias existentes en lugar de construirlas desde
cero.”</em></h4>


## Definición

<p style="text-align: justify;">
El <b>patrón Prototype</b> tiene como propósito <b>clonar instancias</b> de una clase mediante el uso de un objeto existente como plantilla.
El nuevo objeto resultante conserva la estructura del prototipo original, permitiendo modificaciones puntuales sin necesidad de conocer los detalles internos de su creación.
</p>

<hr/>

## Motivación

<p style="text-align: justify;">
En ciertos contextos, crear objetos desde cero puede ser un proceso costoso —ya sea por inicializaciones complejas, carga de recursos o configuraciones específicas—.
En estos casos, el patrón Prototype permite duplicar una instancia preexistente y adaptar sus propiedades según las necesidades.
Esta estrategia es especialmente útil cuando los <b>tipos de objetos a instanciar se determinan dinámicamente</b> o cuando las clases concretas son desconocidas.
</p>

<hr/>

## Modelo UML

<p style="text-align: justify;">
La interfaz <b>IPrototipo</b> define el contrato que permite clonar objetos, mientras que las clases concretas implementan la lógica necesaria para realizar copias completas o parciales.
La siguiente figura ilustra el modelo UML del patrón:
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo5/prototype.png" alt="Diagrama UML del patrón Prototype" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Prototype</i>.</p>

<p style="text-align: justify;">
Existen dos enfoques comunes para la clonación:
</p>

<ul style="text-align: justify;">
  <li><b>Clonación superficial:</b> Copia los valores de los tipos primitivos, pero las referencias a objetos apuntan al mismo espacio de memoria.
  Cualquier modificación sobre el objeto clonado afecta al original.</li>
  <li><b>Clonación profunda:</b> Duplica todos los atributos, incluidos los objetos referenciados, generando una copia totalmente independiente.
  Implica un mayor costo computacional, pero elimina los efectos colaterales.</li>
</ul>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IPrototipo {
        IPrototipo clonar();
    }
    
    
    final class PrototipoConcreto implements IPrototipo {
        private final String estado;
    
        PrototipoConcreto(String estado) { this.estado = estado; }
    
        @Override
        public IPrototipo clonar() {
            return new PrototipoConcreto(estado);
        }
    }
    ```

=== "Python"

    ```python
    from copy import deepcopy
    
    class IPrototipo:
        def clonar(self): raise NotImplementedError
    
    class PrototipoConcreto(IPrototipo):
        def __init__(self, estado): self.estado = estado
        def clonar(self): return deepcopy(self)
    ```

=== "C#"

    ```csharp
    interface IPrototipo { IPrototipo Clonar(); }
    
    class PrototipoConcreto : IPrototipo {
        public string Estado { get; }
        public PrototipoConcreto(string estado) => Estado = estado;
        public IPrototipo Clonar() => new PrototipoConcreto(Estado);
    }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IPrototipo: clonar()
    CLASE PrototipoConcreto IMPLEMENTA IPrototipo
        estado
        MÉTODO clonar()
            RETORNAR NUEVO PrototipoConcreto(copia de estado)
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
      <td style="text-align:center;"><b>IPrototipo</b></td>
      <td style="text-align:justify;">Define la operación <code>clonar()</code> que permite crear copias de los objetos.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>PrototipoConcreto</b></td>
      <td style="text-align:justify;">Implementa la interfaz y define la lógica necesaria para realizar la clonación profunda o superficial del objeto.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

El 5 de julio de 1996, un grupo de científicos del Instituto Roslin en la ciudad de Edimburgo clonó el primer mamífero con éxito. Para lograrlo, se basaron en las células de una oveja y tomaron su base genética para obtener una oveja idéntica llamada Dolly. Se solicita crear un programa que permita simular el proceso de clonación de la oveja.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo5.prototype;
    
    import capitulo5.prototype.oveja.IOvejaPrototipo;
    import capitulo5.prototype.oveja.OvejaImpl;
    
    public class Cliente {
        public static void main(String[] args) throws CloneNotSupportedException {
    
            final IOvejaPrototipo original = new OvejaImpl(1L, "original");
            final IOvejaPrototipo dolly = original.clonar();
    
            System.out.println("Información original");
            System.out.println("\toveja: " + original + "\n\tclon:  " + dolly);
    
            dolly.setId(2L);
            dolly.setNombre("Dolly");
    
            System.out.println("Información modificada");
            System.out.println("\toveja: " + original + "\n\tclon:  " + dolly);
    
            System.out.println("\nOvejas iguales: " + (original.equals(dolly) ? "En efecto" : "Soy un clon"));
            System.out.println("Referencia oveja original: " + original.hashCode());
            System.out.println("Referencia Dolly: " + dolly.hashCode());
            System.out.println("Referencias iguales: " + (original.hashCode() == dolly.hashCode()));
        }
    }
    ```
