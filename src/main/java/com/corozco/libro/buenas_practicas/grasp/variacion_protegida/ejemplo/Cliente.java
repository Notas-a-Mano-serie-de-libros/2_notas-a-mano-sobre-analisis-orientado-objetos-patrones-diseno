package com.corozco.libro.buenas_practicas.grasp.variacion_protegida.ejemplo;

import com.corozco.libro.buenas_practicas.grasp.variacion_protegida.ejemplo.metodo_pago.MetodoPago;
import com.corozco.libro.buenas_practicas.grasp.variacion_protegida.ejemplo.metodo_pago.PagoPSE;
import com.corozco.libro.buenas_practicas.grasp.variacion_protegida.ejemplo.metodo_pago.PagoPayPal;
import com.corozco.libro.buenas_practicas.grasp.variacion_protegida.ejemplo.metodo_pago.PagoTarjetaCredito;

public class Cliente {

    public static void main(String[] args) {
        MetodoPago tarjeta = new PagoTarjetaCredito();
        MetodoPago paypal = new PagoPayPal();
        MetodoPago pse = new PagoPSE();

        tarjeta.realizarPago(1000);
        paypal.realizarPago(2000);
        pse.realizarPago(3000);
    }
}
