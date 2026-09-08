package com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio;

import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.Vehiculo;
import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoCombustion;
import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoElectrico;
import com.corozco.libro.buenas_practicas.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoHibrido;

public class Cliente {

    public static void main(String[] args) throws Exception {
        EstacionServicio estacion = new EstacionServicio();
        Vehiculo combustion = new VehiculoCombustion();
        Vehiculo electrico = new VehiculoElectrico();
        Vehiculo hibrido = new VehiculoHibrido();

        estacion.reabastecer(combustion, 100, 0);
        estacion.reabastecer(electrico, 0, 70);
        estacion.reabastecer(hibrido, 80, 50);

        // Usuario intenta recargar un auto que funciona con gasolina
        combustion.recargarBateria(100);
    }
}
