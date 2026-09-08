package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.sin_aplicar_principio;

public class Cliente {

    public static void main(String[] args) {
        System.out.println("----------------Rectángulo----------------");
        Figura rectangulo = new Figura(10, 12);
        System.out.println("Perimetro: " + rectangulo.getPerimetro());
        System.out.println("Suma ángulos: " + rectangulo.getSumaAngulos());
        System.out.println("Diagonal: " + rectangulo.getDiagonal());

        System.out.println("----------------Círculo----------------");
        Figura circulo = new Figura(10);
        System.out.println("Perimetro: " + circulo.getPerimetro());
        System.out.println("Diagonal: " + circulo.getDiagonal());
        System.out.println("Suma ángulos: " + circulo.getSumaAngulos());
    }
}
