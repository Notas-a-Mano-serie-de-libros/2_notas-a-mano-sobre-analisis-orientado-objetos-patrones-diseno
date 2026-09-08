package com.corozco.libro.patrones.creacional.abstract_factory.dominio.implementacion;

import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadTierra;

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
