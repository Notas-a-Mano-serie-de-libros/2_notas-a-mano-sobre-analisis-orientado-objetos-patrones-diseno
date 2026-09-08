package capitulo6.decorator.decorador.decorador_concreto;

import capitulo6.decorator.decorador.SeguroDecorador;
import capitulo6.decorator.dominio.Seguro;

public class SeguroIncapacidad extends SeguroDecorador {

    public SeguroIncapacidad(final Seguro seguro) {
        super(seguro);
    }

    @Override
    public double getValor() {
        return Math.round(1.5 * super.getSeguro().getValor());
    }
}
