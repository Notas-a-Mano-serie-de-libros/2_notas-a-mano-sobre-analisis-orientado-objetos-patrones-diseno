package com.corozco.libro.patrones.creacional.builder.modelo;

public class GalaxiaConConstructores extends Galaxia {

    public GalaxiaConConstructores(int id, String codigo) {
        super(id, codigo);
    }

    public GalaxiaConConstructores(int id, String codigo, final float masa) {
        super(id, codigo);
        super.setMasa(masa);
    }

    public GalaxiaConConstructores(int id, String codigo, final float masa, final String tipo, final String grupo) {
        super(id, codigo);
        super.setMasa(masa);
        super.setTipo(tipo);
        super.setGrupo(grupo);
    }
}
