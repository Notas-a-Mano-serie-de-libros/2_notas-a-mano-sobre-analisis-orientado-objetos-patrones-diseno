package capitulo7.cadena_responsabilidad.manejadores;

import capitulo7.cadena_responsabilidad.cadena.SolicitudCredito;

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
