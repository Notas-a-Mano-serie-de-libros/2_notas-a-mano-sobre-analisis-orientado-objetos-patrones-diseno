package com.corozco.libro.buenas_practicas.demeter.ejemplo_libreria.aplicando_principio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Libro {
    private int id;
    private String nombre;
    private int numeroPaginas;
    private Autor autor;

    public void consultarInformacionAutor() {
        System.out.println("Autor del libro: " + autor.getNombre());
    }

}
