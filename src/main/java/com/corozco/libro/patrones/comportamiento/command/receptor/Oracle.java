package com.corozco.libro.patrones.comportamiento.command.receptor;

public class Oracle extends BaseDatos {
    @Override
    public void consultar(final String sql) {
        System.out.println("Instancia de Oracle");
        System.out.println("\tConsulta MySQL: SELECT u.nombre FROM Usuario u ORDER BY u.id ASC fetch first 10 rows only;");
    }
}
