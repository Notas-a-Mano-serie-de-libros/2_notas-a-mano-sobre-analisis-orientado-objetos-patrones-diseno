package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio;

import com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Circulo;
import com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura;
import com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Poligono;
import com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.aplicando_principio.figura.Rectangulo;

public class Cliente {

    public static void main(String[] args) {
        System.out.println("----------------Rectángulo----------------");
        Poligono rectangulo = new Rectangulo(12, 10);
        System.out.println("Perimetro: " + rectangulo.getPerimetro());
        System.out.println("Suma ángulos: " + rectangulo.getSumaAngulos());
        System.out.println("Diagonal: " + rectangulo.getDiagonal());

        System.out.println("----------------Círculo----------------");
        Figura circulo = new Circulo(12);
        System.out.println("Perimetro: " + circulo.getPerimetro());
    }
}
