package capitulo7.mediator.colega.concreto;

import capitulo7.mediator.colega.Colega;
import capitulo7.mediator.mediador.Mediador;
import capitulo7.mediator.modelo.Usuario;

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
