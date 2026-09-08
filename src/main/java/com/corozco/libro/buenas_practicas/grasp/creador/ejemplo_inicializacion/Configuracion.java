package com.corozco.libro.buenas_practicas.grasp.creador.ejemplo_inicializacion;

public class Configuracion {

    private String zonaHoraria = "UTC-5";
    private String host;
    private String usuario;
    private String contrasena;
    
    public Configuracion(String host, String usuario, String contrasena) {
        this.host = host;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Conexion crearConexion() {
        return new Conexion(this.host, this.usuario, this.contrasena);
    }
}