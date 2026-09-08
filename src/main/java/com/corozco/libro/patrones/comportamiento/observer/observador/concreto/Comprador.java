package com.corozco.libro.patrones.comportamiento.observer.observador.concreto;

import com.corozco.libro.patrones.comportamiento.observer.observable.concreto.Libreria;
import com.corozco.libro.patrones.comportamiento.observer.observador.Suscriptor;

public class Comprador extends Suscriptor {

    private String nombre;

    public Comprador(final String nombre) {
        this.nombre = nombre;
    }

    public Comprador(final String nombre, final Libreria observable) {
        this.nombre = nombre;
        super.setObservable(observable);
        observable.agregarSuscriptor(this);
    }

    @Override
    public void notificar(final String msg) {
        System.out.println("\tHola " + this.nombre + ": " + msg);
    }
}
