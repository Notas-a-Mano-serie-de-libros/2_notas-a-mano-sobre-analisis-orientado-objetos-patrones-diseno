package com.corozco.libro.patrones.creacional.abstract_factory.dominio.implementacion;

import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadNaval;

public class BuqueVapor implements UnidadNaval {

    @Override
    public void navegar() {
        System.out.println("\tBuque vapor: Accionar turbinas");
    }

    @Override
    public void atacar() {
        System.out.println("\tBuque vapor: Dispara municion");
    }
}
