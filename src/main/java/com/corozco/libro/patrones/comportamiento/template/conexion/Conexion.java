package com.corozco.libro.patrones.comportamiento.template.conexion;

public class Conexion {

    public final void start() {
        System.out.println("Inicia " + this.getClass().getSimpleName());
        setJDBC();
        autenticar();
        autorizar();
        conectar();
    }

    protected void setJDBC() {
        System.out.println("\tUtiliza el controlador generico.");
    }

    protected void autenticar() {
        System.out.println("\tAutenticacion generica.");
    }

    protected void autorizar() {
        System.out.println("\tAutorizacion generica.");
    }

    protected void conectar() {
        System.out.println("\tConexion generica exitosa.");
    }
}
