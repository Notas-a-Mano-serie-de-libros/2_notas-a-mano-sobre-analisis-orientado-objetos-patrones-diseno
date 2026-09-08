package com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.sin_aplicar_principio;

public class Cliente {

    public static void main(String[] args) {
        Vicedecanatura vicedecanatura = new Vicedecanatura();
        vicedecanatura.realizarSolicitud(TipoSolicitud.HOMOLOGACION);
        vicedecanatura.realizarSolicitud(TipoSolicitud.VALIDACION);
        vicedecanatura.realizarSolicitud(TipoSolicitud.CANCELACION);
    }
}
