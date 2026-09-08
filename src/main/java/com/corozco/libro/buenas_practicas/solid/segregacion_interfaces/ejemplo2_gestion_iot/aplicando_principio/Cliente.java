package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Camara;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Sensor;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto.CamaraSeguridad;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto.SensorTemperatura;

public class Cliente {

    public static void main(String[] args) {
        Sensor sensorTemperatura = new SensorTemperatura();
        sensorTemperatura.encender();
        sensorTemperatura.realizarLectura();
        sensorTemperatura.apagar();

        Camara camaraSeguridad = new CamaraSeguridad();
        camaraSeguridad.encender();
        camaraSeguridad.tomarFoto();
        camaraSeguridad.ajustarBrillo(90);
        camaraSeguridad.apagar();
    }
}
