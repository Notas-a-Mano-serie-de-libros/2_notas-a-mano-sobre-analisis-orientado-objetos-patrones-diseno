package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo1_figuras_geometrica.aplicando_principio;

public class Cliente {

    public static void main(String[] args) {
        Rectangulo cuadrado2 = new Cuadrado(12); // Área esperada: 144
        // cuadrado2.setBase(10); Descomentar esta linea causa un error
        System.out.println("Área del cuadrado 2: " + cuadrado2.getArea());
    }
}