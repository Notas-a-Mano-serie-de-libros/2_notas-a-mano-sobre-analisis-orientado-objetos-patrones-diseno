package com.corozco.libro.patrones.comportamiento.mediator;

import com.corozco.libro.patrones.comportamiento.mediator.colega.Colega;
import com.corozco.libro.patrones.comportamiento.mediator.colega.concreto.ColegaUsuario;
import com.corozco.libro.patrones.comportamiento.mediator.colega.concreto.ColegaVuelo;
import com.corozco.libro.patrones.comportamiento.mediator.mediador.Mediador;
import com.corozco.libro.patrones.comportamiento.mediator.mediador.concreto.MediadorUsuario;
import com.corozco.libro.patrones.comportamiento.mediator.mediador.concreto.MediadorVuelo;
import com.corozco.libro.patrones.comportamiento.mediator.modelo.Usuario;
import com.corozco.libro.patrones.comportamiento.mediator.modelo.Vuelo;

public class Cliente {
    public static void main(String[] args) {
        chat();
        torreControl();
    }

    private static void chat() {

        final Mediador<Usuario> chat = new MediadorUsuario();
        final Colega<Usuario> carlos = new ColegaUsuario(chat, new Usuario("1",
                "Carlos Orozco", "3111111111"), "corozco");
        final Colega<Usuario> isabel = new ColegaUsuario(chat, new Usuario("2",
                "Isabel López", "3124326785"), "isalopez");

        chat.add(carlos);
        chat.add(isabel);

        System.out.println("Sala de chat");

        carlos.enviarMensaje("2", "Hola");
        System.out.println();
        isabel.enviarMensaje("1", "Hola, bien bien");
    }

    private static void torreControl() {

        final Mediador<Vuelo> torreControl = new MediadorVuelo();

        final Colega<Vuelo> vueloA = new ColegaVuelo(torreControl, new Vuelo("1", "VueloA"), "VueloA");
        final Colega<Vuelo> vueloB = new ColegaVuelo(torreControl, new Vuelo("2", "VueloB"), "VueloB");
        final Colega<Vuelo> vueloC = new ColegaVuelo(torreControl, new Vuelo("3", "VueloC"), "VueloC");

        torreControl.add(vueloA);
        torreControl.add(vueloB);
        torreControl.add(vueloC);

        System.out.println("\nTorre de control");
        vueloA.enviarMensaje("1", "\t" + vueloA.getLabel() + " solicita permiso para aterrizar");
        vueloB.enviarMensaje("2", "\t" + vueloB.getLabel() + " solicita permiso para despegar");
    }
}
