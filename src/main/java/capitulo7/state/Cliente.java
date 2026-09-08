package capitulo7.state;

import capitulo7.state.modelo.Usuario;
import capitulo7.state.ventanilla.Ventanilla;

public class Cliente {
    public static void main(String[] args) {
        final Usuario carlos = new Usuario(1L, "Carlos Garces", 28);
        final Usuario isabel = new Usuario(2L, "Isabel Lopez", 27);
        final Usuario camilo = new Usuario(3L, "Camilo Perez", 19);
        final Usuario juan = new Usuario(4L, "Juan Narvaez", 65);
        final Usuario andrea = new Usuario(5L, "Andrea Ramirez", 23);

        final Ventanilla ventanilla = new Ventanilla();

        ventanilla.atender(carlos);
        ventanilla.atender(isabel);

        ventanilla.suspender();
        ventanilla.atender(camilo);
        ventanilla.atender(juan);

        ventanilla.cerrar();
        ventanilla.atender(andrea);

        ventanilla.abrir();
        ventanilla.atender(andrea);
    }
}
