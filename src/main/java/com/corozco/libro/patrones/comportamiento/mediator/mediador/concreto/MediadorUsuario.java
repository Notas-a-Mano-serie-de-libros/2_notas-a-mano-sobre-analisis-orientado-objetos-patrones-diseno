package com.corozco.libro.patrones.comportamiento.mediator.mediador.concreto;

import com.corozco.libro.patrones.comportamiento.mediator.colega.Colega;
import com.corozco.libro.patrones.comportamiento.mediator.mediador.Mediador;
import com.corozco.libro.patrones.comportamiento.mediator.modelo.Usuario;

public class MediadorUsuario extends Mediador<Usuario> {

    @Override
    public void enviarMensaje(final String id, final String msg) {
        final Colega<Usuario> obj = super.getMap().get(id);
        if (null != obj) {
            obj.recibirMensaje(msg);
        } else {
            System.out.println("El usuario no existe");
        }
    }
}
