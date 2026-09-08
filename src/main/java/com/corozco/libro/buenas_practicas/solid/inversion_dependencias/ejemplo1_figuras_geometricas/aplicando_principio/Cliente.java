package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio;

import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura.Circulo;
import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura.Cuadrado;
import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura;

import java.util.Arrays;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        FiguraManager manager = new FiguraManager();
        List<Figura> figuras = Arrays.asList(new Circulo(2), new Cuadrado(2));
        manager.agregarFiguras(figuras);
        System.out.println("Total área figuras: " + manager.getTotalAreas());
    }
}
