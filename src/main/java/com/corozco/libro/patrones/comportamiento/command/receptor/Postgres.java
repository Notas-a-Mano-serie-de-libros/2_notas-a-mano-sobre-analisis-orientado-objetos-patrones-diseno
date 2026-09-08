package com.corozco.libro.patrones.comportamiento.command.receptor;

public class Postgres extends BaseDatos {
    @Override
    public void consultar(final String sql) {
        System.out.println("Instancia de SqlServer");
        System.out.println("\tConsulta final: SELECT TOP 10 u.nombre FROM Usuario u ORDER BY u.id ASC;");
    }
}
