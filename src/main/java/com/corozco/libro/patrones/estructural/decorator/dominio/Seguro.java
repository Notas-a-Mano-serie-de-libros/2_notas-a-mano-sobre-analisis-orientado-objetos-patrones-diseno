package com.corozco.libro.patrones.estructural.decorator.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Seguro {

    private String descripcion;
    private double valor;
    private boolean vitalicio;
}
