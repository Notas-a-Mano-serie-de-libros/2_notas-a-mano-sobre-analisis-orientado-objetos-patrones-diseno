package com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion;

import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.habitacion.Habitacion;
import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.modelo.Reserva;
import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.modelo.Usuario;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class HotelController {

    private final List<Reserva> reservas = new ArrayList<>();
    private final String nombre;

    public HotelController(final String nombre) {
        this.nombre = nombre;
    }

    public void crearReserva(Date fechaEntrada,
                             Date fechaSalida,
                             Usuario usuario,
                             Habitacion habitacion) {

        Reserva reserva = new Reserva(fechaEntrada,
                fechaSalida,
                usuario,
                habitacion);

        reservas.add(reserva);
        System.out.println(usuario.getNombre() + " reservó una habitación");
    }

    public void cancelarReserva(String codigo) throws Exception {
        Reserva reserva = reservas.stream()
                .filter(aux -> aux.getCodigoReserva()
                        .equals(codigo))
                .findFirst()
                .orElseThrow(() -> new Exception("La reserva no existe"));

        String nombreUsuario = reserva.getUsuario().getNombre();
        System.out.println(nombreUsuario + " canceló su reserva");
        reservas.remove(reserva);
    }

    public String obtenerCodigoReserva(String documento) throws Exception {
        return reservas.stream()
                .filter(aux -> aux.getUsuario().getDocumento()
                        .equals(documento))
                .findFirst()
                .map(Reserva::getCodigoReserva)
                .orElseThrow(() -> new Exception("La reserva no existe"));
    }
}
