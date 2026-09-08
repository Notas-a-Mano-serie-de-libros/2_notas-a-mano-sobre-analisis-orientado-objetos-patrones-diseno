package com.corozco.libro.patrones.comportamiento.command.receptor;

import com.corozco.libro.patrones.comportamiento.command.comando.IComandoDB;
import com.corozco.libro.patrones.comportamiento.command.comando.Invocador;
import com.corozco.libro.patrones.comportamiento.command.comando.implementacion.ComandoMySQL;
import com.corozco.libro.patrones.comportamiento.command.comando.implementacion.ComandoOracle;
import com.corozco.libro.patrones.comportamiento.command.comando.implementacion.ComandoSqlServer;

import java.util.Arrays;
import java.util.List;

public class ClienteReceptor {

    public static Invocador getComandos() {
        final List<IComandoDB> comandos = Arrays.asList(
                new ComandoOracle(new Oracle()),
                new ComandoMySQL(new Mysql()),
                new ComandoSqlServer(new Postgres())
        );
        return new Invocador(comandos);
    }
}
