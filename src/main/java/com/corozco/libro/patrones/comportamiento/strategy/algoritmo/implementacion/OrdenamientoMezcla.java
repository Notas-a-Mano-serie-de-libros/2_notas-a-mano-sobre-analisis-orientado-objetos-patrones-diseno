package com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion;

import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.IAlgoritmoOrdenamiento;

import java.util.Arrays;

public class OrdenamientoMezcla implements IAlgoritmoOrdenamiento {

    public void ordenar(final Integer[] arr) {

        System.out.println("Estas ordenando con el metodo merge sort");

        System.out.println("\tArreglo original: " + Arrays.toString(arr));
        ordenar(arr, 0, arr.length);
        System.out.println("\tArreglo ordenado: " + Arrays.toString(arr));
    }

    private void ordenar(final Integer[] arr, final int inicio, final int fin) {
        if (fin - inicio < 2) {
            return;
        }
        final int mitad = (inicio + fin) / 2;
        ordenar(arr, inicio, mitad);
        ordenar(arr, mitad, fin);
        mezclar(arr, inicio, mitad, fin);
    }

    private void mezclar(final Integer[] arr, final int inicio, final int mitad, final int fin) {
        final Integer[] auxiliar = new Integer[fin - inicio];
        int izquierda = inicio;
        int derecha = mitad;
        int destino = 0;
        while (izquierda < mitad && derecha < fin) {
            auxiliar[destino++] = arr[izquierda] <= arr[derecha]
                    ? arr[izquierda++] : arr[derecha++];
        }
        while (izquierda < mitad) auxiliar[destino++] = arr[izquierda++];
        while (derecha < fin) auxiliar[destino++] = arr[derecha++];
        System.arraycopy(auxiliar, 0, arr, inicio, auxiliar.length);
    }
}
