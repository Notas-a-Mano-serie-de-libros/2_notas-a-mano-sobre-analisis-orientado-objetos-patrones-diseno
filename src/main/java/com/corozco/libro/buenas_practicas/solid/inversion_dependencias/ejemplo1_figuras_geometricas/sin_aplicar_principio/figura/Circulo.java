package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circulo {

    private double radio;

    public double getArea() {
        return Math.PI * this.radio * this.radio;
    }
}
