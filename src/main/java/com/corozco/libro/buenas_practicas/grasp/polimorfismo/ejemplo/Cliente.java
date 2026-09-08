package com.corozco.libro.buenas_practicas.grasp.polimorfismo.ejemplo;

import com.corozco.libro.buenas_practicas.grasp.polimorfismo.ejemplo.figura.Circulo;
import com.corozco.libro.buenas_practicas.grasp.polimorfismo.ejemplo.figura.Cuadrado;
import com.corozco.libro.buenas_practicas.grasp.polimorfismo.ejemplo.figura.Figura;

public class Cliente {

    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(5);
        Figura circulo = new Circulo(3);

        System.out.println("Área del cuadrado: " + cuadrado.calcularArea());
        System.out.println("Área del círculo: " + circulo.calcularArea());
    }
}
