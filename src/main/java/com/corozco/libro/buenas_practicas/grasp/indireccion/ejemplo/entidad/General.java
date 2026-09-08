package com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo.entidad;

import lombok.Getter;

import java.util.UUID;

@Getter
public class General {
    private final String id = UUID.randomUUID().toString();
}