package capitulo5.abstract_factory.fabrica.concreto;

import capitulo5.abstract_factory.dominio.UnidadNaval;
import capitulo5.abstract_factory.dominio.UnidadTierra;
import capitulo5.abstract_factory.dominio.implementacion.BuqueVapor;
import capitulo5.abstract_factory.dominio.implementacion.Fusilero;
import capitulo5.abstract_factory.fabrica.FabricaAbstracta;

public class FabricaEraIndustrial implements FabricaAbstracta {

    @Override
    public UnidadTierra crearUnidadTierra() {
        return new Fusilero();
    }

    @Override
    public UnidadNaval crearUnidadNaval() {
        return new BuqueVapor();
    }
}
