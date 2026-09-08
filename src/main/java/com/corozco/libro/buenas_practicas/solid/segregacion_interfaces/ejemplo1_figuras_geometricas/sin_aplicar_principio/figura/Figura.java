package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura;

import lombok.Getter;

@Getter
public abstract class Figura {

    private double dimension;

    public Figura(int dimension) {
        this.dimension = dimension;
    }

    public abstract double getLongitud();

    public abstract double getArea();

    public abstract double getVolumen();

}
