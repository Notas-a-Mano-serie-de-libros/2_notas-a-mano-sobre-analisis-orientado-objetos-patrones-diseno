package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo;

public abstract class Dispositivo {
    public abstract void encender();

    public abstract void apagar();

    public abstract void tomarFoto();

    public abstract void ajustarBrillo(int nivel);

    public abstract void leerTemperatura();
}
