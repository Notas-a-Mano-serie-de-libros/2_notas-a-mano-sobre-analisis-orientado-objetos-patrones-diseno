package capitulo7.cadena_responsabilidad.manejadores;

import capitulo7.cadena_responsabilidad.cadena.SolicitudCredito;

public class EvaluadorJudicial extends SolicitudCredito {

    @Override
    public void solicitar(final int monto) {
        if (monto > 5E6 && monto <= 1E7) {
            System.out.println("Evaluacion de antecedentes judiciales");
        } else {
            super.getSiguiente().solicitar(monto);
        }
    }
}
