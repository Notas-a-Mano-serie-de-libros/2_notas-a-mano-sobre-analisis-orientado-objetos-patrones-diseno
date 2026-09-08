package com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.modelo;

import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.habitacion.Habitacion;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Reserva {

    private final String codigoReserva;
    private final Date fechaEntrada;
    private final Date fechaSalida;
    private final Usuario usuario;
    private final Habitacion habitacion;

    public Reserva(Date fechaEntrada, Date fechaSalida,
                   Usuario usuario, Habitacion habitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.usuario = usuario;
        this.habitacion = habitacion;

        // Genera un código para la reserva
        this.codigoReserva = UUID.randomUUID().toString();
    }
}
