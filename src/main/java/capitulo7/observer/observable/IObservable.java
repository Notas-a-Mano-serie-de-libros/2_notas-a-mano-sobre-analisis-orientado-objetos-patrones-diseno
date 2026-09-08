package capitulo7.observer.observable;

import capitulo7.observer.observador.Suscriptor;

public interface IObservable {

    void agregarSuscriptor(Suscriptor suscriptor);

    void eliminarSuscriptor(Suscriptor suscriptor);

    void notificar();
}
