package com.corozco.libro.patrones.comportamiento.iterator.modelo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {

    private String nombre;
    private String nombrePadre;
    private String nombreMadre;
    private String nombreHermanos;
}
