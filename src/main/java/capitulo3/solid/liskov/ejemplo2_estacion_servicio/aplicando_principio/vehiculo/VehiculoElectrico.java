package capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;


import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public class VehiculoElectrico extends Vehiculo {

    private double porcentajeBateria;

    @Override
    public void abastecer(Solicitud solicitud) {
        this.porcentajeBateria = solicitud.getPorcentajeRecarga();
    }
}
