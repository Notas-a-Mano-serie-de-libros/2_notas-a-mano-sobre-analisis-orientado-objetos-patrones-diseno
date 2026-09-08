<h1 style="text-align:center;">
  <strong> Ejemplo: Relación de Agregación</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
En este ejemplo se modela la relación entre un <b>Equipo</b> y sus <b>Jugadores</b> dentro de una aplicación de gestión deportiva.
Cada equipo debe ser capaz de <b>crear y agregar nuevos jugadores</b> a su plantilla, asignándoles un nombre y un número identificador.
El sistema debe garantizar que la creación de jugadores se realice de forma controlada y coherente con la estructura del equipo al que pertenecen.
</p>

<p style="text-align:justify;">
De acuerdo con el principio <b>Creator</b> de los patrones <b>GRASP</b>, la responsabilidad de crear instancias de <code>Jugador</code> recae sobre la clase <code>Equipo</code>, ya que:
</p>

<ul style="text-align:justify;">
  <li>La clase <code>Equipo</code> <b>contiene</b> objetos de tipo <code>Jugador</code> mediante una relación de <b>agregación</b>.</li>
  <li><code>Equipo</code> posee la <b>información necesaria</b> para inicializar correctamente a cada jugador (nombre y número).</li>
  <li>El ciclo de vida y la gestión de los jugadores están <b>conceptualmente ligados</b> a la entidad <code>Equipo</code>.</li>
</ul>

<p style="text-align:justify;">
Asignar la responsabilidad de creación a <code>Equipo</code> favorece un diseño con <b>bajo acoplamiento</b> y <b>alta cohesión</b>, ya que evita que otras clases conozcan los detalles internos de cómo se crean y administran los jugadores.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Cliente</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Entidades del dominio</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-cliente-java"><b>Cliente.java</b></a>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-equipo-java"><b>Equipo.java</b></a><br/>
        ▶️ <a href="#codigo-jugador-java"><b>Jugador.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
El siguiente diagrama UML representa la relación de <b>agregación</b> entre las clases <code>Equipo</code> y <code>Jugador</code>.
La operación <code>agregarJugador()</code> encapsula la creación de instancias de <code>Jugador</code> dentro de la clase <code>Equipo</code>, cumpliendo con el principio <b>Creator</b>.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/creador_agregacion.png"
       width="70%" height="auto" alt="Diagrama UML de relación de agregación entre Equipo y Jugador"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Diagrama UML de la relación de agregación entre <code>Equipo</code> y <code>Jugador</code>.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.creador.ejemplo_agregacion;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Equipo equipo = new Equipo("Equipo1");
            equipo.agregarJugador("Carlos", 10);
            equipo.agregarJugador("Julian", 11);
        }
    }
    ```
