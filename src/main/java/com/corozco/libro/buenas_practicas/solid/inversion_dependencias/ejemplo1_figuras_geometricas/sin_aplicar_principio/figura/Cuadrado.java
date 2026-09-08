package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cuadrado {

    private double lado;

    public double getArea() {
        return this.lado * this.lado;
    }
}
