package com.corozco.libro.patrones.comportamiento.state.ventanilla.estados;

import com.corozco.libro.patrones.comportamiento.state.modelo.Usuario;

public class VentanillaCerrada implements IEstadoVentanilla {

    @Override
    public void atender(final Usuario usuario) {
        System.out.println("La ventanilla está cerrada");
    }
}
