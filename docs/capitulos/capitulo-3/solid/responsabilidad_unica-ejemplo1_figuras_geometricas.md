<h1 style="text-align:center;">
  <strong> Ejemplo abstracto: Figuras geométricas (SRP)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita crear un sistema que permita <b>calcular las propiedades de diferentes figuras geométricas</b>,
por ejemplo: su <b>perímetro</b>, la <b>suma de sus ángulos interiores</b>, o la <b>longitud de sus diagonales</b>.
Inicialmente, el sistema debe soportar operaciones para <b>rectángulos</b> y <b>círculos</b>,
aunque se espera que en el futuro se amplíe para incluir nuevas figuras y propiedades adicionales.
</p>

<p style="text-align:justify;">
En la primera implementación, se diseñó una única clase <code>Figura</code> que concentra la lógica para todas las figuras geométricas,
definiendo métodos que calculan propiedades específicas según el tipo de figura.
Aunque funcional en un comienzo, este enfoque genera un código difícil de mantener,
pues cualquier cambio o adición de una nueva figura implica modificar la misma clase central.
</p>

<p style="text-align:justify;">
El objetivo es aplicar el <b>Principio de Responsabilidad Única (SRP)</b>, separando las responsabilidades de cálculo y modelado,
para obtener un diseño más <b>modular, extensible y mantenible</b>.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar SRP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando SRP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En esta versión, la clase <code>Figura</code> se encarga de múltiples tareas:
          modelar las propiedades de la figura, calcular perímetros, ángulos y diagonales,
          e incluso determinar el tipo de figura (rectángulo, círculo, etc.).
          Esto viola el principio SRP, ya que la clase tiene más de una razón para cambiar.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-java"><b>Figura.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-tipofigura-java"><b>TipoFigura.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión refactorizada, se divide la lógica en múltiples clases e interfaces.
          La interfaz <code>Figura</code> define el comportamiento común, mientras que las clases concretas
          (<code>Rectangulo</code>, <code>Circulo</code>) se encargan de implementar los cálculos específicos.
          Además, se introducen interfaces especializadas como <code>Poligono</code> para operaciones particulares,
          cumpliendo con el SRP.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-figura-figura-java"><b>Figura.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-poligono-java"><b>Poligono.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-rectangulo-java"><b>Rectangulo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-circulo-java"><b>Circulo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Responsabilidad Única</strong></h2>

<p style="text-align:justify;">
En el diseño inicial, la clase <code>Figura</code> actúa como un contenedor genérico que concentra toda la lógica del sistema.
Para cada tipo de figura, la clase evalúa una enumeración (<code>TipoFigura</code>) y ejecuta operaciones distintas.
Este diseño provoca una alta dependencia interna: cada nueva figura o propiedad requiere modificar la clase central,
aumentando el riesgo de errores y reduciendo la mantenibilidad del código.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/responsabilidad_unica/srp_ejemplo1_mal.png"
       width="85%" height="auto" alt="Modelo UML sin aplicar SRP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño monolítico con múltiples responsabilidades dentro de una sola clase.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.sin_aplicar_principio;
    
    public class Cliente {
    
        public static void main(String[] args) {
            System.out.println("----------------Rectángulo----------------");
            Figura rectangulo = new Figura(10, 12);
            System.out.println("Perimetro: " + rectangulo.getPerimetro());
            System.out.println("Suma ángulos: " + rectangulo.getSumaAngulos());
            System.out.println("Diagonal: " + rectangulo.getDiagonal());
    
            System.out.println("----------------Círculo----------------");
            Figura circulo = new Figura(10);
            System.out.println("Perimetro: " + circulo.getPerimetro());
            System.out.println("Diagonal: " + circulo.getDiagonal());
            System.out.println("Suma ángulos: " + circulo.getSumaAngulos());
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio;
    
    import capitulo3.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Circulo;
    import capitulo3.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura;
    import capitulo3.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Poligono;
    import capitulo3.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Rectangulo;
    
    public class Cliente {
    
        public static void main(String[] args) {
            System.out.println("----------------Rectángulo----------------");
            Poligono rectangulo = new Rectangulo(12, 10);
            System.out.println("Perimetro: " + rectangulo.getPerimetro());
            System.out.println("Suma ángulos: " + rectangulo.getSumaAngulos());
            System.out.println("Diagonal: " + rectangulo.getDiagonal());
    
            System.out.println("----------------Círculo----------------");
            Figura circulo = new Circulo(12);
            System.out.println("Perimetro: " + circulo.getPerimetro());
        }
    }
    ```
