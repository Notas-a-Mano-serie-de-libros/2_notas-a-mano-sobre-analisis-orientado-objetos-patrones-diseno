package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo;

import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.Solicitud;

public abstract class Vehiculo {

    public abstract void abastecer(Solicitud solicitud);
}
