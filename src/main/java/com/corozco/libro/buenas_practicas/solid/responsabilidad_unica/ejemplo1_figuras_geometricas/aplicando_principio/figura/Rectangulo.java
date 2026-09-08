package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangulo implements Poligono {

    private double base;
    private double altura;

    public double getPerimetro() {
        return 2 * (base + altura);
    }

    public double getSumaAngulos() {
        return 360;
    }

    public double getDiagonal() {
        return Math.sqrt(base * base + altura * altura);
    }
}
