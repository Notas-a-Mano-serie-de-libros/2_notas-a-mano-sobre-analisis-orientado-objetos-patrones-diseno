<h1 style="text-align:center;">
  <strong> Visitor (Visitante)</strong>
</h1>

<h4 style="text-align:center;"><em>“Permite definir nuevas operaciones sobre una jerarquía de clases sin modificar las
clases sobre las que opera.”</em></h4>


## Definición

<p style="text-align:justify;">
El <b>patrón Visitor</b> tiene como objetivo separar las operaciones de los objetos sobre los que actúan.
De esta forma, es posible añadir nuevas operaciones sin alterar la estructura de las clases existentes, cumpliendo el <b>principio abierto/cerrado</b> y favoreciendo la <b>extensibilidad</b> del sistema.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
El patrón <b>Visitor</b> es especialmente útil cuando se tiene una jerarquía de clases estable, pero se desea agregar nuevos comportamientos de forma frecuente.
Modificando las clases base cada vez que se incorpora una nueva operación se rompería el principio de <b>abierto/cerrado</b> y podría comprometer la integridad del sistema.
</p>

<p style="text-align:justify;">
El <b>Visitor</b> propone una solución basada en la <b>doble indirección</b>:
cada objeto de la jerarquía “acepta” un visitante (a través de un método <code>aceptarVisitante()</code>), y el visitante, a su vez, define el comportamiento que se debe ejecutar para ese tipo de objeto.
De este modo, las clases del modelo permanecen estables, mientras que los visitantes encapsulan las operaciones que pueden cambiar con el tiempo.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/visitor_problema.png" alt="Ejemplo del problema abordado por Visitor" width="70%" height="auto"/>
</p>

<p style="text-align:justify;">
Si la abstracción cambia con frecuencia y las subclases son estables, el patrón <b>Visitor</b> permite extender la funcionalidad sin alterar las implementaciones originales.
Esto resulta especialmente útil en sistemas con jerarquías grandes o estructuras complejas, como árboles sintácticos, modelos gráficos o sistemas de reporte.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La interfaz <b>IVisitante</b> define las operaciones que se pueden realizar sobre los distintos elementos del sistema.
Cada clase concreta de la jerarquía (<b>IAbstracción</b> o <b>Implementación</b>) implementa un método <code>aceptarVisitante()</code> que delega la operación al visitante correspondiente, pasándose a sí misma como argumento.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/visitor.png" alt="Diagrama UML del patrón Visitor" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Visitor</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IAbstraccion {
        void aceptar(IVisitante visitante);
    }
    
    final class ImplementacionA implements IAbstraccion {
        public void aceptar(IVisitante visitante) { visitante.visitar(this); }
    }
    
    final class ImplementacionB implements IAbstraccion {
        public void aceptar(IVisitante visitante) { visitante.visitar(this); }
    }
    
    interface IVisitante {
        void visitar(ImplementacionA elemento);
        void visitar(ImplementacionB elemento);
    }
    
    final class VisitanteConcreto implements IVisitante {
        public void visitar(ImplementacionA elemento) { System.out.println("Visita A"); }
        public void visitar(ImplementacionB elemento) { System.out.println("Visita B"); }
    }
    ```

=== "Python"

    ```python
    class IAbstraccion:
        def aceptar(self, visitante): raise NotImplementedError
    class ImplementacionA(IAbstraccion):
        def aceptar(self, visitante): return visitante.visitar_a(self)
    class ImplementacionB(IAbstraccion):
        def aceptar(self, visitante): return visitante.visitar_b(self)
    class IVisitante:
        def visitar_a(self, elemento): raise NotImplementedError
        def visitar_b(self, elemento): raise NotImplementedError
    class VisitanteConcreto(IVisitante):
        def visitar_a(self, elemento): return "visita A"
        def visitar_b(self, elemento): return "visita B"
    ```

=== "C#"

    ```csharp
    interface IAbstraccion { void Aceptar(IVisitante visitante); }
    
    class ImplementacionA : IAbstraccion { public void Aceptar(IVisitante v) => v.Visitar(this); }
    
    class ImplementacionB : IAbstraccion { public void Aceptar(IVisitante v) => v.Visitar(this); }
    
    interface IVisitante { void Visitar(ImplementacionA e); void Visitar(ImplementacionB e); }
    
    class VisitanteConcreto : IVisitante { public void Visitar(ImplementacionA e) { } public void Visitar(ImplementacionB e) { } }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IAbstraccion: aceptar(IVisitante)
    CLASE ImplementacionA: aceptar(v) → v.visitar(esteA)
    CLASE ImplementacionB: aceptar(v) → v.visitar(esteB)
    INTERFAZ IVisitante: visitar(A), visitar(B)
    CLASE VisitanteConcreto IMPLEMENTA ambas operaciones
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
      <td style="text-align:center;"><b>IAbstracción</b></td>
      <td style="text-align:justify;">Interfaz o clase base que define el método <code>aceptarVisitante()</code>, permitiendo a los visitantes operar sobre las instancias concretas.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Implementación</b></td>
      <td style="text-align:justify;">Clase concreta que implementa el método <code>aceptarVisitante()</code> y delega la ejecución del comportamiento al visitante recibido.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>IVisitante</b></td>
      <td style="text-align:justify;">Interfaz que declara los métodos de visita para cada tipo de elemento que puede ser visitado.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>VisitanteConcreto</b></td>
      <td style="text-align:justify;">Clase que implementa las operaciones específicas que se ejecutan sobre los distintos tipos de elementos de la jerarquía.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Una empresa que trabaja en el sector financiero está desarrollando una aplicación para gestionar diversas operaciones con tarjetas de crédito. Sin embargo, debido a decisiones de desarrollo deficientes, el proyecto ha llegado a un punto en el que realizar cambios resulta muy complicado.

