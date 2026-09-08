package com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion;

import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.IAlgoritmoOrdenamiento;

import java.util.Arrays;

public class OrdenamientoBurbuja implements IAlgoritmoOrdenamiento {

    public <T> void ordenar(final T[] arr) {

        System.out.println("Estas ordenando con el metodo de burbuja");

        System.out.println("\tArreglo original: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("\tArreglo ordenado: " + Arrays.toString(arr));
    }
}
