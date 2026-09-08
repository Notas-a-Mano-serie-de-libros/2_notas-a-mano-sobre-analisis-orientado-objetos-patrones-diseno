package com.corozco.libro.patrones.comportamiento.template;

import com.corozco.libro.patrones.comportamiento.template.conexion.Conexion;
import com.corozco.libro.patrones.comportamiento.template.conexion.implementacion.ConexionDynamoDB;
import com.corozco.libro.patrones.comportamiento.template.conexion.implementacion.ConexionMySQLDB;
import com.corozco.libro.patrones.comportamiento.template.conexion.implementacion.ConexionOracleDB;
import com.corozco.libro.patrones.comportamiento.template.conexion.implementacion.ConexionPersonalizadaDB;

public class Cliente {
    public static void main(String[] args) {
        (new Conexion()).start(); //Conexion generica
        (new ConexionMySQLDB()).start(); //Conexion MySQL
        (new ConexionOracleDB()).start(); //Conexion Oracle
        (new Conexion()).start(); //Conexion PostgreSQL
        (new ConexionPersonalizadaDB()).start(); //Conexion personalizada
        (new ConexionDynamoDB()).start(); //Conexion Dynamo
    }
}
