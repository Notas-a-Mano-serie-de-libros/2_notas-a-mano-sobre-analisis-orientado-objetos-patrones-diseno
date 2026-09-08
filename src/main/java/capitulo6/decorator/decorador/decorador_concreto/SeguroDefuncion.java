package capitulo6.decorator.decorador.decorador_concreto;

import capitulo6.decorator.decorador.SeguroDecorador;
import capitulo6.decorator.dominio.Seguro;

public class SeguroDefuncion extends SeguroDecorador {

    public SeguroDefuncion(final Seguro seguro) {
        super(seguro);
    }

    @Override
    public double getValor() {
        return Math.round(1.7 * super.getSeguro().getValor());
    }
}
