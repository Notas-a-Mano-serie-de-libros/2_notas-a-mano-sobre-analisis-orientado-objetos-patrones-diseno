package capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio;

import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Circulo;
import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;
import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Rectangulo;

public class UtilidadArea {

    public double getArea(Figura figura) {
        if (figura instanceof Rectangulo) {
            Rectangulo rectangulo = (Rectangulo) figura;
            return rectangulo.getBase() * rectangulo.getAltura();
        } else if (figura instanceof Circulo) {
            Circulo circulo = (Circulo) figura;
            return Math.PI * circulo.getRadio() * circulo.getRadio();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
