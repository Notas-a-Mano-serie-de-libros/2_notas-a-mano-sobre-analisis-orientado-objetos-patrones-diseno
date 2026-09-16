<h1 style="text-align:center;"><strong> Abstract Factory (Fábrica Abstracta)</strong></h1>

<h4 style="text-align:center;"><em>“Proporciona una interfaz para crear familias de objetos relacionados sin especificar
sus clases concretas.”</em></h4>


## Definición

<p style="text-align:justify;">
El patrón <b>Abstract Factory</b> tiene como propósito <b>proveer una interfaz común</b> para la creación de familias de productos que comparten una estructura o propósito.
De esta manera, el cliente puede solicitar la creación de objetos sin conocer las clases concretas, dependiendo solo de las fábricas abstractas que encapsulan la lógica de instanciación.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
En muchos sistemas, los objetos no existen de forma aislada, sino como parte de <b>familias de productos relacionados</b>.
Por ejemplo, una aplicación de interfaz gráfica puede tener distintos conjuntos de componentes (botones, menús, cuadros de texto) para cada sistema operativo o tema visual.
El patrón <b>Abstract Factory</b> permite crear estos conjuntos de productos <b>de forma consistente</b> sin acoplar el código cliente a las implementaciones concretas, apoyándose en el <b>principio de inversión de dependencias</b>.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La interfaz <b>IFabricaAbstracta</b> define los métodos para crear distintos tipos de productos.
Cada <b>FabricaConcreta</b> implementa esta interfaz y devuelve las instancias concretas de los productos pertenecientes a una misma familia.
Así, el cliente puede trabajar únicamente con la fábrica abstracta sin conocer los detalles de cada clase concreta.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo5/abstract_factory.png" alt="Diagrama UML del patrón Abstract Factory" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Abstract Factory</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IProductoAbstractoA { void operacionA(); }
    interface IProductoAbstractoB { void operacionB(); }
    
    final class ProductoConcretoA1 implements IProductoAbstractoA {
        public void operacionA() { System.out.println("Producto A de la familia 1"); }
    }
    final class ProductoConcretoB1 implements IProductoAbstractoB {
        public void operacionB() { System.out.println("Producto B de la familia 1"); }
    }
    final class ProductoConcretoA2 implements IProductoAbstractoA {
        public void operacionA() { System.out.println("Producto A de la familia 2"); }
    }
    final class ProductoConcretoB2 implements IProductoAbstractoB {
        public void operacionB() { System.out.println("Producto B de la familia 2"); }
    }
    
    interface IFabricaAbstracta {
        IProductoAbstractoA crearProductoA();
        IProductoAbstractoB crearProductoB();
    }
    
    final class FabricaConcreta1 implements IFabricaAbstracta {
        public IProductoAbstractoA crearProductoA() { return new ProductoConcretoA1(); }
        public IProductoAbstractoB crearProductoB() { return new ProductoConcretoB1(); }
    }
    
    final class FabricaConcreta2 implements IFabricaAbstracta {
        public IProductoAbstractoA crearProductoA() { return new ProductoConcretoA2(); }
        public IProductoAbstractoB crearProductoB() { return new ProductoConcretoB2(); }
    }
    ```

=== "Python"

    ```python
    class IProductoAbstractoA: pass
    class IProductoAbstractoB: pass
    class ProductoConcretoA1(IProductoAbstractoA): pass
    class ProductoConcretoB1(IProductoAbstractoB): pass
    class ProductoConcretoA2(IProductoAbstractoA): pass
    class ProductoConcretoB2(IProductoAbstractoB): pass
    
    class IFabricaAbstracta:
        def crear_producto_a(self): raise NotImplementedError
        def crear_producto_b(self): raise NotImplementedError
    
    class FabricaConcreta1(IFabricaAbstracta):
        def crear_producto_a(self): return ProductoConcretoA1()
        def crear_producto_b(self): return ProductoConcretoB1()
    
    class FabricaConcreta2(IFabricaAbstracta):
        def crear_producto_a(self): return ProductoConcretoA2()
        def crear_producto_b(self): return ProductoConcretoB2()
    ```

=== "C#"

    ```csharp
    interface IProductoAbstractoA { }
    
    interface IProductoAbstractoB { }
    
    class ProductoConcretoA1 : IProductoAbstractoA { }
    
    class ProductoConcretoB1 : IProductoAbstractoB { }
    
    class ProductoConcretoA2 : IProductoAbstractoA { }
    
    class ProductoConcretoB2 : IProductoAbstractoB { }
    
    interface IFabricaAbstracta { IProductoAbstractoA CrearA(); IProductoAbstractoB CrearB(); }
    
    class FabricaConcreta1 : IFabricaAbstracta {
        public IProductoAbstractoA CrearA() => new ProductoConcretoA1();
        public IProductoAbstractoB CrearB() => new ProductoConcretoB1();
    }
    
    class FabricaConcreta2 : IFabricaAbstracta {
        public IProductoAbstractoA CrearA() => new ProductoConcretoA2();
        public IProductoAbstractoB CrearB() => new ProductoConcretoB2();
    }
    ```

=== "Pseudocódigo"

    ```text
    INTERFACES IProductoAbstractoA, IProductoAbstractoB
    INTERFAZ IFabricaAbstracta: crearProductoA(), crearProductoB()
    CLASE FabricaConcreta1 IMPLEMENTA IFabricaAbstracta
        crearProductoA(): RETORNAR ProductoConcretoA1
        crearProductoB(): RETORNAR ProductoConcretoB1
    CLIENTE usa solo IFabricaAbstracta y productos abstractos
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
      <td style="text-align:center;"><b>IFabricaAbstracta</b></td>
      <td style="text-align:justify;">Declara un conjunto de métodos para crear productos abstractos pertenecientes a la misma familia.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>FabricaConcreta</b></td>
      <td style="text-align:justify;">Implementa los métodos de la fábrica abstracta y crea productos específicos pertenecientes a una familia concreta.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ProductoAbstracto</b></td>
      <td style="text-align:justify;">Define la interfaz común para los objetos que conforman una familia de productos.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ProductoConcreto</b></td>
      <td style="text-align:justify;">Implementa el comportamiento específico de un producto perteneciente a una familia concreta.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Cliente</b></td>
      <td style="text-align:justify;">Utiliza únicamente las interfaces abstractas tanto de las fábricas como de los productos, manteniendo independencia de las implementaciones concretas.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Se solicita crear un juego de estrategia llamado «History of Empires», un simulador que permita controlar a una cultura entre varias disponibles, ver su evolución con el paso del tiempo y luchar con otras civilizaciones. El objetivo del juego es avanzar progresivamente a través de diferentes eras —piedra, bronce, medieval, industrial y contemporánea—. Por diseño, cada era cuenta con un conjunto de unidades asociadas con su contexto histórico.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo5.abstract_factory;
    
    import capitulo5.abstract_factory.dominio.UnidadNaval;
    import capitulo5.abstract_factory.dominio.UnidadTierra;
    import capitulo5.abstract_factory.fabrica.FabricaAbstracta;
    import capitulo5.abstract_factory.fabrica.concreto.FabricaEraIndustrial;
    import capitulo5.abstract_factory.fabrica.concreto.FabricaEraMedieval;
    
    public class Cliente {
        public static void main(String[] args) {
    
            // Crea unidades específicas de la era medieval
            final FabricaAbstracta eraMedieval = new FabricaEraMedieval();
            final UnidadTierra espadachin = eraMedieval.crearUnidadTierra();
            final UnidadNaval galeon = eraMedieval.crearUnidadNaval();
    
            System.out.println("Era medieval");
            espadachin.atacar();
            espadachin.defender();
            galeon.navegar();
            galeon.atacar();
    
            // Crea unidades específicas de la era industrial
            final FabricaAbstracta eraIndustrial = new FabricaEraIndustrial();
            final UnidadTierra fusilero = eraIndustrial.crearUnidadTierra();
            final UnidadNaval buqueVapor = eraIndustrial.crearUnidadNaval();
    
            System.out.println("Era industrial");
            fusilero.atacar();
            fusilero.defender();
            buqueVapor.navegar();
            buqueVapor.atacar();
        }
    }
    ```

## Aplicabilidad

Utiliza Abstract Factory cuando:

- El sistema deba crear familias de objetos diseñados para colaborar entre sí.
- Sea necesario cambiar una familia completa sin modificar el código cliente.
- Quieras impedir combinaciones incompatibles de productos, como unidades pertenecientes a eras diferentes.
- Las clases concretas de creación deban quedar aisladas detrás de contratos estables.
- Varias plataformas, temas, proveedores o contextos ofrezcan las mismas categorías de productos.

## Cómo implementar

1. Identifica las categorías de productos que aparecen en todas las familias.
2. Define una interfaz abstracta para cada categoría de producto.
3. Declara en la fábrica abstracta una operación de creación por cada categoría.
4. Implementa una fábrica concreta para cada familia, devolviendo productos compatibles entre sí.
5. Haz que el cliente reciba la fábrica mediante configuración o inyección y dependa solo de abstracciones.
6. Prueba cada fábrica como una unidad para verificar que nunca mezcle productos de familias diferentes.

## Ventajas y desventajas

### Ventajas

- Garantiza la compatibilidad de los productos creados por una misma fábrica.
- Permite sustituir una familia completa desde un único punto.
- Evita que el cliente conozca constructores o clases concretas.

### Desventajas

- Añadir una nueva categoría de producto obliga a modificar todas las fábricas concretas.
- Incrementa el número de interfaces y clases del diseño.
- Puede resultar excesivo cuando solo existe un producto o no hay familias intercambiables.

## Relación con otros patrones

- Suele implementar cada operación mediante [Factory Method](factory.md).
- Puede utilizar [Prototype](prototype.md) para crear los productos a partir de ejemplares registrados.
- La fábrica concreta puede ser un [Singleton](singleton.md) si debe existir una sola instancia por aplicación.
- [Builder](builder.md) se enfoca en construir un producto complejo paso a paso, mientras Abstract Factory entrega familias de productos relacionados.
