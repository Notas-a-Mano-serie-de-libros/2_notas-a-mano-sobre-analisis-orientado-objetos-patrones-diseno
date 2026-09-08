package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.propiedades.Propiedades1D;
import lombok.Getter;

@Getter
public abstract class Figura1D implements Propiedades1D {

    private final int dimension;

    public Figura1D() {
        this.dimension = 1;
    }
}
