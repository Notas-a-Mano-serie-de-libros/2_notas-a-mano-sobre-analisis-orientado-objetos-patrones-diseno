package capitulo7.command.comando.implementacion;

import capitulo7.command.comando.IComandoDB;
import capitulo7.command.receptor.BaseDatos;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComandoMySQL implements IComandoDB {

    private BaseDatos mysql;

    public void ejecutar(final String sql) {
        mysql.consultar(sql);
    }
}
