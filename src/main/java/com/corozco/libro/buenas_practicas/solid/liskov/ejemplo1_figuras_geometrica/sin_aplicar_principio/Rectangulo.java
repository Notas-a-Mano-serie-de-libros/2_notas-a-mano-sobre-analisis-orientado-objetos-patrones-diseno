package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo1_figuras_geometrica.sin_aplicar_principio;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rectangulo {

    private double base;
    private double altura;

    public double getArea() {
        return this.base * this.altura;
    }
}
