package capitulo3.grasp.creador.ejemplo_agregacion;

public class Cliente {

    public static void main(String[] args) {
        Equipo equipo = new Equipo("Equipo1");
        equipo.agregarJugador("Carlos", 10);
        equipo.agregarJugador("Julian", 11);
    }
}
