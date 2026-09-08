package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo;

public interface Camara extends Dispositivo {

    void tomarFoto();

    void ajustarBrillo(int nivel);
}
