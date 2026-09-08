package capitulo7.cadena_responsabilidad.manejadores;

import capitulo7.cadena_responsabilidad.cadena.SolicitudCredito;

public class EvaluadorDirectivo extends SolicitudCredito {

    @Override
    public void solicitar(final int monto) {
        if (monto > 1E7) {
            System.out.println("Evaluación por la junta directiva");
        }
    }
}
