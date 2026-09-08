package capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio;

import capitulo3.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.aplicando_principio.solicitud.Solicitud;

public class Vicedecanatura {

    public void realizarSolicitud(Solicitud solicitud) {
        solicitud.ejecutar();
    }

}
