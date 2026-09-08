package capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios;

import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.ServicioAlmacenamiento;

public class AlmacenamientoArchivo implements ServicioAlmacenamiento {

    @Override
    public void guardar(String info) {
        System.out.println("Guarda en archivo");
    }
}
