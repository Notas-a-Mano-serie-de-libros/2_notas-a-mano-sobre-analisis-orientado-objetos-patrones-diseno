package capitulo5.abstract_factory.fabrica.concreto;

import capitulo5.abstract_factory.dominio.UnidadNaval;
import capitulo5.abstract_factory.dominio.UnidadTierra;
import capitulo5.abstract_factory.dominio.implementacion.Espadachin;
import capitulo5.abstract_factory.dominio.implementacion.Galeon;
import capitulo5.abstract_factory.fabrica.FabricaAbstracta;

public class FabricaEraMedieval implements FabricaAbstracta {

    @Override
    public UnidadTierra crearUnidadTierra() {
        return new Espadachin();
    }

    @Override
    public UnidadNaval crearUnidadNaval() {
        return new Galeon();
    }
}
