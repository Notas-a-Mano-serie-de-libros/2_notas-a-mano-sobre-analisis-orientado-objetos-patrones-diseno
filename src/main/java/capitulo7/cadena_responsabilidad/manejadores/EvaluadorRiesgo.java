package capitulo7.cadena_responsabilidad.manejadores;

import capitulo7.cadena_responsabilidad.cadena.SolicitudCredito;

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
