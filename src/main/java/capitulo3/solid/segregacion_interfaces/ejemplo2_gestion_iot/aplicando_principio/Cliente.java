package capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio;

import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Camara;
import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Sensor;
import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto.CamaraSeguridad;
import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto.SensorTemperatura;

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
