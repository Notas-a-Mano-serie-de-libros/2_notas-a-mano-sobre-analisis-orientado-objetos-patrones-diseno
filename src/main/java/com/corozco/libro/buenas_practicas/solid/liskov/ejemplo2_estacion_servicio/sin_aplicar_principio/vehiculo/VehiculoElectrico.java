package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo;

public class VehiculoElectrico extends Vehiculo {
    @Override
    public void llenarTanque(double porcentaje) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void recargarBateria(double porcentaje) {
        super.porcentajeBateria = porcentaje;
    }
}
