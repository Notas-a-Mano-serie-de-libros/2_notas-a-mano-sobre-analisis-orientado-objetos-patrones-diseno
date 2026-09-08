package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;

public class Circunferencia extends Figura {

    private double radio;

    public Circunferencia(double radio) {
        super(1);
        this.radio = radio;
    }

    @Override
    public double getLongitud() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double getArea() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getVolumen() {
        throw new UnsupportedOperationException();
    }

}
