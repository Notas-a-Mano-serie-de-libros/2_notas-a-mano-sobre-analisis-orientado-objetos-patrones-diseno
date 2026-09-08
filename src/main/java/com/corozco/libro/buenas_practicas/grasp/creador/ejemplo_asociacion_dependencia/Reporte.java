package com.corozco.libro.buenas_practicas.grasp.creador.ejemplo_asociacion_dependencia;

import lombok.Getter;

@Getter
public class Reporte {
    
    private String contenido;

    public void agregarContenido(String texto) {
        contenido += texto;
    }
}