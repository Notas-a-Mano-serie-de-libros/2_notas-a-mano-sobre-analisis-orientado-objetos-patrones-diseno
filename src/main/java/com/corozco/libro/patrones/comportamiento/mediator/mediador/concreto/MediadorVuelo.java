package com.corozco.libro.patrones.comportamiento.mediator.mediador.concreto;

import com.corozco.libro.patrones.comportamiento.mediator.colega.Colega;
import com.corozco.libro.patrones.comportamiento.mediator.mediador.Mediador;
import com.corozco.libro.patrones.comportamiento.mediator.modelo.Vuelo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MediadorVuelo extends Mediador<Vuelo> {

    @Override
    public void enviarMensaje(final String id, final String msg) {
        final Colega<Vuelo> colega = super.getMap().get(id);
        if (null != colega) {
            System.out.println("\n" + "Notificacion a torre de control");
            System.out.println(msg);

            System.out.println("\nTorre de control notifica a los vuelos");
            final List<Colega<Vuelo>> receptores = super.getMap().entrySet().stream()
                    .filter(a -> !a.getKey().equals(id))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());

            final String[] solicitud = msg.split(" ");
            final String label = solicitud[0];
            final String accion = solicitud[solicitud.length - 1];

            for (final Colega<Vuelo> receptor : receptores) {
                receptor.recibirMensaje(label + " " + "ha sido autorizado para " + accion);
            }

        }
    }
}
