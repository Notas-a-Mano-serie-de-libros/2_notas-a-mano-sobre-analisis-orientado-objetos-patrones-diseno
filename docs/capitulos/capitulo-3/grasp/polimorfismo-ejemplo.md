<h1 style="text-align:center;">
  <strong> Ejemplo: Calcular el área de varias figuras geométricas</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita diseñar una aplicación capaz de <b>calcular el área de distintas figuras geométricas</b>.
El sistema debe ser extensible, de modo que se puedan incorporar nuevas figuras sin necesidad de modificar el código existente.
Entre las figuras iniciales se incluyen el <b>cuadrado</b> y el <b>círculo</b>.
</p>

<p style="text-align:justify;">
Para cumplir este requisito, se propone la definición de una <b>interfaz común</b> denominada <code>Figura</code>,
que declara la operación <code>calcularArea()</code>.
Cada clase concreta —como <code>Cuadrado</code> y <code>Círculo</code>— implementa esta interfaz,
proporcionando su propia versión del método de cálculo.
De esta manera, se aprovecha el <b>principio de Polimorfismo</b> para lograr un comportamiento dinámico y uniforme en tiempo de ejecución.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Cliente / Ejecución</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-cliente-java"><b>Cliente.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
El siguiente diagrama UML muestra la estructura del modelo propuesto.
La interfaz <code>Figura</code> define el contrato que deben cumplir todas las figuras geométricas,
mientras que las clases <code>Cuadrado</code> y <code>Círculo</code> implementan dicho contrato,
sobrescribiendo el método <code>calcularArea()</code> de acuerdo con su fórmula particular.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/polimorfismo_ejemplo.png"
       width="75%" height="auto"
       alt="Diagrama UML del principio de Polimorfismo aplicado a figuras geométricas"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Aplicación del principio <i>Polimorfismo</i> mediante la interfaz <code>Figura</code> y sus implementaciones concretas.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.polimorfismo.ejemplo;
    
    import capitulo3.grasp.polimorfismo.ejemplo.figura.Circulo;
    import capitulo3.grasp.polimorfismo.ejemplo.figura.Cuadrado;
    import capitulo3.grasp.polimorfismo.ejemplo.figura.Figura;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Figura cuadrado = new Cuadrado(5);
            Figura circulo = new Circulo(3);
    
            System.out.println("Área del cuadrado: " + cuadrado.calcularArea());
            System.out.println("Área del círculo: " + circulo.calcularArea());
        }
    }
    ```
