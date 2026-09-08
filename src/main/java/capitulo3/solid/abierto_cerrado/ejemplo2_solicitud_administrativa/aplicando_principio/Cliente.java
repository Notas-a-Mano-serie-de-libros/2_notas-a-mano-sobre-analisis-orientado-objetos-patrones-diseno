package capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio;

import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.Solicitud;
import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.SolicitudCancelacion;
import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.SolicitudHomologacion;
import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.SolicitudValidacion;

public class Cliente {
    public static void main(String[] args) {
        Vicedecanatura vicedecanatura = new Vicedecanatura();

        Solicitud solicitudHomologacion = new SolicitudHomologacion();
        Solicitud solicitudCancelacion = new SolicitudCancelacion();
        Solicitud solicitudValidacion = new SolicitudValidacion();

        vicedecanatura.realizarSolicitud(solicitudHomologacion);
        vicedecanatura.realizarSolicitud(solicitudCancelacion);
        vicedecanatura.realizarSolicitud(solicitudValidacion);
    }
}