package capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;

import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public class VehiculoCombustion extends Vehiculo {

    private double porcentajeTanque;

    @Override
    public void abastecer(Solicitud solicitud) {
        this.porcentajeTanque = solicitud.getPorcentajeGasolina();
    }
}
