package capitulo7.iterator.iterador_arreglo;

import capitulo7.iterator.Iterable;
import capitulo7.iterator.Iterador;

public class IterableArreglo<T> implements Iterable {

    private final T[] elementos;

    public IterableArreglo(final T[] elementos) {
        this.elementos = elementos;
    }

    @Override
    public Iterador iterador() {
        return new IteradorArreglo<>(elementos);
    }
}