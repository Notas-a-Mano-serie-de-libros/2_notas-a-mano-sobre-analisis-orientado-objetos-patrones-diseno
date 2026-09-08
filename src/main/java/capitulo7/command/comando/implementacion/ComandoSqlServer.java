package capitulo7.command.comando.implementacion;

import capitulo7.command.comando.IComandoDB;
import capitulo7.command.receptor.BaseDatos;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComandoSqlServer implements IComandoDB {

    private BaseDatos sqlserver;

    public void ejecutar(final String sql) {
        sqlserver.consultar(sql);
    }
}
