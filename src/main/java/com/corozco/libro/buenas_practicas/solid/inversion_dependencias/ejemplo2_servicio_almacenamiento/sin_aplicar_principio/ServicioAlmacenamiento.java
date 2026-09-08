package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.sin_aplicar_principio.servicios.AlmacenamientoArchivo;
import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.sin_aplicar_principio.servicios.AlmacenamientoDB;
import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.sin_aplicar_principio.servicios.AlmacenamientoNube;

public class ServicioAlmacenamiento {

    private AlmacenamientoArchivo servicioArchivo = new AlmacenamientoArchivo();
    private AlmacenamientoDB servicioDB = new AlmacenamientoDB();
    private AlmacenamientoNube servicioNube = new AlmacenamientoNube();

    public void guardarEnArchivo(String info) {
        servicioArchivo.guardar(info);
    }

    public void guardarEnDB(String info) {
        servicioDB.guardar(info);
    }

    public void guardarEnNube(String info) {
        servicioNube.guardar(info);
    }
}
