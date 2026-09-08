package com.corozco.libro.patrones.estructural.decorator.decorador.decorador_concreto;

import com.corozco.libro.patrones.estructural.decorator.decorador.SeguroDecorador;
import com.corozco.libro.patrones.estructural.decorator.dominio.Seguro;

public class SeguroAccidente extends SeguroDecorador {

    public SeguroAccidente(final Seguro seguro) {
        super(seguro);
    }

    @Override
    public double getValor() {
        return Math.round(1.1 * super.getSeguro().getValor());
    }

    @Override
    public boolean isVitalicio() {
        return true;
    }
}
