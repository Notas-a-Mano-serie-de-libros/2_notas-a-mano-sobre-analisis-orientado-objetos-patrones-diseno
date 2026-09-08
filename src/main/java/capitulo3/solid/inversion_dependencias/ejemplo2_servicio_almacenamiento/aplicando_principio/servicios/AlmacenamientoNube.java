package capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios;

import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.ServicioAlmacenamiento;

public class AlmacenamientoNube implements ServicioAlmacenamiento {

    @Override
    public void guardar(String info) {
        System.out.println("Guarda en la nube");
    }
}
