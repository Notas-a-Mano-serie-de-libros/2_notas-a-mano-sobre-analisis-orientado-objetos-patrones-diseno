package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura1D;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura2D;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.Figura3D;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas.Circulo;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas.Circunferencia;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.figuras_concretas.Esfera;

public class Cliente {

    public static void main(String[] args) {
        System.out.println("-------------Esfera (3D)-------------");
        Figura3D esfera = new Esfera(12);
        System.out.println("Longitud: " + esfera.getLongitud());
        System.out.println("Área: " + esfera.getArea());
        System.out.println("Volumen: " + esfera.getVolumen());
        System.out.println("Dimensión: " + esfera.getDimension());

        System.out.println("-------------Circulo (2D)-------------");
        Figura2D circulo = new Circulo(12);
        System.out.println("Longitud: " + circulo.getLongitud());
        System.out.println("Área: " + circulo.getArea());
        System.out.println("Dimensión: " + circulo.getDimension());

        System.out.println("-------------Circunferencia (1D)-------------");
        Figura1D circunferencia = new Circunferencia(12);
        System.out.println("Longitud: " + circunferencia.getLongitud());
        System.out.println("Dimensión: " + circunferencia.getDimension());
    }
}
