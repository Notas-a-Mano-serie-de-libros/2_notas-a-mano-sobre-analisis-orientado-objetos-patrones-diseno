package capitulo7.state.ventanilla.estados;

import capitulo7.state.modelo.Usuario;

public class VentanillaAbierta implements IEstadoVentanilla {

    @Override
    public void atender(final Usuario usuario) {
        System.out.println("Atiende a " + usuario.getNombre());
    }
}
