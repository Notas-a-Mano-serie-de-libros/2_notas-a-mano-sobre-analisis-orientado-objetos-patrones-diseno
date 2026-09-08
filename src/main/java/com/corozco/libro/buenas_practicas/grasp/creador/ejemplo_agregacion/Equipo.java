package com.corozco.libro.buenas_practicas.grasp.creador.ejemplo_agregacion;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private final String nombreEquipo;
    private final List<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void agregarJugador(String nombre, int numero) {
        // La clase crea una nueva instancia que se agrega en la lista
        Jugador jugador = new Jugador(nombre, numero);
        jugadores.add(jugador);
    }
}