package capitulo7.command.comando.implementacion;

import capitulo7.command.comando.IComandoDB;
import capitulo7.command.receptor.BaseDatos;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComandoOracle implements IComandoDB {

    private BaseDatos oracle;

    public void ejecutar(final String sql) {
        oracle.consultar(sql);
    }
}
