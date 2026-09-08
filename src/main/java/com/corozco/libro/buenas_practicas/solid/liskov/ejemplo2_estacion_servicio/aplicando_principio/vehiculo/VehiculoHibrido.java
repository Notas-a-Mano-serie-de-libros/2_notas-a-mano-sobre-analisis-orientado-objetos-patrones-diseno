package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;

import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public class VehiculoHibrido extends Vehiculo {

    private double porcentajeTanque;
    private double porcentajeBateria;

    @Override
    public void abastecer(Solicitud solicitud) {
        this.porcentajeTanque = solicitud.getPorcentajeGasolina();
        this.porcentajeBateria = solicitud.getPorcentajeRecarga();
    }
}
