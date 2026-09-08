package com.corozco.libro.patrones.creacional.builder.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Galaxia extends General {

    private float masa;
    private String tipo;
    private String grupo;

    public Galaxia(final int id, final String codigo) {
        super(id, codigo);
    }
}
