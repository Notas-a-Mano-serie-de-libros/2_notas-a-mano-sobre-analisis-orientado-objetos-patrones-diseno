package com.corozco.libro.patrones.comportamiento.iterator.iterador_arreglo;

import com.corozco.libro.patrones.comportamiento.iterator.Iterable;
import com.corozco.libro.patrones.comportamiento.iterator.Iterador;

public class IterableArreglo<T> implements Iterable {

    private final T[] elementos;

    public IterableArreglo(final T[] elementos) {
        this.elementos = elementos;
    }

    @Override
    public Iterador iterador() {
        return new IteradorArreglo<>(elementos);
    }
}