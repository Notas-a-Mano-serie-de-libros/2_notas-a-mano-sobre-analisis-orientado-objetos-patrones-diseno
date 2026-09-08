package com.corozco.libro.patrones.comportamiento.iterator.iterador_persona;

import com.corozco.libro.patrones.comportamiento.iterator.Iterable;
import com.corozco.libro.patrones.comportamiento.iterator.Iterador;
import com.corozco.libro.patrones.comportamiento.iterator.modelo.Persona;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class IterablePersona implements Iterable {

    private final Persona persona;

    @Override
    public Iterador iterador() {
        return new IteradorPersona(persona);
    }
}