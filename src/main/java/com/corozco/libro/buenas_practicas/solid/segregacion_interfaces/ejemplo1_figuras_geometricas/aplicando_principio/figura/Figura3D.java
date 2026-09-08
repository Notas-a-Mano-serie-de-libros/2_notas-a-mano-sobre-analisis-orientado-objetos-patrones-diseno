package com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura;

import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.propiedades.Propiedades1D;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.propiedades.Propiedades2D;
import com.corozco.libro.buenas_practicas.solid.segregacion_interfaces.ejemplo1_figuras_geometricas.aplicando_principio.figura.propiedades.Propiedades3D;
import lombok.Getter;

@Getter
public abstract class Figura3D implements Propiedades1D, Propiedades2D, Propiedades3D {

    private final double dimension;

    public Figura3D() {
        this.dimension = 3;
    }
}
