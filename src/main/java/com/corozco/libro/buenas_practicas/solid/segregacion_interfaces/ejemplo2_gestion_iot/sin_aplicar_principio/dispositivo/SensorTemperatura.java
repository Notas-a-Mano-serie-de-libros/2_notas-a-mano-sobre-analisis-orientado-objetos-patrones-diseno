package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo;

public class SensorTemperatura extends Dispositivo {
    @Override
    public void encender() {
        System.out.println("Enciende sensor.");
    }

    @Override
    public void apagar() {
        System.out.println("Apaga sensor.");
    }

    @Override
    public void tomarFoto() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void ajustarBrillo(int nivel) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leerTemperatura() {
        System.out.println("Lee temperatura.");
    }
}