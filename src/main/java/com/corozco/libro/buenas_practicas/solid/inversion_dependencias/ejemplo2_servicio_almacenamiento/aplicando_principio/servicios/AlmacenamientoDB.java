package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios;

import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.ServicioAlmacenamiento;

public class AlmacenamientoDB implements ServicioAlmacenamiento {

    @Override
    public void guardar(String info) {
        System.out.println("Guarda en base de datos");
    }
}
