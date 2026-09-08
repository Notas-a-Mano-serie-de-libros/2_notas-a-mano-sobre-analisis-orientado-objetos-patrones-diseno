package com.corozco.libro.patrones.comportamiento.visitor.visitante.concreto;

import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaBlack;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaGold;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaPlatino;
import com.corozco.libro.patrones.comportamiento.visitor.visitante.IVisitante;

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
