package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo2_servicio_almacenamiento.sin_aplicar_principio;

public class Cliente {

    public static void main(String[] args) {
        ServicioAlmacenamiento servicio = new ServicioAlmacenamiento();

        String mensaje = "Hola mundo";
        servicio.guardarEnArchivo(mensaje);
        servicio.guardarEnDB(mensaje);
        servicio.guardarEnNube(mensaje);
    }
}