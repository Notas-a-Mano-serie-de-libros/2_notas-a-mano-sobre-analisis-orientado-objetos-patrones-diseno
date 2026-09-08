package com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion;

import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.habitacion.Habitacion;
import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.habitacion.HabitacionLujo;
import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.habitacion.HabitacionPremium;
import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.habitacion.HabitacionSencilla;
import com.corozco.libro.buenas_practicas.grasp.controlador.ejemplo_reserva_habitacion.modelo.Usuario;

import java.util.Date;

public class Cliente {

    public static void main(String[] args) throws Exception {
        HotelController manager = new HotelController("Hotel X");
        Habitacion basica = new HabitacionSencilla(1, 1500);
        Habitacion premium = new HabitacionPremium(2, 2000);
        Habitacion lujo = new HabitacionLujo(3, 3000);

        Usuario carlos = new Usuario("1", "Carlos", "corozco@foo.com", "1234");
        Usuario andrea = new Usuario("2", "Andrea", "alopez@foo.com", "2345");
        Usuario juan = new Usuario("3", "Juan", "jtopo@foo.com", "3456");

        manager.crearReserva(new Date(), new Date(), carlos, basica);
        manager.crearReserva(new Date(), new Date(), andrea, premium);
        manager.crearReserva(new Date(), new Date(), juan, lujo);

        String codigoReserva = manager.obtenerCodigoReserva("1");
        manager.cancelarReserva(codigoReserva);
    }
}
