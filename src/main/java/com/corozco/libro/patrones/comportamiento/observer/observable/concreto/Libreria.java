package com.corozco.libro.patrones.comportamiento.observer.observable.concreto;

import com.corozco.libro.patrones.comportamiento.observer.observable.IObservable;
import com.corozco.libro.patrones.comportamiento.observer.observador.Suscriptor;

import java.util.ArrayList;
import java.util.List;

public class Libreria implements IObservable {

    private final List<Suscriptor> suscriptores = new ArrayList<>();
    ;
    private final List<String> libros = new ArrayList<>();
    private String nuevoLibro;

    @Override
    public void agregarSuscriptor(final Suscriptor suscriptor) {
        suscriptor.setObservable(this);
        this.suscriptores.add(suscriptor);
    }

    @Override
    public void eliminarSuscriptor(final Suscriptor suscriptor) {
        suscriptor.setObservable(null);
        this.suscriptores.remove(suscriptor);
    }

    public void agregarLibro(final String nuevoLibro) {
        this.nuevoLibro = nuevoLibro;
        this.libros.add(this.nuevoLibro);
        this.notificar();
    }

    @Override
    public void notificar() {
        System.out.println("\nEnvia notificación a suscriptores activos");
        if (suscriptores.isEmpty()) {
            System.out.println("\tLa librería no tiene suscriptores activos");
            return;
        }
        final String msg = this.nuevoLibro + " está disponible";
        this.suscriptores.forEach(foo -> foo.notificar(msg));
    }

    public void getInfoLibros() {
        System.out.println("\t" + libros);
    }
}
