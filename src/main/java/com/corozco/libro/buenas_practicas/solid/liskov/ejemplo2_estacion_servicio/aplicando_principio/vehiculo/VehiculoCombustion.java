package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;

import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public class VehiculoCombustion extends Vehiculo {

    private double porcentajeTanque;

    @Override
    public void abastecer(Solicitud solicitud) {
        this.porcentajeTanque = solicitud.getPorcentajeGasolina();
    }
}
