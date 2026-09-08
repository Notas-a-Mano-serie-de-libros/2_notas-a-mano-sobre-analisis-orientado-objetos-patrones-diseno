package com.corozco.libro.patrones.comportamiento.command.comando.implementacion;

import com.corozco.libro.patrones.comportamiento.command.comando.IComandoDB;
import com.corozco.libro.patrones.comportamiento.command.receptor.BaseDatos;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComandoOracle implements IComandoDB {

    private BaseDatos oracle;

    public void ejecutar(final String sql) {
        oracle.consultar(sql);
    }
}
