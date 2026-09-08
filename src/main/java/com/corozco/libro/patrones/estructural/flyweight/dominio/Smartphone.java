package com.corozco.libro.patrones.estructural.flyweight.dominio;

import lombok.Data;

@Data
public class Smartphone {

    private String id;

    private String ram;

    private String disco;

    private float costo;

    public Smartphone(final String id, final String ram, final String disco, final float costo) {
        this.id = id;
        this.ram = ram;
        this.disco = disco;
        this.costo = costo;
    }

    public float aplicarDescuento(final float descuento) {
        return (descuento / 100) * costo;
    }
}
