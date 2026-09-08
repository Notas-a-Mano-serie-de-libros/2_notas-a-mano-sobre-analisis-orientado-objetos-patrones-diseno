package com.corozco.libro.patrones.comportamiento.command.comando.implementacion;

import com.corozco.libro.patrones.comportamiento.command.comando.IComandoDB;
import com.corozco.libro.patrones.comportamiento.command.receptor.BaseDatos;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComandoMySQL implements IComandoDB {

    private BaseDatos mysql;

    public void ejecutar(final String sql) {
        mysql.consultar(sql);
    }
}
