package com.corozco.libro.patrones.estructural.adapter.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trabajador {

    private float id;
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private Long contacto;
    private Integer indicador;
}
