package capitulo3.solid.inversion_dependencias.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cuadrado extends Figura {

    private double lado;

    @Override
    public double getArea() {
        return this.lado * this.lado;
    }
}
