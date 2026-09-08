package com.corozco.libro.patrones.comportamiento.state.ventanilla;

import com.corozco.libro.patrones.comportamiento.state.modelo.Usuario;
import com.corozco.libro.patrones.comportamiento.state.ventanilla.estados.IEstadoVentanilla;
import com.corozco.libro.patrones.comportamiento.state.ventanilla.estados.VentanillaAbierta;
import com.corozco.libro.patrones.comportamiento.state.ventanilla.estados.VentanillaCerrada;
import com.corozco.libro.patrones.comportamiento.state.ventanilla.estados.VentanillaSuspendida;

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
