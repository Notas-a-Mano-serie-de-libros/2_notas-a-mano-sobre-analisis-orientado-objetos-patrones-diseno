package capitulo3.grasp.polimorfismo.ejemplo;

import capitulo3.grasp.polimorfismo.ejemplo.figura.Circulo;
import capitulo3.grasp.polimorfismo.ejemplo.figura.Cuadrado;
import capitulo3.grasp.polimorfismo.ejemplo.figura.Figura;

public class Cliente {

    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(5);
        Figura circulo = new Circulo(3);

        System.out.println("Área del cuadrado: " + cuadrado.calcularArea());
        System.out.println("Área del círculo: " + circulo.calcularArea());
    }
}
