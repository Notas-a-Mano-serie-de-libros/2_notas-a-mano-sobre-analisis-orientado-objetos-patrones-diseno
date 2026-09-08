package com.corozco.libro.buenas_practicas.demeter.ejemplo_libreria.sin_aplicar_principio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
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
}
