package capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio;

import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios.AlmacenamientoArchivo;
import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios.AlmacenamientoDB;
import capitulo3.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.aplicando_principio.servicios.AlmacenamientoNube;

public class Cliente {

    public static void main(String[] args) {
        ServicioAlmacenamiento servicioArchivo = new AlmacenamientoArchivo();
        ServicioAlmacenamiento servicioDB = new AlmacenamientoDB();
        ServicioAlmacenamiento servicioNube = new AlmacenamientoNube();

        String mensaje = "Hola mundo";
        servicioArchivo.guardar(mensaje);
        servicioDB.guardar(mensaje);
        servicioNube.guardar(mensaje);
    }
}
