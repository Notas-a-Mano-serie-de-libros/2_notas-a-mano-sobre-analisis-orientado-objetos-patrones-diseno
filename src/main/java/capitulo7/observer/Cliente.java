package capitulo7.observer;

import capitulo7.observer.observable.concreto.Libreria;
import capitulo7.observer.observador.concreto.Comprador;

public class Cliente {
    public static void main(String[] args) {

        final Libreria libreria = new Libreria();

        // Los usuarios están suscritos a la librería por defecto
        final Comprador carlos = new Comprador("Carlos", libreria);
        final Comprador julian = new Comprador("Julian", libreria);

        libreria.agregarLibro("Clean code");
        libreria.eliminarSuscriptor(julian);
        libreria.agregarLibro("The pragmatic programmer");
        libreria.eliminarSuscriptor(carlos);
        libreria.agregarLibro("Code complete");
        System.out.println("\nLibros en el sistema");
        libreria.getInfoLibros();
    }
}
