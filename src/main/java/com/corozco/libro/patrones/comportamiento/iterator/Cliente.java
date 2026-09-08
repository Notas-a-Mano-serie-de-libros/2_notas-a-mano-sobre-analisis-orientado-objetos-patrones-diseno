package com.corozco.libro.patrones.comportamiento.iterator;

import com.corozco.libro.patrones.comportamiento.iterator.iterador_arreglo.IterableArreglo;
import com.corozco.libro.patrones.comportamiento.iterator.iterador_persona.IterablePersona;
import com.corozco.libro.patrones.comportamiento.iterator.modelo.Persona;
import com.corozco.libro.patrones.comportamiento.iterator.modelo.Producto;

public class Cliente {
    public static void main(String[] args) {

        final Integer[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final String[] nombres = {"Carlos", "Isabel", "Jesús"};
        final Producto[] productos = {new Producto(1, "P001")};

        final Iterador iteradorNumeros = new IterableArreglo<>(numeros)
                .iterador();
        final Iterador iteradorNombres = new IterableArreglo<>(nombres)
                .iterador();
        final Iterador iteradorProductos = new IterableArreglo<>(productos)
                .iterador();

        System.out.print("Arreglo de números: ");
        iterar(iteradorNumeros);
        System.out.print("Arreglo de nombres: ");
        iterar(iteradorNombres);
        System.out.print("Arreglo de productos: ");
        iterar(iteradorProductos);

        final Persona persona1 = Persona.builder()
                .nombre("Julián Perez Fernández").nombrePadre("Camilo Perez")
                .nombreMadre("Andrea Fernández").build();

        final Persona persona2 = Persona.builder()
                .nombre("Andres López Ramírez").nombrePadre("Julián López")
                .nombreMadre("Claudia Ramírez")
                .nombreHermanos("Ana, Sofía").build();

        System.out.println("Iterador de persona 1");
        final Iterador iteradorPersona1 = new IterablePersona(persona1)
                .iterador();
        iterar(iteradorPersona1);

        System.out.println("Iterador de persona 2");
        final Iterador iteradorPersona2 = new IterablePersona(persona2)
                .iterador();
        iterar(iteradorPersona2);
    }

    private static void iterar(final Iterador iterador) {
        while (iterador.hasNext()) {
            System.out.print(iterador.actual() + " ");
            iterador.siguiente();
        }
        System.out.println();
    }
}
