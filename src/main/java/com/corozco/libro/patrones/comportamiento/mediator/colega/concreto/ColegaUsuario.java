package com.corozco.libro.patrones.comportamiento.mediator.colega.concreto;

import com.corozco.libro.patrones.comportamiento.mediator.colega.Colega;
import com.corozco.libro.patrones.comportamiento.mediator.mediador.Mediador;
import com.corozco.libro.patrones.comportamiento.mediator.modelo.Usuario;

public class ColegaUsuario extends Colega<Usuario> {

    public ColegaUsuario(final Mediador<Usuario> mediador, final Usuario colega, final String label) {
        super(mediador, colega, label);
    }

    @Override
    public void enviarMensaje(final String id, final String msg) {
        System.out.println("\t" + super.getLabel() + " :: Envia mensaje: " + msg);
        super.getMediador().enviarMensaje(id, msg);
    }

    @Override
    public void recibirMensaje(final String msg) {
        System.out.println("\t" + super.getLabel() + " :: Recibe mensaje: " + msg);
    }
}
