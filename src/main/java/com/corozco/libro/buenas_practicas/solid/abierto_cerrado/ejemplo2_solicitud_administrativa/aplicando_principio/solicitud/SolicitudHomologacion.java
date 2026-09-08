package com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud;

public class SolicitudHomologacion implements Solicitud {

    @Override
    public void ejecutar() {
        System.out.println("Realiza homologación");
    }
}
