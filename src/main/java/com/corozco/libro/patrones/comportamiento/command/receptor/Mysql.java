package com.corozco.libro.patrones.comportamiento.command.receptor;

public class Mysql extends BaseDatos {
    @Override
    public void consultar(final String sql) {
        System.out.println("Instancia de MySQL");
        System.out.println("\tConsulta MySQL: SELECT u.nombre FROM Usuario u ORDER BY u.id ASC LIMIT 10;");
    }
}
