package com.corozco.libro.patrones.comportamiento.mediator.modelo;

import lombok.Data;

@Data
public class Usuario extends General {

    private String nombre;
    private String contacto;

    public Usuario(final String id, final String nombre, final String contacto) {
        super(id);
        this.nombre = nombre;
        this.contacto = contacto;
    }
}
