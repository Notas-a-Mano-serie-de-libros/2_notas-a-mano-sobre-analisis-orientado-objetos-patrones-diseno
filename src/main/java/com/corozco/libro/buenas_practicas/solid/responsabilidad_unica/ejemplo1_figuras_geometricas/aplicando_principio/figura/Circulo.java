package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circulo implements Figura {

    private double radio;

    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }
}
