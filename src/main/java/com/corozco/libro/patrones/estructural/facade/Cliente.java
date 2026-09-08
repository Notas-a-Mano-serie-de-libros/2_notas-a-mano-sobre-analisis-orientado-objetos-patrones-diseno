package com.corozco.libro.patrones.estructural.facade;

import com.corozco.libro.patrones.estructural.facade.abstraccion.IValidador;
import com.corozco.libro.patrones.estructural.facade.abstraccion.ValidadorDespliegue;

public class Cliente {
    public static void main(String[] args) {
        IValidador validador = new ValidadorDespliegue();
        validador.validar();
    }
}
