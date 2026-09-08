package com.corozco.libro.buenas_practicas.grasp.cohesion.ejemplo.ejemplo_baja_cohesion;

import com.sun.jdi.connect.spi.Connection;

import java.util.Date;

public final class Utilidades {

    // Magia para gestión de conexiónarme a base de datos
    public void getConexion(String conexion) {
    }

    public void cerrarConexion(Connection conexion) {
    }

    // Magia para gestión de archivos
    public void escribirArchivo(String ruta, String contenido) {
    }

    public void leerArchivo(String ruta) {
    }

    // Magia para realizar peticiones HTTP
    public void enviarPeticionGet(String url) {
    }

    public void enviarPeticionPost(String url, String mensaje) {
    }

    // Magia para parseo de datos
    public void stringToDate(String fecha) {
    }

    public void dateToString(Date fecha) {
    }

    // Magia para gestión de logs
    public void logInfo(String mensajes) {
    }

    public void logError(String mensaje) {
    }
}