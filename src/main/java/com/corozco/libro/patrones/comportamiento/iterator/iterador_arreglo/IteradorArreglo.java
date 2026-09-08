package com.corozco.libro.patrones.comportamiento.iterator.iterador_arreglo;

import com.corozco.libro.patrones.comportamiento.iterator.Iterador;
import lombok.Data;

@Data
public class IteradorArreglo<T> implements Iterador {

    private T[] elementos;
    private int indice;

    public IteradorArreglo(final T[] elementos) {
        this.elementos = elementos;
        this.indice = 0;
    }

    @Override
    public void siguiente() {
        indice++;
    }

    @Override
    public String actual() {
        return elementos[indice].toString();
    }

    @Override
    public boolean hasNext() {
        return indice < elementos.length;
    }
}
