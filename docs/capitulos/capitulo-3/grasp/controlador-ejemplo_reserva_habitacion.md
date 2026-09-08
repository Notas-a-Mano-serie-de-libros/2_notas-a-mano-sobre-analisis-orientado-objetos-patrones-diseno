<h1 style="text-align:center;">
  <strong> Ejemplo: Sistema de Reserva de Habitaciones</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar un sistema que permita <b>gestionar las reservas de un hotel</b>.
El sistema debe ofrecer las operaciones básicas para <b>crear</b> y <b>eliminar reservas</b>, asociando cada una a un <b>usuario</b> y a un <b>tipo de habitación</b>.
El hotel dispone de tres categorías de habitaciones:
</p>

<ul style="text-align:justify;">
  <li><b>Habitación Sencilla:</b> básica y de menor costo.</li>
  <li><b>Habitación Premium:</b> con servicios adicionales y mayor comodidad.</li>
  <li><b>Habitación de Lujo:</b> con características exclusivas y mayor precio.</li>
</ul>

<p style="text-align:justify;">
Además, el sistema debe ser <b>extensible</b>, permitiendo agregar nuevos tipos de habitaciones en el futuro sin modificar el código existente.
Para lograr este comportamiento, se aplicó el <b>principio Controller</b> de los patrones <b>GRASP</b>, asignando la responsabilidad de coordinar los eventos y solicitudes a una clase controladora: <code>HotelController</code>.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Cliente / Controlador</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Modelo (Dominio)</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Habitaciones</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-cliente-java"><b>Cliente.java</b></a><br/>
        ▶️ <a href="#codigo-hotelcontroller-java"><b>HotelController.java</b></a>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-modelo-usuario-java"><b>Usuario.java</b></a><br/>
        ▶️ <a href="#codigo-modelo-reserva-java"><b>Reserva.java</b></a>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-habitacion-habitacion-java"><b>Habitacion.java</b></a><br/>
        ▶️ <a href="#codigo-habitacion-habitacionsencilla-java"><b>HabitacionSencilla.java</b></a><br/>
        ▶️ <a href="#codigo-habitacion-habitacionpremium-java"><b>HabitacionPremium.java</b></a><br/>
        ▶️ <a href="#codigo-habitacion-habitacionlujo-java"><b>HabitacionLujo.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
En el siguiente diagrama UML se muestra cómo se estructura el sistema aplicando el principio <b>Controller</b>.
La clase <code>HotelController</code> actúa como intermediario entre los objetos del dominio (<code>Reserva</code>, <code>Usuario</code> y <code>Habitación</code>) y los clientes que solicitan servicios.
De este modo, se garantiza una comunicación ordenada, con <b>bajo acoplamiento</b> y <b>alta cohesión</b> entre las clases del sistema.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/controlador_ejemplo.png"
       width="80%" height="auto" alt="Diagrama UML del sistema de reservas aplicando el principio Controller"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Diagrama UML del sistema de reservas de hotel aplicando el principio <i>Controller</i> de GRASP.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.controlador.ejemplo_reserva_habitacion;
    
    import capitulo3.grasp.controlador.ejemplo_reserva_habitacion.habitacion.Habitacion;
    import capitulo3.grasp.controlador.ejemplo_reserva_habitacion.habitacion.HabitacionLujo;
    import capitulo3.grasp.controlador.ejemplo_reserva_habitacion.habitacion.HabitacionPremium;
    import capitulo3.grasp.controlador.ejemplo_reserva_habitacion.habitacion.HabitacionSencilla;
    import capitulo3.grasp.controlador.ejemplo_reserva_habitacion.modelo.Usuario;
    
    import java.util.Date;
    
    public class Cliente {
    
        public static void main(String[] args) throws Exception {
            HotelController manager = new HotelController("Hotel X");
            Habitacion basica = new HabitacionSencilla(1, 1500);
            Habitacion premium = new HabitacionPremium(2, 2000);
            Habitacion lujo = new HabitacionLujo(3, 3000);
    
            Usuario carlos = new Usuario("1", "Carlos", "corozco@foo.com", "1234");
            Usuario andrea = new Usuario("2", "Andrea", "alopez@foo.com", "2345");
            Usuario juan = new Usuario("3", "Juan", "jtopo@foo.com", "3456");
    
            manager.crearReserva(new Date(), new Date(), carlos, basica);
            manager.crearReserva(new Date(), new Date(), andrea, premium);
            manager.crearReserva(new Date(), new Date(), juan, lujo);
    
            String codigoReserva = manager.obtenerCodigoReserva("1");
            manager.cancelarReserva(codigoReserva);
        }
    }
    ```
