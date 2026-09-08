package capitulo7.state.ventanilla.estados;

import capitulo7.state.modelo.Usuario;

public class VentanillaSuspendida implements IEstadoVentanilla {
    @Override
    public void atender(final Usuario usuario) {
        if (usuario.getEdad() > 60) {
            System.out.println(usuario.getNombre() + " es prioritario");
        } else {
            System.out.println("La ventanilla está suspendida");
        }
    }
}
