package com.corozco.libro.patrones.comportamiento.visitor.visitante.concreto;

import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaBlack;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaGold;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaPlatino;
import com.corozco.libro.patrones.comportamiento.visitor.visitante.IVisitante;

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
