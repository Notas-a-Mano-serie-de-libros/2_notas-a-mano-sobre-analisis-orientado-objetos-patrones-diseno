package com.corozco.libro.patrones.comportamiento.state.ventanilla.estados;

import com.corozco.libro.patrones.comportamiento.state.modelo.Usuario;

public class VentanillaAbierta implements IEstadoVentanilla {

    @Override
    public void atender(final Usuario usuario) {
        System.out.println("Atiende a " + usuario.getNombre());
    }
}
