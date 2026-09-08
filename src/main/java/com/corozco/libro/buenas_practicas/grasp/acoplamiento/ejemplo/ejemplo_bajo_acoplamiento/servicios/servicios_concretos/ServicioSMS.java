package com.corozco.libro.buenas_practicas.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.servicios_concretos;

import com.corozco.libro.buenas_practicas.grasp.acoplamiento.ejemplo.ejemplo_bajo_acoplamiento.servicios.ServicioNotificacion;

public class ServicioSMS implements ServicioNotificacion {

    @Override
    public void enviarMensaje(final String mensaje) {
    }
}