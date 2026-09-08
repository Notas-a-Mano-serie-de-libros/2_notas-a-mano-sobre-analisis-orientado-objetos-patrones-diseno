package capitulo5.abstract_factory.dominio.implementacion;

import capitulo5.abstract_factory.dominio.UnidadNaval;

public class Galeon implements UnidadNaval {

    @Override
    public void navegar() {
        System.out.println("\tGaleon: Desplegar vela");
    }

    @Override
    public void atacar() {
        System.out.println("\tGaleon: Dispara lombardas");
    }
}
