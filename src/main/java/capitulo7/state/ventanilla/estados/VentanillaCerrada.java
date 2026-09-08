package capitulo7.state.ventanilla.estados;

import capitulo7.state.modelo.Usuario;

public class VentanillaCerrada implements IEstadoVentanilla {

    @Override
    public void atender(final Usuario usuario) {
        System.out.println("La ventanilla está cerrada");
    }
}
