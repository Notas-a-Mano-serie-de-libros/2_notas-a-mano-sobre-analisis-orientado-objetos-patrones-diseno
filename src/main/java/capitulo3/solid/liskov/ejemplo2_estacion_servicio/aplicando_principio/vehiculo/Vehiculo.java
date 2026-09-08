package capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;

import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public abstract class Vehiculo {

    public abstract void abastecer(Solicitud solicitud);
}
