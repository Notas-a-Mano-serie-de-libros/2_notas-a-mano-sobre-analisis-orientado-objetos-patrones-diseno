package capitulo7.observer.observador;

import capitulo7.observer.observable.IObservable;
import lombok.Data;


@Data
public abstract class Suscriptor {

    private IObservable observable;

    public abstract void notificar(String msg);
}
