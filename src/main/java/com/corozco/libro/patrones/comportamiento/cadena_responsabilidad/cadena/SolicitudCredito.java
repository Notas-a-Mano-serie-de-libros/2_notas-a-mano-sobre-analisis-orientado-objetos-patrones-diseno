package com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.cadena;


import lombok.Data;

@Data
public abstract class SolicitudCredito {

    private SolicitudCredito siguiente;

    public abstract void solicitar(int monto);
}
