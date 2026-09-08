<h1 style="text-align:center;">
  <strong> Ejemplo: Servicio de Notificaciones</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita diseñar un sistema que permita <b>enviar alertas personalizadas</b> a los usuarios.
El sistema debe ser capaz de manejar distintos canales de comunicación, como <b>correo electrónico</b>, <b>mensajes SMS</b> y <b>notificaciones push</b>.
Además, la arquitectura debe ser lo suficientemente flexible como para permitir la incorporación de <b>nuevos tipos de mensajes</b> en el futuro sin requerir modificaciones sustanciales en el código existente.
</p>

<p style="text-align:justify;">
El reto principal consiste en evitar un <b>alto acoplamiento</b> entre los componentes del sistema.
En un diseño inicial poco estructurado, cada clase responsable del envío de mensajes depende directamente de las demás, lo que hace que cualquier cambio en un canal de notificación afecte al resto del sistema.
El objetivo es aplicar el principio de <b>bajo acoplamiento</b> para obtener una solución más <b>modular, extensible y fácil de mantener</b>.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Alto acoplamiento</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Bajo acoplamiento</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify; margin:0 0 8px 0;">
          La clase cliente <b>conoce</b> e invoca implementaciones concretas, generando dependencia rígida.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-ejemplo-alto-acoplamiento-cliente-java"><b>Cliente.java</b></a></li>
          <li>▶️ <a href="#codigo-ejemplo-alto-acoplamiento-servicionotificacion-java"><b>ServicioNotificacion.java</b></a></li>
          <li>▶️ <a href="#codigo-ejemplo-alto-acoplamiento-tiposervicio-java"><b>TipoServicio.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify; margin:0 0 8px 0;">
          La clase cliente depende de <b>abstracciones</b> (interfaces/contratos). Agregar un canal nuevo no exige modificar el cliente.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-ejemplo-bajo-acoplamiento-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML con alto acoplamiento</strong></h2>

<p style="text-align:justify;">
En la primera versión del sistema, cada módulo depende directamente de las implementaciones concretas de los diferentes canales de notificación.
Esto implica que la clase principal debe conocer los detalles de cada servicio (por ejemplo, <code>CorreoService</code>, <code>SMSService</code> o <code>PushService</code>), creando un <b>acoplamiento fuerte</b> y reduciendo la capacidad del sistema para adaptarse a nuevos requerimientos.
</p>

<p style="text-align:justify;">
Como resultado, si se desea añadir un nuevo canal de notificación (por ejemplo, <em>mensajes por WhatsApp</em> o <em>notificaciones por Slack</em>), es necesario modificar directamente la clase principal, violando así el <b>principio abierto/cerrado (OCP)</b>.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/alto_acoplamiento_ejemplo.png"
       width="85%" height="auto" alt="Modelo UML de alto acoplamiento en un servicio de notificaciones"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño inicial con alto acoplamiento entre los componentes.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.grasp.acoplamiento.ejemplo.ejemplo_alto_acoplamiento;
    
    public class Cliente {
        public static void main(String[] args) {
            ServicioNotificacion manager = new ServicioNotificacion();
            manager.notificar("Hola mundo por mail", TipoServicio.EMAIL);
            manager.notificar("Hola mundo por mensaje SMS", TipoServicio.SMS);
            manager.notificar("Hola mundo como alerta push", TipoServicio.PUSH);
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento;
    
    import capitulo3.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.ServicioNotificacion;
    import capitulo3.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.servicios_concretos.ServicioEmail;
    import capitulo3.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.servicios_concretos.ServicioPush;
    import capitulo3.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.servicios_concretos.ServicioSMS;
    
    public class Cliente {
        public static void main(String[] args) {
    
            final ServicioNotificacion email = new ServicioEmail();
            final ServicioNotificacion sms = new ServicioSMS();
            final ServicioNotificacion push = new ServicioPush();
    
            final String mensaje = "Hola mundo";
            email.enviarMensaje(mensaje);
            sms.enviarMensaje(mensaje);
            push.enviarMensaje(mensaje);
        }
    }
    ```
