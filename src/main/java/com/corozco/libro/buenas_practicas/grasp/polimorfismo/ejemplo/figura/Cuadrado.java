package com.corozco.libro.buenas_practicas.grasp.polimorfismo.ejemplo.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cuadrado implements Figura {

    private double lado;

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
