<h1 style="text-align:center;">
  <strong> Ejemplo abstracto: Figuras geométricas (ISP)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar una solución que permita calcular las <b>propiedades geométricas</b> básicas
de distintas figuras: <b>longitud</b>, <b>área</b> y <b>volumen</b>.
El sistema debe ser capaz de manejar figuras en una, dos y tres dimensiones, como <code>Circunferencia</code>, <code>Círculo</code> y <code>Esfera</code>.
</p>

<p style="text-align:justify;">
En el diseño inicial, todas las figuras implementaban una única interfaz <code>Figura</code> que declaraba métodos para las tres propiedades,
independientemente de si una figura realmente las necesitaba.
Por ejemplo, una <code>Circunferencia</code> (1D) no requiere calcular área o volumen,
pero se veía obligada a implementar esos métodos, generando comportamientos vacíos o excepciones.
</p>

<p style="text-align:justify;">
Este diseño viola el <b>Principio de Segregación de Interfaces (ISP)</b>, que establece que
<b>ninguna clase debe verse forzada a depender de métodos que no utiliza</b>.
El reto consiste en separar las responsabilidades en interfaces más pequeñas y específicas para cada tipo de figura,
respetando sus propiedades reales.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar ISP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando ISP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión inicial, todas las figuras implementan una interfaz genérica <code>Figura</code>
          que define métodos para calcular longitud, área y volumen.
          Este diseño obliga a las figuras 1D (como la <code>Circunferencia</code>) a implementar métodos que no aplican,
          como <code>calcularArea()</code> o <code>calcularVolumen()</code>, violando el principio de segregación de interfaces.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-figura-java"><b>Figura.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-figuras-concretas-circunferencia-java"><b>Circunferencia.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-figuras-concretas-circulo-java"><b>Circulo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-figura-figuras-concretas-esfera-java"><b>Esfera.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión refactorizada, se introducen interfaces específicas según el tipo de figura:
          <code>Propiedades1D</code>, <code>Propiedades2D</code> y <code>Propiedades3D</code>.
          De este modo, cada clase concreta implementa solo los métodos que realmente necesita,
          manteniendo la coherencia con su naturaleza geométrica y cumpliendo el principio ISP.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-figura-propiedades-propiedades1d-java"><b>Propiedades1D.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-propiedades-propiedades2d-java"><b>Propiedades2D.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-propiedades-propiedades3d-java"><b>Propiedades3D.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-figuras-concretas-circunferencia-java"><b>Circunferencia.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-figuras-concretas-circulo-java"><b>Circulo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-figura-figuras-concretas-esfera-java"><b>Esfera.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Segregación de Interfaces</strong></h2>

<p style="text-align:justify;">
El diseño inicial agrupa todas las operaciones en una única interfaz <code>Figura</code>.
Este enfoque genera una interfaz demasiado grande (“<em>interface gorda</em>”), que obliga a todas las figuras a conocer métodos
que no les son relevantes.
Esto afecta la cohesión y provoca una dependencia innecesaria entre clases.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/segregacion_interfaces/isp_ejemplo1_mal.png"
       width="80%" height="auto" alt="Modelo UML sin aplicar ISP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño incorrecto: una interfaz monolítica obliga a implementar métodos no aplicables.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio;
    
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas.Circulo;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas.Circunferencia;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas.Esfera;
    
    public class Cliente {
    
        public static void main(String[] args) {
            System.out.println("-------------Esfera (3D)-------------");
            Figura esfera = new Esfera(12);
            System.out.println("Longitud:" + esfera.getLongitud());
            System.out.println("Área:" + esfera.getArea());
            System.out.println("Volumen:" + esfera.getVolumen());
    
            System.out.println("-------------Circulo (2D)-------------");
            Figura circulo = new Circulo(12);
            System.out.println("Longitud:" + circulo.getLongitud());
            System.out.println("Área:" + circulo.getArea());
            System.out.println("Volumen:" + circulo.getVolumen());
    
            System.out.println("-------------Circunferencia (1D)-------------");
            Figura circunferencia = new Circunferencia(12);
            System.out.println("Longitud:" + circunferencia.getLongitud());
            System.out.println("Área:" + circunferencia.getArea());
            System.out.println("Volumen:" + circunferencia.getVolumen());
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio;
    
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura1D;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura2D;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura3D;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas.Circulo;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas.Circunferencia;
    import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas.Esfera;
    
    public class Cliente {
    
        public static void main(String[] args) {
            System.out.println("-------------Esfera (3D)-------------");
            Figura3D esfera = new Esfera(12);
            System.out.println("Longitud: " + esfera.getLongitud());
            System.out.println("Área: " + esfera.getArea());
            System.out.println("Volumen: " + esfera.getVolumen());
            System.out.println("Dimensión: " + esfera.getDimension());
    
            System.out.println("-------------Circulo (2D)-------------");
            Figura2D circulo = new Circulo(12);
            System.out.println("Longitud: " + circulo.getLongitud());
            System.out.println("Área: " + circulo.getArea());
            System.out.println("Dimensión: " + circulo.getDimension());
    
            System.out.println("-------------Circunferencia (1D)-------------");
            Figura1D circunferencia = new Circunferencia(12);
            System.out.println("Longitud: " + circunferencia.getLongitud());
            System.out.println("Dimensión: " + circunferencia.getDimension());
        }
    }
    ```
