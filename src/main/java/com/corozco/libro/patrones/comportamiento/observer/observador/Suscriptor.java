package com.corozco.libro.patrones.comportamiento.observer.observador;

import com.corozco.libro.patrones.comportamiento.observer.observable.IObservable;
import lombok.Data;


@Data
public abstract class Suscriptor {

    private IObservable observable;

    public abstract void notificar(String msg);
}
