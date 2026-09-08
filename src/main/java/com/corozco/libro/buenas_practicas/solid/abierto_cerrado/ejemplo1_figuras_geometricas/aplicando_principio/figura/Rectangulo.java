package com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangulo extends Figura {

    private double base;
    private double altura;

    @Override
    public double getArea() {
        return this.base * this.altura;
    }
}
