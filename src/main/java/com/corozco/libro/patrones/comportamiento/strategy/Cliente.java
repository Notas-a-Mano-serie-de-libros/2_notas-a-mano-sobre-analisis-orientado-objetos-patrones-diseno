package com.corozco.libro.patrones.comportamiento.strategy;

import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.Operacion;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoBurbuja;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoInsercion;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoMezcla;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoRadix;

import java.util.Random;
import java.util.stream.IntStream;

public class Cliente {
    public static void main(String[] args) {

        Integer[] numeros = getRandomArr();
        final Operacion burbuja = new Operacion(new OrdenamientoBurbuja());
        burbuja.ordenar(numeros);

        numeros = getRandomArr();
        final Operacion insercion = new Operacion(new OrdenamientoInsercion());
        insercion.ordenar(numeros);

        numeros = getRandomArr();
        final Operacion radix = new Operacion(new OrdenamientoRadix());
        radix.ordenar(numeros);

        numeros = getRandomArr();
        final Operacion mezcla = new Operacion(new OrdenamientoMezcla());
        mezcla.ordenar(numeros);
    }

    private static Integer[] getRandomArr() {
        return IntStream.generate(() -> new Random().nextInt(100)).limit(10).boxed().toArray(Integer[]::new);
    }
}
