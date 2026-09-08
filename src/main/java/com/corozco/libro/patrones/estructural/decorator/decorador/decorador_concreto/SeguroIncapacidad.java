package com.corozco.libro.patrones.estructural.decorator.decorador.decorador_concreto;

import com.corozco.libro.patrones.estructural.decorator.decorador.SeguroDecorador;
import com.corozco.libro.patrones.estructural.decorator.dominio.Seguro;

public class SeguroIncapacidad extends SeguroDecorador {

    public SeguroIncapacidad(final Seguro seguro) {
        super(seguro);
    }

    @Override
    public double getValor() {
        return Math.round(1.5 * super.getSeguro().getValor());
    }
}
