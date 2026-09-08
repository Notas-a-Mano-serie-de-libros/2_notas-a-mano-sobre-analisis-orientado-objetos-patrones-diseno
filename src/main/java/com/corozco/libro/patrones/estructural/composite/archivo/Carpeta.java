package com.corozco.libro.patrones.estructural.composite.archivo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Carpeta implements Archivo {

    private String nombre;
    private List<Archivo> subCarpetas = new ArrayList<>();

    public Carpeta(final String nombre) {
        this.nombre = nombre + "/";
    }

    public void add(final Archivo dir) {
        subCarpetas.add(dir);
    }

    @Override
    public String info(int nivel) {
        StringBuilder info = new StringBuilder("\t".repeat(nivel) + nombre);
        for (Archivo archivo : subCarpetas) {
            info.append("\n").append(archivo.info(nivel + 1));
        }
        return info.toString();
    }
}
