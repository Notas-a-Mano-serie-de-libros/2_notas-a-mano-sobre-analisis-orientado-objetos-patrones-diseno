package com.corozco.libro.buenas_practicas.grasp.variacion_protegida.ejemplo.metodo_pago;

public class PagoPSE extends MetodoPago {

    @Override
    public void realizarPago(double monto) {
        System.out.println("Paga " + monto + " utilizando PSE");
    }
}
