package capitulo6.facade;

import capitulo6.facade.abstraccion.IValidador;
import capitulo6.facade.abstraccion.ValidadorDespliegue;

public class Cliente {
    public static void main(String[] args) {
        IValidador validador = new ValidadorDespliegue();
        validador.validar();
    }
}
