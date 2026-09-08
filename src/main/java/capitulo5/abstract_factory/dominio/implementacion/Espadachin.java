package capitulo5.abstract_factory.dominio.implementacion;

import capitulo5.abstract_factory.dominio.UnidadTierra;

public class Espadachin implements UnidadTierra {

    @Override
    public void atacar() {
        System.out.println("\tEspadachin: Desenvaina la espada y ataca");
    }

    @Override
    public void defender() {
        System.out.println("\tEspadachin: Usa la espada para bloquear");
    }
}
