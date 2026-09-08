package com.corozco.libro.buenas_practicas.grasp.creador.ejemplo_inicializacion;

public class Cliente {

    public static void main(String[] args) {
        Configuracion configuracion = new Configuracion("host", "usuario", "1234");
        configuracion.crearConexion();
    }
}
