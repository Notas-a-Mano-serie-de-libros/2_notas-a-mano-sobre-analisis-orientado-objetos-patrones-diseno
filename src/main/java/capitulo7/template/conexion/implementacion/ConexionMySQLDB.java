package capitulo7.template.conexion.implementacion;

import capitulo7.template.conexion.Conexion;

public class ConexionMySQLDB extends Conexion {


    @Override
    public void autenticar() {
        System.out.println("\tAutenticacion personalizada para MySQL.");
    }

}
