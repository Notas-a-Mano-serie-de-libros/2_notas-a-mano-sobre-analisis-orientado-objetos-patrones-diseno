package com.corozco.libro.patrones.creacional.abstract_factory.fabrica.concreto;

import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadNaval;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadTierra;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.implementacion.Espadachin;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.implementacion.Galeon;
import com.corozco.libro.patrones.creacional.abstract_factory.fabrica.FabricaAbstracta;

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
