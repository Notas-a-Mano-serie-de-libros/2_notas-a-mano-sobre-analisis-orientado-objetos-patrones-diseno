<h1 style="text-align:center;">
  <strong> Ejemplo: Figuras Geométricas</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar un programa capaz de <b>calcular el área de diferentes figuras geométricas</b>.
El sistema debe ser capaz de manejar figuras como <b>círculos</b> y <b>rectángulos</b>, y además, debe permitir <b>agregar nuevas figuras</b> en el futuro sin alterar el código existente.
</p>

<p style="text-align:justify;">
En una primera versión, el desarrollador optó por crear una clase utilitaria encargada de calcular el área de las figuras según su tipo.
Sin embargo, este diseño generó un problema importante: cada vez que se añadía una nueva figura, era necesario <b>modificar la clase de utilidades</b>, violando así el <b>Principio Abierto/Cerrado (OCP)</b>.
La meta del ejercicio es <b>refactorizar el diseño</b> para cumplir con el OCP, haciendo que el sistema sea extensible sin modificar el código existente.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar OCP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando OCP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En esta versión, la clase <code>UtilidadArea</code> centraliza la lógica del cálculo y utiliza estructuras condicionales (<code>if</code>, <code>switch</code>)
          para determinar el tipo de figura.
          Cada vez que se agrega una nueva figura (por ejemplo, un triángulo o un polígono), es necesario modificar esta clase,
          lo que rompe el principio de cerrado a la modificación.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-figura-java"><b>Figura.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-circulo-java"><b>Circulo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-rectangulo-java"><b>Rectangulo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-utilidadarea-java"><b>UtilidadArea.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión mejorada, se define una <b>interfaz común</b> <code>Figura</code> con el método <code>calcularArea()</code>.
          Cada clase concreta (<code>Circulo</code>, <code>Rectangulo</code>, etc.) implementa esta interfaz y define su propia lógica de cálculo.
          Si se requiere agregar una nueva figura, basta con crear una nueva clase que implemente <code>Figura</code> sin modificar el código existente.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-figura-figura-java"><b>Figura.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-circulo-java"><b>Circulo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-rectangulo-java"><b>Rectangulo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Abierto/Cerrado</strong></h2>

<p style="text-align:justify;">
En el diseño original, el cálculo del área de cada figura se realiza dentro de la clase <code>UtilidadArea</code>,
la cual recibe instancias de diferentes tipos y utiliza condicionales para determinar cómo calcular el área.
Este enfoque genera un <b>alto acoplamiento</b> entre la lógica de negocio y las clases concretas de las figuras,
ya que cualquier cambio o nueva figura requiere modificar el código existente.
</p>

<p style="text-align:justify;">
Por ejemplo, si se agrega una nueva figura como <code>Triangulo</code>, se debe añadir un nuevo caso dentro de la clase <code>UtilidadArea</code>,
lo que infringe el principio de cerrado a la modificación.
El mantenimiento se vuelve costoso y el código más propenso a errores.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/abierto_cerrado/ocp_ejemplo1_mal.png"
       width="75%" height="auto" alt="Modelo UML sin aplicar OCP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño inicial acoplado con cálculos centralizados en una clase de utilidad.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio;
    
    import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Circulo;
    import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;
    import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Rectangulo;
    
    public class Cliente {
    
        public static void main(String[] args) {
            UtilidadArea utilidad = new UtilidadArea();
            Figura rectangulo = new Rectangulo(5, 2);
            Figura circulo = new Circulo(12);
    
            System.out.println("Área del rectángulo: " + utilidad.getArea(rectangulo));
            System.out.println("Área del círculo: " + utilidad.getArea(circulo));
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.aplicando_principio;
    
    import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.aplicando_principio.figura.Circulo;
    import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura;
    import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.aplicando_principio.figura.Rectangulo;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Figura rectangulo = new Rectangulo(5, 2);
            Figura circulo = new Circulo(12);
    
            System.out.println("Área del rectángulo: " + rectangulo.getArea());
            System.out.println("Área del círculo: " + circulo.getArea());
        }
    }
    ```
