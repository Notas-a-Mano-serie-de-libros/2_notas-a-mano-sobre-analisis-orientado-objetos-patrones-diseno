package com.corozco.libro.patrones.estructural.flyweight.dominio;

import lombok.Data;

@Data
public class SmartphoneLigero {

    private String id;

    private Hardware hardware;

    public SmartphoneLigero(final String id, final Hardware hardware) {
        this.id = id;
        this.hardware = hardware;
    }
}
