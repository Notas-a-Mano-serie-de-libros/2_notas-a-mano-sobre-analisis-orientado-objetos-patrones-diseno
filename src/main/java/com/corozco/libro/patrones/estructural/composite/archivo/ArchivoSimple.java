package com.corozco.libro.patrones.estructural.composite.archivo;

import lombok.Data;

@Data
public class ArchivoSimple implements Archivo {

    private String nombre;
    private String extension;

    public ArchivoSimple(final String nombre, final String extension) {
        this.nombre = nombre;
        this.extension = extension;
    }

    @Override
    public String info(int nivel) {
        return "\t".repeat(nivel) + this.nombre + "." + this.extension;
    }
}
