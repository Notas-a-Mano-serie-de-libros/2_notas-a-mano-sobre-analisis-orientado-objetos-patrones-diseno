<h1 style="text-align:center;">
  <strong> Ejemplo abstracto: Figuras geométricas (LSP)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
En el estudio de la geometría se observa un comportamiento interesante: los <b>cuadrados</b> pueden considerarse un caso particular de los <b>rectángulos</b> en el que la base y la altura son iguales.
Con base en esta idea, se solicita implementar un sistema que calcule el área de <b>cuadrados</b> y <b>rectángulos</b> con fines ilustrativos.
</p>

<p style="text-align:justify;">
En su versión inicial, el desarrollador decidió que la clase <code>Cuadrado</code> heredara de <code>Rectangulo</code>, ya que conceptualmente parece lógico.
Sin embargo, esta decisión generó un problema: al sobrescribir los métodos <code>setBase()</code> y <code>setAltura()</code> para mantener las longitudes iguales,
la subclase <code>Cuadrado</code> rompió el comportamiento esperado de la clase base <code>Rectangulo</code>.
Esto constituye una violación del <b>Principio de Sustitución de Liskov (LSP)</b>.
</p>

<p style="text-align:justify;">
El reto consiste en garantizar que las subclases puedan reemplazar a sus superclases sin alterar el comportamiento esperado del programa.
Esto implica diseñar jerarquías que respeten las propiedades y contratos definidos por las clases base.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar LSP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando LSP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En esta versión, la clase <code>Cuadrado</code> hereda de <code>Rectangulo</code> pero sobrescribe los métodos <code>setBase()</code> y <code>setAltura()</code>.
          Esto altera el comportamiento esperado al establecer la base y la altura, ya que ambas se actualizan simultáneamente,
          rompiendo el contrato definido por la clase padre y violando el principio LSP.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-rectangulo-java"><b>Rectangulo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cuadrado-java"><b>Cuadrado.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión corregida, ambas clases implementan una abstracción común (<code>Figura</code> o <code>Calculable</code>),
          pero sin establecer una relación de herencia entre <code>Rectangulo</code> y <code>Cuadrado</code>.
          De esta forma, cada figura respeta su propio comportamiento sin alterar el contrato de otra clase.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-rectangulo-java"><b>Rectangulo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cuadrado-java"><b>Cuadrado.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Sustitución de Liskov</strong></h2>

<p style="text-align:justify;">
En este diseño, <code>Cuadrado</code> hereda de <code>Rectangulo</code> bajo la idea de que “un cuadrado es un rectángulo especial”.
Sin embargo, cuando el cliente asigna valores diferentes a la base y a la altura, el comportamiento del sistema se vuelve inconsistente:
la subclase modifica la lógica del cálculo de área definida por la clase base.
</p>

<p style="text-align:justify;">
Esta implementación rompe el principio LSP porque <b>la subclase no puede sustituir de manera transparente a la superclase</b>
sin alterar el resultado esperado del programa.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/liskov/lsp_ejemplo1_mal.png"
       width="75%" height="auto" alt="Modelo UML sin aplicar LSP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño incorrecto: la subclase altera el comportamiento de la superclase.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.liskov.ejemplo1_figuras_geometrica.sin_aplicar_principio;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Rectangulo rectangulo = new Rectangulo(5, 4);
            Rectangulo cuadrado = new Cuadrado(12); // Área esperada: 144
            cuadrado.setAltura(10); // Modifica uno de los lados
    
            System.out.println("Área del rectangulo: " + rectangulo.getArea());
            System.out.println("Área del cuadrado: " + cuadrado.getArea());
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.liskov.ejemplo1_figuras_geometrica.aplicando_principio;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Rectangulo cuadrado2 = new Cuadrado(12); // Área esperada: 144
            // cuadrado2.setBase(10); Descomentar esta linea causa un error
            System.out.println("Área del cuadrado 2: " + cuadrado2.getArea());
        }
    }
    ```