Se solicita crear una funcionalidad que permita calcular los intereses y las millas aplicadas a una tarjeta de crédito después de hacer una compra, de acuerdo con las siguientes condiciones:

- La **Tarjeta Básica** no acumula intereses ni millas.
- La **Tarjeta Gold** acumula un interés igual al 1 % del valor de cada compra y no acumula millas.
- La **Tarjeta Platino** acumula un interés igual al 1,5 % del valor de cada compra y acumula 10 millas por cada compra.
- La **Tarjeta Black** acumula un interés igual al 2,1 % del valor de cada compra y acumula 100 millas por cada compra.

Antes de comenzar el análisis de la solución, se establece la directriz de evitar al máximo los cambios sobre el código existente y procurar que el impacto sobre cualquier estructura que deba modificarse sea mínimo.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo7.visitor;
    
    import capitulo7.visitor.abstraccion.Tarjeta;
    import capitulo7.visitor.abstraccion.implementacion.TarjetaBasica;
    import capitulo7.visitor.abstraccion.implementacion.TarjetaBlack;
    import capitulo7.visitor.abstraccion.implementacion.TarjetaGold;
    import capitulo7.visitor.abstraccion.implementacion.TarjetaPlatino;
    import capitulo7.visitor.visitante.concreto.VisitanteCoutaManejo;
    import capitulo7.visitor.visitante.concreto.VisitanteMillas;
    
    public class Cliente {
        public static void main(String[] args) {
    
            //Crea tarjetas y visitantes
            final Tarjeta basica = new TarjetaBasica();
            final Tarjeta gold = new TarjetaGold();
            final Tarjeta platino = new TarjetaPlatino();
            final Tarjeta black = new TarjetaBlack();
    
            //Crea los visitantes
            final VisitanteCoutaManejo coutaManejo = new VisitanteCoutaManejo();
            final VisitanteMillas millas = new VisitanteMillas();
    
            // Realiza compras en el mes con cada tarjeta
            realizarCompras(1, basica, coutaManejo, millas);
            realizarCompras(3, gold, coutaManejo, millas);
            realizarCompras(5, platino, coutaManejo, millas);
            realizarCompras(7, black, coutaManejo, millas);
        }
    
        private static void realizarCompras(final int n, Tarjeta tarjeta, final VisitanteCoutaManejo coutaManejo, final VisitanteMillas millas) {
            System.out.println(tarjeta.getClass().getSimpleName());
            System.out.printf("\t%d Compras en el mes { ", n);
    
            for (int i = 0; i < n; i++) {
                int pago = (int) (Math.random() * (100000 - 10000)) + 10000;
                System.out.print(pago + " ");
                tarjeta.comprar(coutaManejo, millas, pago);
            }
    
            System.out.println("}");
            System.out.println("\tultimoPago: " + tarjeta.getUltimoPago() + "; " + "totalPagos: " + tarjeta.getTotalPagos());
            System.out.println("\tinterés: " + tarjeta.getInteresAcumulado() + "; " + "millas: " + tarjeta.getMillasAcumuladas());

        }
    }
    ```

## Aplicabilidad

Utiliza Visitor cuando:

- Debas añadir con frecuencia operaciones a una estructura de objetos relativamente estable.
- Las operaciones dependan del tipo concreto de cada elemento.
- Quieras mantener fuera de los elementos responsabilidades que pertenecen a otro dominio.
- Una operación necesite acumular información mientras recorre objetos heterogéneos.
- Debas incorporar cálculos como intereses y millas sin modificar repetidamente las clases de tarjetas.

## Cómo implementar

1. Identifica las clases de elementos que formarán la estructura visitable.
2. Define una interfaz de visitante con una operación específica para cada tipo concreto.
3. Añade a la interfaz de elemento una operación `aceptar` que reciba al visitante.
4. Implementa `aceptar` en cada elemento llamando a la operación correspondiente del visitante.
5. Extrae cada nueva operación transversal a un visitante concreto.
6. Recorre la estructura y pasa el mismo visitante a sus elementos; define cómo se acumularán los resultados.

## Ventajas y desventajas

### Ventajas

- Añade operaciones sin modificar las clases de los elementos.
- Reúne en una sola clase la lógica aplicada a tipos distintos.
- Permite acumular estado durante el recorrido.

### Desventajas

- Añadir un nuevo tipo de elemento obliga a modificar todos los visitantes.
- El doble despacho aumenta la complejidad conceptual.
- El visitante puede necesitar acceso a detalles internos y debilitar el encapsulamiento.

## Relación con otros patrones

- [Iterator](iterator.md) puede encargarse del recorrido mientras Visitor ejecuta la operación sobre cada elemento.
- [Composite](../capitulo-6/composite.md) suele aceptar visitantes para aplicar operaciones a sus distintos nodos.
- [Command](command.md) representa una operación como objeto dirigida a un receptor; Visitor distribuye una operación entre tipos heterogéneos mediante doble despacho.
