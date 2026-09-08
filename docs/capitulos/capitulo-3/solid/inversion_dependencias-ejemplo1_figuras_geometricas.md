<h1 style="text-align:center;">
  <strong> Ejemplo abstracto: Figuras Geométricas (DIP)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar una solución que simule una <b>fábrica de figuras geométricas</b>.
El propósito de la fábrica es centralizar operaciones comunes sobre las figuras, como por ejemplo calcular el <b>área total</b> de todas las figuras registradas en el sistema.
</p>

<p style="text-align:justify;">
En la primera versión del diseño, la clase principal —denominada <code>FiguraManager</code>— dependía directamente de las clases concretas (<code>Circulo</code>, <code>Cuadrado</code>),
lo que generó un <b>alto acoplamiento</b> entre las capas.
Cada vez que se añadía una nueva figura o se modificaba una existente, el código del administrador debía cambiar,
violando el <b>Principio de Inversión de Dependencias (DIP)</b>.
</p>

<p style="text-align:justify;">
El reto consiste en <b>invertir las dependencias</b> de modo que las clases de alto nivel no dependan de implementaciones concretas,
sino de <b>abstracciones</b>.
De esta forma, la fábrica podrá manipular cualquier tipo de figura sin conocer su implementación interna.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar DIP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando DIP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión inicial, la clase <code>FiguraManager</code> instancia directamente los objetos <code>Circulo</code> y <code>Cuadrado</code>
          y depende de sus implementaciones concretas para calcular el área.
          Esto genera un acoplamiento rígido: cualquier cambio en una figura o la introducción de una nueva
          obliga a modificar <code>FiguraManager</code>.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-circulo-java"><b>Circulo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-cuadrado-java"><b>Cuadrado.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figuramanager-java"><b>FiguraManager.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión mejorada, <code>FiguraManager</code> ya no depende de las clases concretas, sino de la <b>abstracción</b> <code>Figura</code>.
          Cada figura (como <code>Circulo</code> o <code>Cuadrado</code>) implementa la interfaz <code>Figura</code>,
          y las dependencias se inyectan desde el exterior, cumpliendo el principio DIP.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-figura-figura-java"><b>Figura.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-circulo-java"><b>Circulo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-cuadrado-java"><b>Cuadrado.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figuramanager-java"><b>FiguraManager.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Inversión de Dependencias</strong></h2>

<p style="text-align:justify;">
En el diseño original, la clase de alto nivel <code>FiguraManager</code> depende directamente de las clases concretas
<code>Circulo</code> y <code>Cuadrado</code>.
Esto significa que la lógica de creación y cálculo de áreas está acoplada a los detalles de implementación,
violando el principio DIP.
</p>

<p style="text-align:justify;">
El sistema funciona correctamente, pero carece de flexibilidad: agregar una nueva figura —por ejemplo, un <code>Triangulo</code>—
obliga a modificar el código de <code>FiguraManager</code> y recompilar todo el módulo.
Además, las pruebas unitarias son más difíciles, porque el componente central no puede ser probado de forma aislada.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/inversion_dependencias/dip_ejemplo1_mal.png"
       width="75%" height="auto" alt="Modelo UML sin aplicar DIP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño inicial acoplado a las implementaciones concretas de las figuras.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio;
    
    import capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Circulo;
    import capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Cuadrado;
    
    import java.util.List;
    
    public class Cliente {
    
        public static void main(String[] args) {
            FiguraManager manager = new FiguraManager();
            manager.agregarCirculos(List.of(new Circulo(2)));
            manager.agregarCuadrados(List.of(new Cuadrado(2)));
    
            System.out.println("Total área figuras: " + manager.getTotalAreas());
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio;
    
    import capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura.Circulo;
    import capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura.Cuadrado;
    import capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura;
    
    import java.util.Arrays;
    import java.util.List;
    
    public class Cliente {
    
        public static void main(String[] args) {
            FiguraManager manager = new FiguraManager();
            List<Figura> figuras = Arrays.asList(new Circulo(2), new Cuadrado(2));
            manager.agregarFiguras(figuras);
            System.out.println("Total área figuras: " + manager.getTotalAreas());
        }
    }
    ```
