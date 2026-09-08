package com.corozco.libro.patrones.comportamiento.memento;

import com.corozco.libro.patrones.comportamiento.memento.historico.Cuidador;
import com.corozco.libro.patrones.comportamiento.memento.modelo.Jugador;

public class Cliente {
    public static void main(String[] args) {

        final Cuidador cuidador = new Cuidador();
        final Jugador jugador = new Jugador(1, 100, 0, 1, true);

        System.out.println("Estado: " + jugador);
        cuidador.agregarMemento(jugador.guardarMemento());
        jugador.setExp(300);
        jugador.setNivel(2); // Sube de nivel
        System.out.println("Checkpoint: " + jugador);
        cuidador.agregarMemento(jugador.guardarMemento());

        // Mata al jugador
        jugador.setHp(0);
        jugador.setVivo(false);

        System.out.println("Jugador ha muerto: " + jugador);
        System.out.println("\nEstados guardados: " + cuidador.getEstados());
        System.out.println("Retorna al ultimo punto de control.");
        int ultimoEstado = cuidador.getEstados().size() - 1;
        jugador.restaurarMemento(cuidador.getMemento(ultimoEstado));
        System.out.println("Jugador vivo: " + jugador);
    }
}
