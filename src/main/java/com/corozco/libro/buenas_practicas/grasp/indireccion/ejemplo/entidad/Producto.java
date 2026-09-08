package com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Producto extends General {
    private String nombre;
    private String codigo;
}