package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo1_figuras_geometricas.sin_aplicar_principio;

public class Figura {

    private final TipoFigura tipo;
    private double base;
    private double altura;
    private double radio;

    public Figura(double base, double altura) {
        this.tipo = TipoFigura.RECTANGULO;
        this.base = base;
        this.altura = altura;
    }

    public Figura(double radio) {
        this.tipo = TipoFigura.CIRCULO;
        this.radio = radio;
    }

    public double getPerimetro() {
        switch (tipo) {
            case CIRCULO:
                return 2 * Math.PI * radio;
            case RECTANGULO:
                return 2 * (base + altura);
            default:
                throw new UnsupportedOperationException();
        }
    }

    public double getSumaAngulos() {
        switch (tipo) {
            case RECTANGULO:
                return 360;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public double getDiagonal() {
        switch (tipo) {
            case RECTANGULO:
                return Math.sqrt(base * base + altura * altura);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
