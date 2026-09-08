package com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circulo extends Figura {

    private double radio;

    @Override
    public double getArea() {
        return Math.PI * this.radio * this.radio;
    }
}
