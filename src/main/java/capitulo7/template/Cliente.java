package capitulo7.template;

import capitulo7.template.conexion.Conexion;
import capitulo7.template.conexion.implementacion.ConexionDynamoDB;
import capitulo7.template.conexion.implementacion.ConexionMySQLDB;
import capitulo7.template.conexion.implementacion.ConexionOracleDB;
import capitulo7.template.conexion.implementacion.ConexionPersonalizadaDB;

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
