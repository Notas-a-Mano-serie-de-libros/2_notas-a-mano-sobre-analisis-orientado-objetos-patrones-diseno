package com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.exporte.ServicioExporte;
import com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.mensajeria.ServicioMensajeria;

import java.util.ArrayList;
import java.util.List;

public class NotasManager {
    private final List<Nota> notas;
    private final ServicioExporte servicioExporte;
    private final ServicioMensajeria servicioEmail;

    public NotasManager(ServicioExporte servicioExporte, ServicioMensajeria servicioEmail) {
        this.notas = new ArrayList<>();
        this.servicioExporte = servicioExporte;
        this.servicioEmail = servicioEmail;
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

    public void exportarNota(Nota nota) {
        servicioExporte.exportarNota(nota);
    }

    public void compartirNota(Nota nota) {
        servicioEmail.compartirNota(nota);
    }
}