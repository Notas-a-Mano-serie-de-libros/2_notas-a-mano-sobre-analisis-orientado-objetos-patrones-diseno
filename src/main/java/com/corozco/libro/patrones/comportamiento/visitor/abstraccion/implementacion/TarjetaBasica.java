package com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion;

import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.Tarjeta;
import com.corozco.libro.patrones.comportamiento.visitor.visitante.IVisitante;

public class TarjetaBasica extends Tarjeta {

    @Override
    public void operacionLegada1() {
        System.out.println("\tSoy la primera operacion para TarjetaBasica");
    }

    @Override
    public void operacionLegada2() {
        System.out.println("\tSoy la segunda operacion para TarjetaBasica");
    }

    @Override
    public void operacionLegada3() {
        System.out.println("\tSoy la tercera operacion para TarjetaBasica");
    }

    @Override
    public void operacionLegada4() {
        System.out.println("\tSoy la cuarta operacion para TarjetaBasica");
    }

    @Override
    public void operacionLegadaN() {
        System.out.println("\tSoy la operacionN para TarjetaBasica");
    }

    @Override
    public void comprar(final IVisitante cuotaManejo, final IVisitante millas, final double monto) {
        this.setUltimoPago(monto);
        this.setTotalPagos(this.getTotalPagos() + monto);
    }
}
