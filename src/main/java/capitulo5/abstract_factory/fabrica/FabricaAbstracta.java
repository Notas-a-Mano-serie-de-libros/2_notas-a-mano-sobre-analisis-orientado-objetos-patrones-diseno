package capitulo5.abstract_factory.fabrica;

import capitulo5.abstract_factory.dominio.UnidadNaval;
import capitulo5.abstract_factory.dominio.UnidadTierra;

public interface FabricaAbstracta {

    UnidadTierra crearUnidadTierra();

    UnidadNaval crearUnidadNaval();
}
