package com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion;

import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.IAlgoritmoOrdenamiento;

import java.util.Arrays;

public class OrdenamientoBurbuja implements IAlgoritmoOrdenamiento {

    public void ordenar(final Integer[] arr) {

        System.out.println("Estas ordenando con el metodo de burbuja");

        System.out.println("\tArreglo original: " + Arrays.toString(arr));
        for (int limite = arr.length - 1; limite > 0; limite--) {
            boolean huboIntercambio = false;
            for (int i = 0; i < limite; i++) {
                if (arr[i] > arr[i + 1]) {
                    final int temporal = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temporal;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break;
            }
        }
        System.out.println("\tArreglo ordenado: " + Arrays.toString(arr));
    }
}
