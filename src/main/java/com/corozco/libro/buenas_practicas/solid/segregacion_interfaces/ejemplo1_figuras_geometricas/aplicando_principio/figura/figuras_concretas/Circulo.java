package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura2D;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circulo extends Figura2D {

    private double radio;

    @Override
    public double getLongitud() {
        return 2 * Math.PI * this.radio;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }
}
