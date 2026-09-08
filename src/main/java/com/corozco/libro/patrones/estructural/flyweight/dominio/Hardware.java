package com.corozco.libro.patrones.estructural.flyweight.dominio;

import lombok.Data;

@Data
public class Hardware {

    private String ram;

    private String disco;

    private float costo;

    public Hardware(final String ram, final String disco, final float costo) {
        this.ram = ram;
        this.disco = disco;
        this.costo = costo;
    }

    public float aplicarDescuento(final float descuento) {
        return costo * (1 - descuento / 100);
    }
}
