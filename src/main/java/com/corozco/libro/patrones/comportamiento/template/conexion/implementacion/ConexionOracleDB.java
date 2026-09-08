package com.corozco.libro.patrones.comportamiento.template.conexion.implementacion;

import com.corozco.libro.patrones.comportamiento.template.conexion.Conexion;

public class ConexionOracleDB extends Conexion {

    @Override
    public void autorizar() {
        System.out.println("\tAutorizacion personalizada para Oracle.");
    }
}
