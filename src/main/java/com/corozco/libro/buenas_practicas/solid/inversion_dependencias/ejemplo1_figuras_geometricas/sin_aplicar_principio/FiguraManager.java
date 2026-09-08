package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Circulo;
import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Cuadrado;

import java.util.ArrayList;
import java.util.List;

public class FiguraManager {

    private final List<Circulo> circulos = new ArrayList<>();
    private final List<Cuadrado> cuadrados = new ArrayList<>();

    public double getTotalAreas() {
        return cuadrados.stream()
                .mapToDouble(Cuadrado::getArea).sum() +
                circulos.stream()
                        .mapToDouble(Circulo::getArea).sum();
    }

    public void agregarCirculos(List<Circulo> circulos) {
        this.circulos.addAll(circulos);
    }

    public void agregarCuadrados(List<Cuadrado> cuadrados) {
        this.cuadrados.addAll(cuadrados);
    }

}
