package capitulo6.decorator.decorador.decorador_concreto;

import capitulo6.decorator.decorador.SeguroDecorador;
import capitulo6.decorator.dominio.Seguro;

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
