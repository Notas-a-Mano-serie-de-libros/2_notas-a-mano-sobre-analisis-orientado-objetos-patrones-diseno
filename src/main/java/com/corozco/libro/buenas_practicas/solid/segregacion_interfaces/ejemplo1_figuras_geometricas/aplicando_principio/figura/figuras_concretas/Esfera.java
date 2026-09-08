package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura3D;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Esfera extends Figura3D {

    private double radio;

    @Override
    public double getLongitud() {
        return 2 * Math.PI * this.radio;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public double getVolumen() {
        return ((double) 4 / 3) * Math.PI * Math.pow(this.radio, 3);
    }
}
