package capitulo7.template.conexion.implementacion;

import capitulo7.template.conexion.Conexion;

public class ConexionOracleDB extends Conexion {

    @Override
    public void autorizar() {
        System.out.println("\tAutorizacion personalizada para Oracle.");
    }
}
