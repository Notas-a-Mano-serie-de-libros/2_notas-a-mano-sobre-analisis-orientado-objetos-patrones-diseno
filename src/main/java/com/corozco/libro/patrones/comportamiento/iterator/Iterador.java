package com.corozco.libro.patrones.comportamiento.iterator;

public interface Iterador {

    boolean hasNext(); // Este metodo se deja en inglés solo por estándar

    void siguiente();

    String actual();
}
