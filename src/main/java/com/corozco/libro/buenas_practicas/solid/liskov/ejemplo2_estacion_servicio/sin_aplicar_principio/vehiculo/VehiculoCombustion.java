package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo;

public class VehiculoCombustion extends Vehiculo {
    @Override
    public void llenarTanque(double porcentaje) {
        super.porcentajeTanque = porcentaje;
    }

    @Override
    public void recargarBateria(double porcentaje) {
        throw new UnsupportedOperationException();
    }
}
