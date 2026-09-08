package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo.CamaraSeguridad;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo.Dispositivo;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo.SensorTemperatura;

public class Cliente {

    public static void main(String[] args) {
        Dispositivo sensorTemperatura = new SensorTemperatura();
        sensorTemperatura.encender();
        sensorTemperatura.leerTemperatura();

        Dispositivo camaraSeguridad = new CamaraSeguridad();
        camaraSeguridad.encender();
        camaraSeguridad.ajustarBrillo(90);
        camaraSeguridad.leerTemperatura();
    }
}
