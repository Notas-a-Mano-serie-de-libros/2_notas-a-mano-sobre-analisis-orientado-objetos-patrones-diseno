package com.corozco.libro.patrones.comportamiento.observer.observable;

import com.corozco.libro.patrones.comportamiento.observer.observador.Suscriptor;

public interface IObservable {

    void agregarSuscriptor(Suscriptor suscriptor);

    void eliminarSuscriptor(Suscriptor suscriptor);

    void notificar();
}
