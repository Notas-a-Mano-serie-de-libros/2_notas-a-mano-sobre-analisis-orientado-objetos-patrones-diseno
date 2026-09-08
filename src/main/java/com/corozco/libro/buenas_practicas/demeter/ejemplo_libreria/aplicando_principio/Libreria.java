package com.corozco.libro.buenas_practicas.demeter.ejemplo_libreria.aplicando_principio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Libreria {

    private final List<Libro> libros = new ArrayList<>();

    public Libreria() {
        libros.addAll(
                Arrays.asList(
                        new Libro(1, "Libro 1", 241, new Autor("C. Orozco")),
                        new Libro(2, "Libro 2", 432, new Autor("L. Fernandez"))
                )
        );
    }

    public void consultarAutorLibro(int id) throws Exception {
        this.getLibro(id).consultarInformacionAutor();
    }

    private Libro getLibro(int id) throws Exception {
        return libros.stream()
                .filter(current -> current.getId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("El libro no está presente."));
    }
}
