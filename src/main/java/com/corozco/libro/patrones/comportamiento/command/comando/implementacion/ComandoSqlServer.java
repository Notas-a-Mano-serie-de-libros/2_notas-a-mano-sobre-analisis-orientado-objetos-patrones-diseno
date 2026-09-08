package com.corozco.libro.patrones.comportamiento.command.comando.implementacion;

import com.corozco.libro.patrones.comportamiento.command.comando.IComandoDB;
import com.corozco.libro.patrones.comportamiento.command.receptor.BaseDatos;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComandoSqlServer implements IComandoDB {

    private BaseDatos sqlserver;

    public void ejecutar(final String sql) {
        sqlserver.consultar(sql);
    }
}
