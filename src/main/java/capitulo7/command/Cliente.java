package capitulo7.command;

import capitulo7.command.comando.Invocador;
import capitulo7.command.receptor.ClienteReceptor;

public class Cliente {
    public static void main(String[] args) {
        final Invocador invocador = ClienteReceptor.getComandos();
        final String sql = "Selecciona los primeros diez nombres de la tabla Usuario ordenados por id de forma ascendente";

        System.out.println("Consulta en lenguaje natural");
        System.out.println("\t" + sql);
        invocador.getComandos().forEach(comando -> comando.ejecutar(sql));
    }
}
