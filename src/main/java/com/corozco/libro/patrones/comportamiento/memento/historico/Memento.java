package com.corozco.libro.patrones.comportamiento.memento.historico;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Memento {

    private int hp;
    private int exp;
    private boolean vivo;
}
