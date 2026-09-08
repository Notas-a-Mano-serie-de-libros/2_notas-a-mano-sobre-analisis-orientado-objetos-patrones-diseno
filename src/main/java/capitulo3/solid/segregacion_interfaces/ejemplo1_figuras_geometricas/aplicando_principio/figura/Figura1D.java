package capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import capitulo3.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.propiedades.Propiedades1D;
import lombok.Getter;

@Getter
public abstract class Figura1D implements Propiedades1D {

    private final int dimension;

    public Figura1D() {
        this.dimension = 1;
    }
}
