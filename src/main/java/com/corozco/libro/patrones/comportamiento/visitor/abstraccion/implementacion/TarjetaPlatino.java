package com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion;

import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.IVisitable;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.Tarjeta;
import com.corozco.libro.patrones.comportamiento.visitor.visitante.IVisitante;

public class TarjetaPlatino extends Tarjeta implements IVisitable {

    @Override
    public void operacionLegada1() {
        System.out.println("\tSoy la primera operacion para TarjetaPlatino");
    }

    @Override
    public void operacionLegada2() {
        System.out.println("\tSoy la segunda operacion para TarjetaPlatino");
    }

    @Override
    public void operacionLegada3() {
        System.out.println("\tSoy la tercera operacion para TarjetaPlatino");
    }

    @Override
    public void operacionLegada4() {
        System.out.println("\tSoy la cuarta operacion para TarjetaPlatino");
    }

    @Override
    public void operacionLegadaN() {
        System.out.println("\tSoy una operacion de otras tantas TarjetaPlatino");
    }

    @Override
    public void comprar(final IVisitante cuotaManejo, final IVisitante millas, final double monto) {
        this.setUltimoPago(monto);
        this.setTotalPagos(this.getTotalPagos() + monto);
        aceptarVisitante(cuotaManejo);
        aceptarVisitante(millas);
    }

    @Override
    public void aceptarVisitante(final IVisitante visitante) {
        visitante.visitar(this);
    }
}
