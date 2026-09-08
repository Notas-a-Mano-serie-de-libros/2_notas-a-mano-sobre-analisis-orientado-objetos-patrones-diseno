package com.corozco.libro.patrones.comportamiento.mediator.modelo;

import lombok.Data;

@Data
public class Vuelo extends General {

    private String referencia;

    public Vuelo(final String id, final String referencia) {
        super(id);
        this.referencia = referencia;
    }
}
