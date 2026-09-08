package capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.figuras_concretas;

import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;

public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        super(2);
        this.radio = radio;
    }

    @Override
    public double getLongitud() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double getArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double getVolumen() {
        throw new UnsupportedOperationException();
    }

}
