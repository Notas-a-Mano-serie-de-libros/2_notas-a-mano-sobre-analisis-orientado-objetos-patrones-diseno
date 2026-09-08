package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura1D;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circunferencia extends Figura1D {

    private double radio;

    @Override
    public double getLongitud() {
        return 2 * Math.PI * this.radio;
    }
}
