package capitulo7.state.ventanilla;

import capitulo7.state.modelo.Usuario;
import capitulo7.state.ventanilla.estados.IEstadoVentanilla;
import capitulo7.state.ventanilla.estados.VentanillaAbierta;
import capitulo7.state.ventanilla.estados.VentanillaCerrada;
import capitulo7.state.ventanilla.estados.VentanillaSuspendida;

public class Ventanilla {

    private IEstadoVentanilla estado;

    public Ventanilla() {
        abrir();
    }

    public void abrir() {
        System.out.println("\nVentanilla abierta");
        this.estado = new VentanillaAbierta();
    }

    public void suspender() {
        System.out.println("\nVentanilla suspendida");
        this.estado = new VentanillaSuspendida();
    }

    public void cerrar() {
        System.out.println("\nVentanilla cerrada");
        this.estado = new VentanillaCerrada();
    }

    public void atender(final Usuario u) {
        System.out.print("\t" + u.getNombre() + " llega a la ventanilla: ");
        this.estado.atender(u);
    }
}
