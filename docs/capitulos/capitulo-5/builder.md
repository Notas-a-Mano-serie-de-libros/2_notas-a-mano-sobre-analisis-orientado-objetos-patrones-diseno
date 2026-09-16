<h1 style="text-align:center;"><strong> Builder (Constructor)</strong></h1>

<h4 style="text-align:center;"><em>“Separa la construcción de un objeto complejo de su representación, permitiendo crear variantes paso a paso.”</em></h4>


## Definición

<p style="text-align: justify;">
El <b>patrón Builder</b> facilita la construcción de <b>objetos complejos</b> mediante un intermediario (<i>builder</i>) que asigna valores a sus atributos de forma <b>fluida y dinámica</b>.
Su objetivo es evitar constructores con muchas combinaciones de parámetros y mejorar la <b>legibilidad</b>, <b>modularidad</b> y <b>mantenibilidad</b> del código.
</p>

<hr/>

## Motivación
<p style="text-align: justify;">
Cuando un objeto admite múltiples combinaciones de atributos (muchos parámetros opcionales, validaciones o pasos de armado), los constructores tradicionales se vuelven difíciles de usar y mantener (<i>telescoping constructors</i>).
El patrón <b>Builder</b> propone <b>construir el objeto en etapas</b>, encapsulando la lógica de armado y exponiendo una <b>API fluida</b> que guía al cliente, reduciendo errores y mejorando la claridad del código.
</p>

<hr/>

## Modelo UML

<ul>
  <li>
    <p style="text-align: justify;"><b>Builder explícito usando interfaz:</b> La interfaz <b>IBuilder</b> declara las operaciones de construcción. <b>BuilderConcreto</b> implementa los pasos y <b>Producto</b> es el resultado final solicitado por el cliente.</p>
    <p style="text-align:center;">
      <img src="../../../assets/images/contenido/capitulos/capitulo5/builder_abstracto.png" alt="UML Builder con interfaz" width="70%" height="auto">
    </p>
    <p style="text-align:center;"><b>Figura 1.</b> Builder explícito con interfaz.</p>
  </li>

  <li>
    <p style="text-align: justify;"><b>Builder explícito directo:</b> El cliente interactúa con un <b>Builder</b> concreto sin abstracción previa. Aumenta el acoplamiento con el producto, pero simplifica el diagrama cuando solo hay una representación.</p>
    <p style="text-align:center;">
      <img src="../../../assets/images/contenido/capitulos/capitulo5/builder_concreto.png" alt="UML Builder concreto directo" width="70%" height="auto">
    </p>
    <p style="text-align:center;"><b>Figura 2.</b> Builder explícito directo.</p>
  </li>

  <li>
    <p style="text-align: justify;"><b>Builder implícito (anidado):</b> El <b>Builder</b> es una clase estática anidada dentro del <b>Producto</b>. Es el estilo más común en Java moderno y bibliotecas fluent.</p>
    <p style="text-align:center;">
      <img src="../../../assets/images/contenido/capitulos/capitulo5/builder_implicito.png" alt="UML Builder implícito anidado" width="70%" height="auto">
    </p>
    <p style="text-align:center;"><b>Figura 3.</b> Builder implícito (anidado en el producto).</p>
  </li>
