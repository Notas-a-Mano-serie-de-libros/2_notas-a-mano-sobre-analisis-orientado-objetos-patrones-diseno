package com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Persona extends General {
    private String nombre;
    private String telefono;
    private String documento;
}