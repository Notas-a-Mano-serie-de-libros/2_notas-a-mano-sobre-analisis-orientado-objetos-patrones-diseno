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
