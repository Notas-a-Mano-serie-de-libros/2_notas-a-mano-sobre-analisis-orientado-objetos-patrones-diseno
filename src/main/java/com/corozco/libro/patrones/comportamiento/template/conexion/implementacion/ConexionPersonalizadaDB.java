package com.corozco.libro.patrones.comportamiento.template.conexion.implementacion;

import com.corozco.libro.patrones.comportamiento.template.conexion.Conexion;

public class ConexionPersonalizadaDB extends Conexion {


    @Override
    public void setJDBC() {
        System.out.println("\tUtiliza un controlador personalizado.");
    }

    @Override
    public void autenticar() {
        System.out.println("\tAutenticacion para Base de datos CustomDB.");
    }

    @Override
    public void autorizar() {
        System.out.println("\tAutorizacion para Base de datos CustomDB.");
    }

    @Override
    public void conectar() {
        System.out.println("\tConexion CustomDB exitosa.");
    }
}
