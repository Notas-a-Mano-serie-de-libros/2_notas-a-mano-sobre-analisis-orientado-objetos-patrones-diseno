package com.corozco.libro.patrones.creacional.abstract_factory.fabrica;

import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadNaval;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadTierra;

public interface FabricaAbstracta {

    UnidadTierra crearUnidadTierra();

    UnidadNaval crearUnidadNaval();
}
