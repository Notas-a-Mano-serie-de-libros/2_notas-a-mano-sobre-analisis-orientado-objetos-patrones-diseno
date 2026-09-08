package com.corozco.libro.patrones.comportamiento.mediator.mediador;

import com.corozco.libro.patrones.comportamiento.mediator.colega.Colega;
import com.corozco.libro.patrones.comportamiento.mediator.modelo.General;
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
