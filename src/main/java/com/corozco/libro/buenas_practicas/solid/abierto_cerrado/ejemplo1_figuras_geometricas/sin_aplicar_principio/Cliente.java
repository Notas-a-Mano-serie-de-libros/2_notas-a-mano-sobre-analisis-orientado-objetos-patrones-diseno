package com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Circulo;
import com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;
import com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Rectangulo;

public class Cliente {

    public static void main(String[] args) {
        UtilidadArea utilidad = new UtilidadArea();
        Figura rectangulo = new Rectangulo(5, 2);
        Figura circulo = new Circulo(12);

        System.out.println("Área del rectángulo: " + utilidad.getArea(rectangulo));
        System.out.println("Área del círculo: " + utilidad.getArea(circulo));
    }
}
