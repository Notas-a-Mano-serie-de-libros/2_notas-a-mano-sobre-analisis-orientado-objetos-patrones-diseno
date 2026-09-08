package com.corozco.libro.patrones.comportamiento.state.ventanilla.estados;

import com.corozco.libro.patrones.comportamiento.state.modelo.Usuario;

public interface IEstadoVentanilla {

    void atender(Usuario usuario);
}
