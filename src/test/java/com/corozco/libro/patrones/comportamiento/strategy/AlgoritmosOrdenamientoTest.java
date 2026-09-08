package com.corozco.libro.patrones.comportamiento.strategy;

import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.IAlgoritmoOrdenamiento;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoBurbuja;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoInsercion;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoMezcla;
import com.corozco.libro.patrones.comportamiento.strategy.algoritmo.implementacion.OrdenamientoRadix;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AlgoritmosOrdenamientoTest {

    private final List<IAlgoritmoOrdenamiento> algoritmos = Arrays.asList(
            new OrdenamientoBurbuja(),
            new OrdenamientoInsercion(),
            new OrdenamientoMezcla(),
            new OrdenamientoRadix()
    );

    @Test
    void ordenanVaciosDuplicadosNegativosYExtremos() {
        final Integer[][] casos = {
                {},
                {7},
                {4, 1, 4, 2, 0},
                {-8, 3, -1, 0, -8, 5},
                {Integer.MAX_VALUE, 0, Integer.MIN_VALUE, -1, 1}
        };

        for (final IAlgoritmoOrdenamiento algoritmo : algoritmos) {
            for (final Integer[] caso : casos) {
                final Integer[] esperado = caso.clone();
                final Integer[] obtenido = caso.clone();
                Arrays.sort(esperado);

                algoritmo.ordenar(obtenido);

                assertArrayEquals(esperado, obtenido, algoritmo.getClass().getSimpleName());
            }
        }
    }
}
