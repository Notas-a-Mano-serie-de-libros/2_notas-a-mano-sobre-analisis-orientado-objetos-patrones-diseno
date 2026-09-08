package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;

public class Esfera extends Figura {

    private double radio;

    public Esfera(double radio) {
        super(3);
        this.radio = radio;
    }

    @Override
    public double getLongitud() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double getVolumen() {
        return ((double) 4 / 3) * Math.PI * radio * radio * radio;
    }


}
