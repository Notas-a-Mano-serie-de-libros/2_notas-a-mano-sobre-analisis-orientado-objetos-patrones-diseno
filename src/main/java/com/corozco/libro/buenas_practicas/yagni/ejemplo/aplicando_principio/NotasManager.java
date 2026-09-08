package com.corozco.libro.buenas_practicas.yagni.ejemplo.aplicando_principio;

import java.util.ArrayList;
import java.util.List;

public class NotasManager {
    private final List<Nota> notas;

    public NotasManager() {
        this.notas = new ArrayList<>();
    }

    public void crearNota(String contenido) {
        int id = notas.size() + 1;
        Nota nuevaNota = new Nota(id, contenido);
        notas.add(nuevaNota);
    }

    public void eliminarNota(int idNota) {
        notas.removeIf(nota -> nota.getId() == idNota);
    }

    public Nota obtenerNota(int idNota) {
        return notas.stream()
                .filter(nota -> nota.getId() == idNota)
                .findFirst()
                .orElse(null);
    }

    public void editarNota(int idNota, String nuevoContenido) {
        Nota nota = obtenerNota(idNota);
        if (nota != null) {
            nota.setContenido(nuevoContenido);
        }
    }
}