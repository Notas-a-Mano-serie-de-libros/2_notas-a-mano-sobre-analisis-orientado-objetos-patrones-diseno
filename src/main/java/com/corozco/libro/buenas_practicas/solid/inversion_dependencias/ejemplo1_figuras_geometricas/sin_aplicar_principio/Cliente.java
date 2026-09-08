package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Circulo;
import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Cuadrado;

import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        FiguraManager manager = new FiguraManager();
        manager.agregarCirculos(List.of(new Circulo(2)));
        manager.agregarCuadrados(List.of(new Cuadrado(2)));

        System.out.println("Total área figuras: " + manager.getTotalAreas());
    }
}
