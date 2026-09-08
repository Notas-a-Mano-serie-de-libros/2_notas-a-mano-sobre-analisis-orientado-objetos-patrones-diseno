package capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;

import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public class VehiculoHibrido extends Vehiculo {

    private double porcentajeTanque;
    private double porcentajeBateria;

    @Override
    public void abastecer(Solicitud solicitud) {
        this.porcentajeTanque = solicitud.getPorcentajeGasolina();
        this.porcentajeBateria = solicitud.getPorcentajeRecarga();
    }
}
