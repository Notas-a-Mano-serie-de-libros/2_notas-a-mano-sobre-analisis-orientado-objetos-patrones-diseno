package com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion;

import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.IAlgoritmoOrdenamiento;

import java.util.Arrays;

public class OrdenamientoInsercion implements IAlgoritmoOrdenamiento {

    public void ordenar(final Integer[] arr) {

        System.out.println("Estas ordenando con el metodo de insercion");

        System.out.println("\tArreglo original: " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            final int valor = arr[i];
            int posicion = i - 1;
            while (posicion >= 0 && arr[posicion] > valor) {
                arr[posicion + 1] = arr[posicion];
                posicion--;
            }
            arr[posicion + 1] = valor;
        }
        System.out.println("\tArreglo ordenado: " + Arrays.toString(arr));
    }
}
