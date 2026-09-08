package capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio;

import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.Vehiculo;

public class EstacionServicio {

    public void reabastecer(Vehiculo vehiculo, Solicitud solicitud) {
        vehiculo.abastecer(solicitud);
    }
}
