package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo1_figuras_geometrica.sin_aplicar_principio;

public class Cliente {

    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(5, 4);
        Rectangulo cuadrado = new Cuadrado(12); // Área esperada: 144
        cuadrado.setAltura(10); // Modifica uno de los lados

        System.out.println("Área del rectangulo: " + rectangulo.getArea());
        System.out.println("Área del cuadrado: " + cuadrado.getArea());
    }
}