package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio;

import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.Vehiculo;
import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.VehiculoCombustion;
import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.VehiculoElectrico;
import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.VehiculoHibrido;

public class Cliente {

    public static void main(String[] args) {
        EstacionServicio estacion = new EstacionServicio();

        Vehiculo combustion = new VehiculoCombustion();
        Solicitud recargaCombustible = new Solicitud();
        recargaCombustible.setPorcentajeGasolina(100);
        estacion.reabastecer(combustion, recargaCombustible);

        Vehiculo electrico = new VehiculoElectrico();
        Solicitud recargaBateria = new Solicitud();
        recargaBateria.setPorcentajeRecarga(70);
        estacion.reabastecer(electrico, recargaBateria);

        Vehiculo hibrido = new VehiculoHibrido();
        Solicitud recargaHibrido = new Solicitud();
        recargaHibrido.setPorcentajeGasolina(80);
        recargaHibrido.setPorcentajeRecarga(50);
        estacion.reabastecer(hibrido, recargaHibrido);

        System.out.println("Sistema termina ejecución sin excepciones");
    }
}
