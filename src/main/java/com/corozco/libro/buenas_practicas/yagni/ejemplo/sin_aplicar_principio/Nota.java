package com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Nota {
    private int id;
    private String contenido;
}