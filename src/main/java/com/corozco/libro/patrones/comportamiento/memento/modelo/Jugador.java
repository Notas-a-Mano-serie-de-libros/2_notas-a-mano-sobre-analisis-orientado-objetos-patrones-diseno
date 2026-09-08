package com.corozco.libro.patrones.comportamiento.memento.modelo;

import com.corozco.libro.patrones.comportamiento.memento.historico.Memento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Jugador {

    private long id;
    private int hp;
    private int exp;
    private int nivel;
    private boolean vivo;

    public Memento guardarMemento() {
        return new Memento(hp, exp, vivo);
    }

    public void restaurarMemento(final Memento memento) {
        this.hp = memento.getHp();
        this.exp = memento.getExp();
        this.vivo = memento.isVivo();
    }
}
