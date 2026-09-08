package com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio;

import com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.Solicitud;

public class Vicedecanatura {

    public void realizarSolicitud(Solicitud solicitud) {
        solicitud.ejecutar();
    }

}
