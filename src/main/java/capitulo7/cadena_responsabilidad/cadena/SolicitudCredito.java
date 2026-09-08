package capitulo7.cadena_responsabilidad.cadena;


import lombok.Data;

@Data
public abstract class SolicitudCredito {

    private SolicitudCredito siguiente;

    public abstract void solicitar(int monto);
}
