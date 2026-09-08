package com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion;

import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.IAlgoritmoOrdenamiento;

import java.util.Arrays;

public class OrdenamientoRadix implements IAlgoritmoOrdenamiento {

    public void ordenar(final Integer[] arr) {

        System.out.println("Estas ordenando con el metodo radix sort");

        System.out.println("\tArreglo original: " + Arrays.toString(arr));
        if (arr.length > 0) {
            long minimo = arr[0];
            for (final int valor : arr) minimo = Math.min(minimo, valor);
            final long desplazamiento = minimo < 0 ? -minimo : 0;
            long maximoNormalizado = 0;
            for (final int valor : arr) maximoNormalizado = Math.max(maximoNormalizado, valor + desplazamiento);

            final Integer[] salida = new Integer[arr.length];
            for (long exponente = 1; maximoNormalizado / exponente > 0; exponente *= 10) {
                final int[] conteo = new int[10];
                for (final int valor : arr) conteo[(int) ((valor + desplazamiento) / exponente % 10)]++;
                for (int i = 1; i < conteo.length; i++) conteo[i] += conteo[i - 1];
                for (int i = arr.length - 1; i >= 0; i--) {
                    final int digito = (int) ((arr[i] + desplazamiento) / exponente % 10);
                    salida[--conteo[digito]] = arr[i];
                }
                System.arraycopy(salida, 0, arr, 0, arr.length);
                if (exponente > Long.MAX_VALUE / 10L) break;
            }
        }
        System.out.println("\tArreglo ordenado: " + Arrays.toString(arr));
    }
}
