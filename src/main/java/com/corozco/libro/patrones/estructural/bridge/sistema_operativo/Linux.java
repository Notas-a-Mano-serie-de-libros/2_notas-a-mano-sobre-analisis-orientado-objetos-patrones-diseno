package com.corozco.libro.patrones.estructural.bridge.sistema_operativo;

import com.corozco.libro.patrones.estructural.bridge.arquitectura.Arquitectura;

public class Linux extends SistemaOperativo {

    public Linux(final String nombre, final String version, final Arquitectura arquitectura) {
        super(nombre, version, arquitectura);
    }
}
