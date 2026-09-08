package capitulo7.mediator.mediador.concreto;

import capitulo7.mediator.colega.Colega;
import capitulo7.mediator.mediador.Mediador;
import capitulo7.mediator.modelo.Usuario;

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
