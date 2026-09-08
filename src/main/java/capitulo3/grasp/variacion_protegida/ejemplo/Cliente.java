package capitulo3.grasp.variacion_protegida.ejemplo;

import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.MetodoPago;
import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.PagoPSE;
import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.PagoPayPal;
import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.PagoTarjetaCredito;

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
