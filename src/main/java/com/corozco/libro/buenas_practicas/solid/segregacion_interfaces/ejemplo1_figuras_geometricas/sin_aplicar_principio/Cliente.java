package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas.Circulo;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas.Circunferencia;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas.Esfera;

public class Cliente {

    public static void main(String[] args) {
        System.out.println("-------------Esfera (3D)-------------");
        Figura esfera = new Esfera(12);
        System.out.println("Longitud:" + esfera.getLongitud());
        System.out.println("Área:" + esfera.getArea());
        System.out.println("Volumen:" + esfera.getVolumen());

        System.out.println("-------------Circulo (2D)-------------");
        Figura circulo = new Circulo(12);
        System.out.println("Longitud:" + circulo.getLongitud());
        System.out.println("Área:" + circulo.getArea());
        System.out.println("Volumen:" + circulo.getVolumen());

        System.out.println("-------------Circunferencia (1D)-------------");
        Figura circunferencia = new Circunferencia(12);
        System.out.println("Longitud:" + circunferencia.getLongitud());
        System.out.println("Área:" + circunferencia.getArea());
        System.out.println("Volumen:" + circunferencia.getVolumen());
    }
}
