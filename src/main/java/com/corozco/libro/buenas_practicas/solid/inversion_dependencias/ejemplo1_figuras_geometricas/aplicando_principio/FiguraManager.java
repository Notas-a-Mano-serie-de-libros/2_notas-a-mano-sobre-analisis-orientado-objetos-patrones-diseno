package com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio;

import com.corozco.libro.buenas_practicas.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura;

import java.util.ArrayList;
import java.util.List;

public class FiguraManager {

    private final List<Figura> figuras = new ArrayList<>();

    public void agregarFiguras(List<Figura> figuras) {
        this.figuras.addAll(figuras);
    }

    public double getTotalAreas() {
        return figuras.stream().mapToDouble(Figura::getArea).sum();
    }
}
