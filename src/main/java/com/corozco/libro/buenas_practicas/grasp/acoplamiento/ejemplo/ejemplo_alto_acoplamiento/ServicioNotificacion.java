package com.corozco.libro.buenas_practicas.grasp.acoplamiento.ejemplo.ejemplo_alto_acoplamiento;


import com.corozco.libro.buenas_practicas.grasp.acoplamiento.ejemplo.ejemplo_alto_acoplamiento.servicios.ServicioEmail;
import com.corozco.libro.buenas_practicas.grasp.acoplamiento.ejemplo.ejemplo_alto_acoplamiento.servicios.ServicioPush;
import com.corozco.libro.buenas_practicas.grasp.acoplamiento.ejemplo.ejemplo_alto_acoplamiento.servicios.ServicioSMS;

public class ServicioNotificacion {

    private final ServicioEmail email = new ServicioEmail();
    private final ServicioSMS sms = new ServicioSMS();
    private final ServicioPush push = new ServicioPush();

    public void notificar(final String mensaje, final TipoServicio tipo) {
        switch (tipo) {
            case EMAIL:
                email.enviarEmail(mensaje);
                break;
            case SMS:
                sms.enviarSMS(mensaje);
                break;
            case PUSH:
                push.enviarAlerta(mensaje);
                break;
            default:
                System.out.println("Tipo de mensaje inválido");
                break;
        }
    }
}
