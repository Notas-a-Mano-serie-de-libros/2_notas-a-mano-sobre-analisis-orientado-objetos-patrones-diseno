package capitulo3.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.servicios_concretos;

import capitulo3.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.ServicioNotificacion;

public class ServicioEmail implements ServicioNotificacion {

    @Override
    public void enviarMensaje(final String mensaje) {
    }
}
