package com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.manejadores;

import com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.cadena.SolicitudCredito;

public class EvaluadorRiesgo extends SolicitudCredito {

    @Override
    public void solicitar(final int monto) {
        if (monto > 1E5 && monto <= 5E6) {
            System.out.println("Evaluación de riesgo");
        } else {
            super.getSiguiente().solicitar(monto);
        }
    }
}
