package com.corozco.libro.buenas_practicas.demeter.ejemplo_libreria.aplicando_principio;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Libreria libreria = new Libreria();
        libreria.consultarAutorLibro(1);
    }
}
