package capitulo7.mediator.mediador;

import capitulo7.mediator.colega.Colega;
import capitulo7.mediator.modelo.General;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class Mediador<T extends General> {

    private final Map<String, Colega<T>> map = new HashMap<>();

    public abstract void enviarMensaje(String id, String msg);

    public void add(Colega<T> obj) {
        this.map.put(obj.getId(), obj);
    }
}
