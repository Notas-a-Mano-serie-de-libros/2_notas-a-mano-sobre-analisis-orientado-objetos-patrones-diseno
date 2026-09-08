package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;


import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public class VehiculoElectrico extends Vehiculo {

    private double porcentajeBateria;

    @Override
    public void abastecer(Solicitud solicitud) {
        this.porcentajeBateria = solicitud.getPorcentajeRecarga();
    }
}
