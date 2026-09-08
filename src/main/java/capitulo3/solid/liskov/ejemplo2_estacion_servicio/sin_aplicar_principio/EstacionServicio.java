package capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio;

import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.Vehiculo;
import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoCombustion;
import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoElectrico;
import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoHibrido;

public class EstacionServicio {

    public void reabastecer(Vehiculo vehiculo, double porcentajeGasolina,
                            double porcentajeRecarga) throws UnsupportedOperationException {

        if (vehiculo instanceof VehiculoCombustion) {
            vehiculo.llenarTanque(porcentajeGasolina);
        } else if (vehiculo instanceof VehiculoElectrico) {
            vehiculo.recargarBateria(porcentajeRecarga);
        } else if (vehiculo instanceof VehiculoHibrido) {
            vehiculo.llenarTanque(porcentajeGasolina);
            vehiculo.recargarBateria(porcentajeRecarga);
        }

        throw new UnsupportedOperationException();
    }
}
