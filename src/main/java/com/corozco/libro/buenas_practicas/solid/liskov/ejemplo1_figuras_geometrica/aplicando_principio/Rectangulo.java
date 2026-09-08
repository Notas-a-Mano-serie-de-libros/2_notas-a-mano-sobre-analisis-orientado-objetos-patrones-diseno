package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo1_figuras_geometrica.aplicando_principio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rectangulo {

    private double base;
    private double altura;

    public double getArea() {
        return this.base * this.altura;
    }
}
