package capitulo7.visitor.visitante.concreto;

import capitulo7.visitor.abstraccion.implementacion.TarjetaBlack;
import capitulo7.visitor.abstraccion.implementacion.TarjetaGold;
import capitulo7.visitor.abstraccion.implementacion.TarjetaPlatino;
import capitulo7.visitor.visitante.IVisitante;

public class VisitanteCoutaManejo implements IVisitante {

    @Override
    public void visitar(final TarjetaGold tarjeta) {
        double cuota = Math.round(0.01 * tarjeta.getUltimoPago());
        tarjeta.setInteresAcumulado(tarjeta.getInteresAcumulado() + cuota);
    }

    @Override
    public void visitar(final TarjetaPlatino tarjeta) {
        double cuota = Math.round(0.015 * tarjeta.getUltimoPago());
        tarjeta.setInteresAcumulado(tarjeta.getInteresAcumulado() + cuota);
    }

    @Override
    public void visitar(final TarjetaBlack tarjeta) {
        double cuota = Math.round(0.021 * tarjeta.getUltimoPago());
        tarjeta.setInteresAcumulado(tarjeta.getInteresAcumulado() + cuota);
    }
}
