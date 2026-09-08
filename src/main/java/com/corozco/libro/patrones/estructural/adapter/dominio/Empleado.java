package com.corozco.libro.patrones.estructural.adapter.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Empleado implements IEmpleado {

    private String documento;
    private String nombreCompleto;
    private String telefono;
}
