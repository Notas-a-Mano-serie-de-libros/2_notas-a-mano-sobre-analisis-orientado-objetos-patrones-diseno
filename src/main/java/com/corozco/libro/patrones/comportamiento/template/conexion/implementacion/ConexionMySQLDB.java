package com.corozco.libro.patrones.comportamiento.template.conexion.implementacion;

import com.corozco.libro.patrones.comportamiento.template.conexion.Conexion;

public class ConexionMySQLDB extends Conexion {


    @Override
    public void autenticar() {
        System.out.println("\tAutenticacion personalizada para MySQL.");
    }

}