</ul>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    final class Producto {
        private String parteA;
        private String parteB;
    
        void setParteA(String parteA) { this.parteA = parteA; }
        void setParteB(String parteB) { this.parteB = parteB; }
    }
    
    interface IBuilder {
        void construirParteA();
        void construirParteB();
        Producto obtenerProducto();
    }
    
    final class BuilderConcreto implements IBuilder {
        private final Producto producto = new Producto();
    
        public void construirParteA() { producto.setParteA("A"); }
        public void construirParteB() { producto.setParteB("B"); }
        public Producto obtenerProducto() { return producto; }
    }
    
    final class Director {
        Producto construir(IBuilder builder) {
            builder.construirParteA();
            builder.construirParteB();
            return builder.obtenerProducto();
        }
    }
    ```

=== "Python"

    ```python
    class Producto:
        def __init__(self): self.partes = []
    
    class IBuilder:
        def construir_parte_a(self): raise NotImplementedError
        def construir_parte_b(self): raise NotImplementedError
        def obtener_producto(self): raise NotImplementedError
    
    class BuilderConcreto(IBuilder):
        def __init__(self): self.producto = Producto()
        def construir_parte_a(self): self.producto.partes.append("A")
        def construir_parte_b(self): self.producto.partes.append("B")
        def obtener_producto(self): return self.producto
    
    class Director:
        def construir(self, builder):
            builder.construir_parte_a(); builder.construir_parte_b()
            return builder.obtener_producto()
    ```

=== "C#"

    ```csharp
    class Producto { public System.Collections.Generic.List<string> Partes { get; } = new(); }
    
    interface IBuilder { void ConstruirParteA(); void ConstruirParteB(); Producto ObtenerProducto(); }
    
    class BuilderConcreto : IBuilder {
        private readonly Producto producto = new();
        public void ConstruirParteA() => producto.Partes.Add("A");
        public void ConstruirParteB() => producto.Partes.Add("B");
        public Producto ObtenerProducto() => producto;
    }
    
    class Director {
        public Producto Construir(IBuilder b) { b.ConstruirParteA(); b.ConstruirParteB(); return b.ObtenerProducto(); }
    }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IBuilder: construirParteA(), obtenerProducto()
    CLASE BuilderConcreto IMPLEMENTA IBuilder
        producto ← NUEVO Producto
        construirParteA(): configurar producto.parteA
        obtenerProducto(): RETORNAR producto
    CLASE Director
        construir(builder): ejecutar pasos y RETORNAR builder.obtenerProducto()
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
      <td style="text-align:center;"><b>Producto</b></td>
      <td style="text-align:justify;">Objeto complejo que se desea construir. Puede requerir múltiples pasos, validaciones y combinaciones de atributos.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>IBuilder</b></td>
      <td style="text-align:justify;">Contrato que define las operaciones de construcción y el método <code>build()</code> para obtener el producto final.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>BuilderConcreto</b></td>
      <td style="text-align:justify;">Implementa los pasos de armado y devuelve <b>this</b> para permitir una API fluida. <code>build()</code> retorna el <b>Producto</b>.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Director</b> (opcional)</td>
      <td style="text-align:justify;">Orquesta la secuencia de construcción cuando se requieren recetas fijas.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Cliente</b></td>
      <td style="text-align:justify;">Configura el Builder y solicita el producto final.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

En el campo de la física, la teoría de cuerdas propone la existencia de múltiples Universos, cada uno con sus propias leyes fundamentales. Se solicita implementar una solución que simule la creación de Universos. Para simplificar el problema, se asume que un Universo se caracteriza por un identificador, un código único, su masa, su porcentaje de materia bariónica —materia conocida—, su porcentaje de materia oscura, su porcentaje de energía oscura —en astronomía se le dice oscuro a todo aquello que no tenemos la más remota idea de qué es— y el conjunto de galaxias que tenga asociado.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo5.builder;
    
    import capitulo5.builder.constructor.GalaxiaBuilder;
    import capitulo5.builder.constructor.GalaxiaBuilderImplicito;
    import capitulo5.builder.constructor.UniversoBuilder;
    import capitulo5.builder.modelo.Galaxia;
    import capitulo5.builder.modelo.GalaxiaConConstructores;
    import capitulo5.builder.modelo.Universo;
    
    import java.util.Arrays;
    import java.util.List;
    
    public class Cliente {
        public static void main(String[] args) {
    
            // Galaxias con constructores (engorroso)
            final Galaxia galaxia1 = new GalaxiaConConstructores(1, "G001");
            final Galaxia galaxia2 = new GalaxiaConConstructores(2, "G002", 1000);
            final Galaxia galaxia3 = new GalaxiaConConstructores(3, "G003", 2000,
                    "ESPIRAL", "GRUPO LOCAL");
    
            // Galaxia fijando los valores uno por uno (código espagueti)
            final Galaxia galaxia4 = new Galaxia();
            galaxia4.setId(5);
            galaxia4.setCodigo("G005");
            galaxia4.setMasa(5000);
            galaxia4.setGrupo("GRUPO LOCAL");
    
            final List<Galaxia> galaxias = Arrays.asList(galaxia1, galaxia2, galaxia3, galaxia4);
    
            // Universo tiene builder
            final Universo universo1 = new UniversoBuilder(1, "Universo 1").pMateriaBarionica(100).build();
            final Universo universo2 = new UniversoBuilder(2, "Universo 2").galaxias(galaxias).build();
            System.out.println(universo1 + "\n" + universo2);
    
            // Galaxia creada con builder
            final Galaxia galaxia5 = new GalaxiaBuilder(6, "G006").masa(1000).tipo("ESPIRAL").grupo("GRUPO DE SAGITARIO").build();
    
            // Galaxia con builder implícito
            final Galaxia galaxia6 = GalaxiaBuilderImplicito.builder(6, "G006").masa(6000).tipo("ELIPTICA").build();
    
            // Otro Universo con builder
            final Universo universo3 = new UniversoBuilder(3, "Universo 3")
                    .pMateriaBarionica(0).pMateriaOscura(25).pEnergiaOscura(75)
                    .galaxias(Arrays.asList(galaxia5, galaxia6))
                    .build();
    
            System.out.println(universo3);
        }
    }
    ```
