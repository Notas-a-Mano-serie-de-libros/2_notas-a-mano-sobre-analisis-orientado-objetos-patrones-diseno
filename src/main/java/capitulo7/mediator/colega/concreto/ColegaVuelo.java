package capitulo7.mediator.colega.concreto;

import capitulo7.mediator.colega.Colega;
import capitulo7.mediator.mediador.Mediador;
import capitulo7.mediator.modelo.Vuelo;

public class ColegaVuelo extends Colega<Vuelo> {

    public ColegaVuelo(final Mediador<Vuelo> mediador, final Vuelo colega, final String label) {
        super(mediador, colega, label);
    }

    @Override
    public void enviarMensaje(final String msg, final String id) {
        super.getMediador().enviarMensaje(msg, id);
    }

    @Override
    public void recibirMensaje(final String msg) {
        System.out.println("\t" + super.getLabel() + " :: Notificacion desde torre de control: " + msg);
    }
}
