package com.corozco.libro.buenas_practicas.demeter.ejemplo_libreria.sin_aplicar_principio;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Libreria libreria = new Libreria();

        Libro libro = libreria.getLibros().stream()
                .filter(current -> current.getId() == 1)
                .findFirst().orElseThrow(() -> new Exception("El libro no está presente."));

        System.out.println("Autor del libro: " + libro.getAutor().getNombre());
    }
}
