package com.corozco.libro.patrones.creacional.prototype.oveja;


public class OvejaImpl extends IOvejaPrototipo {

    public OvejaImpl(Long id, String nombre) {
        super(id, nombre);
    }

    @Override
    public IOvejaPrototipo clonar() throws CloneNotSupportedException {
        return (IOvejaPrototipo) super.clone();
    }
}
