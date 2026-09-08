package com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.manejadores;

import com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.cadena.SolicitudCredito;

public class Asesor extends SolicitudCredito {

    @Override
    public void solicitar(final int monto) {
        if (monto <= 1E5) {
            System.out.println("Verifica estado actual de endeudamiento");
        } else {
            super.getSiguiente().solicitar(monto);
        }
    }
}
