package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo;

import lombok.Getter;

@Getter
public abstract class Vehiculo {

    protected double porcentajeTanque;
    protected double porcentajeBateria;

    public abstract void llenarTanque(double porcentajeTanque);

    public abstract void recargarBateria(double porcentajeBateria);
}
