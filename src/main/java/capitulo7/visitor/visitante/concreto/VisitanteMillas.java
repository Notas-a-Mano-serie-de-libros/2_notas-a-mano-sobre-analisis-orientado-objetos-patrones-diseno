package capitulo7.visitor.visitante.concreto;

import capitulo7.visitor.abstraccion.implementacion.TarjetaBlack;
import capitulo7.visitor.abstraccion.implementacion.TarjetaGold;
import capitulo7.visitor.abstraccion.implementacion.TarjetaPlatino;
import capitulo7.visitor.visitante.IVisitante;

public class VisitanteMillas implements IVisitante {

    @Override
    public void visitar(final TarjetaGold tarjeta) {
        // Método vacio
    }

    @Override
    public void visitar(final TarjetaPlatino tarjeta) {
        tarjeta.setMillasAcumuladas(tarjeta.getMillasAcumuladas() + 10);
    }

    @Override
    public void visitar(final TarjetaBlack tarjeta) {
        tarjeta.setMillasAcumuladas(tarjeta.getMillasAcumuladas() + 100);
    }
}
