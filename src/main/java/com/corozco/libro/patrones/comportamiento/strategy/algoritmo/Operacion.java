package com.corozco.libro.patrones.comportamiento.strategy.algoritmo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Operacion {

    private final IAlgoritmoOrdenamiento algoritmo;

    public <T> void ordenar(final T[] arr) {
        algoritmo.ordenar(arr);
    }
}
