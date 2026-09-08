package com.corozco.libro.patrones.comportamiento.template.conexion.implementacion;

import com.corozco.libro.patrones.comportamiento.template.conexion.Conexion;

public class ConexionDynamoDB extends Conexion {

    @Override
    public void setJDBC() {
        System.out.println("\tUtiliza controlador DynamoDB.");
    }

    @Override
    public void autenticar() {
        System.out.println("\tAutenticacion de registros indexados.");
    }

    @Override
    public void autorizar() {
        System.out.println("\tAutorizacion para Base de datos no-sql.");
    }

    @Override
    public void conectar() {
        System.out.println("\tConexion a instancia DynamoDB exitosa.");
    }
}
