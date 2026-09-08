package com.corozco.libro.patrones.comportamiento.memento.historico;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Cuidador {

    private List<Memento> estados = new ArrayList<>();

    public void agregarMemento(final Memento memento) {
        estados.add(memento);
    }

    public Memento getMemento(final int indice) {
        return estados.get(indice);
    }
}
