package com.corozco.libro.patrones.creacional.abstract_factory.fabrica.concreto;

import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadNaval;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadTierra;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.implementacion.BuqueVapor;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.implementacion.Fusilero;
import com.corozco.libro.patrones.creacional.abstract_factory.fabrica.FabricaAbstracta;

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
