package com.corozco.libro.buenas_practicas.grasp.polimorfismo.ejemplo.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circulo implements Figura {

    private double radio;

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
