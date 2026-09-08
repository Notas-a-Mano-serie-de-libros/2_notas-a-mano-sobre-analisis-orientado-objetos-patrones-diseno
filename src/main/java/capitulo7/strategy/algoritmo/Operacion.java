package capitulo7.strategy.algoritmo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Operacion {

    private final IAlgoritmoOrdenamiento algoritmo;

    public void ordenar(final Integer[] arr) {
        algoritmo.ordenar(arr);
    }
}
