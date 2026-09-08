package capitulo7.command.receptor;

import capitulo7.command.comando.IComandoDB;
import capitulo7.command.comando.Invocador;
import capitulo7.command.comando.implementacion.ComandoMySQL;
import capitulo7.command.comando.implementacion.ComandoOracle;
import capitulo7.command.comando.implementacion.ComandoSqlServer;

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
