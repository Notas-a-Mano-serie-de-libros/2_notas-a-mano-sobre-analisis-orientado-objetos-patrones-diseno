package capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio;

import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Circulo;
import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Figura;
import capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura.Rectangulo;

public class Cliente {

    public static void main(String[] args) {
        UtilidadArea utilidad = new UtilidadArea();
        Figura rectangulo = new Rectangulo(5, 2);
        Figura circulo = new Circulo(12);

        System.out.println("Área del rectángulo: " + utilidad.getArea(rectangulo));
        System.out.println("Área del círculo: " + utilidad.getArea(circulo));
    }
}
