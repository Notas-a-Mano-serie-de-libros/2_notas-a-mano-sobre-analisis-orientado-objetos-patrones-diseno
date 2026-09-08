package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Camara;

public class CamaraSeguridad implements Camara {

    @Override
    public void encender() {
        System.out.println("Enciende cámara.");
    }

    @Override
    public void apagar() {
        System.out.println("Apaga cámara.");
    }


    @Override
    public void tomarFoto() {
        System.out.println("Toma foto.");
    }

    @Override
    public void ajustarBrillo(int nivel) {
        System.out.println("Ajusta brillo a " + nivel + "%");
    }

}
