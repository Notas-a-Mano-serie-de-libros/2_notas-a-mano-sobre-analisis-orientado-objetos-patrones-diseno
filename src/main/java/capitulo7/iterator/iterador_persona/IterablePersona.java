package capitulo7.iterator.iterador_persona;

import capitulo7.iterator.Iterable;
import capitulo7.iterator.Iterador;
import capitulo7.iterator.modelo.Persona;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class IterablePersona implements Iterable {

    private final Persona persona;

    @Override
    public Iterador iterador() {
        return new IteradorPersona(persona);
    }
}