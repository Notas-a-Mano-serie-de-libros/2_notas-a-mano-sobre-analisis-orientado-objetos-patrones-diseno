package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo1_figuras_geometrica.sin_aplicar_principio;

public class Cuadrado extends Rectangulo {

    public Cuadrado(double lado) {
        super(lado, lado);
    }

    public double getLado() {
        return super.getBase();
    }
}
