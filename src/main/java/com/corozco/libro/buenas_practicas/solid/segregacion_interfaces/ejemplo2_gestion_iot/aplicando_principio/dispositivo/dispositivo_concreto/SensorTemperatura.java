package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Sensor;


public class SensorTemperatura implements Sensor {

    @Override
    public void encender() {
        System.out.println("Enciende sensor.");
    }

    @Override
    public void apagar() {
        System.out.println("Apaga sensor.");
    }

    @Override
    public void realizarLectura() {
        System.out.println("Leyendo temperatura.");
    }
}
