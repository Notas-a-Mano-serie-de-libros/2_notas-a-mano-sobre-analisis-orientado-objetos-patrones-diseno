package com.corozco.libro.patrones.creacional.abstract_factory.dominio.implementacion;

import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadTierra;

public class Fusilero implements UnidadTierra {

    @Override
    public void atacar() {
        System.out.println("\tFusilero: Dispara hasta agotar el cargador");
    }

    @Override
    public void defender() {
        System.out.println("\tFusilero: Retrocede a la trinchera");
    }
}
