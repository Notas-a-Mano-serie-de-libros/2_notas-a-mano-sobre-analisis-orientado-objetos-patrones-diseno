package com.corozco.libro.patrones.estructural.bridge.sistema_operativo;

import com.corozco.libro.patrones.estructural.bridge.arquitectura.Arquitectura;

public class Windows extends SistemaOperativo {

    public Windows(final String nombre, final String version, final Arquitectura arquitectura) {
        super(nombre, version, arquitectura);
    }
}
