package com.corozco.libro.patrones.creacional.builder.constructor;

import com.corozco.libro.patrones.creacional.builder.modelo.Galaxia;
import com.corozco.libro.patrones.creacional.builder.modelo.Universo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class UniversoBuilder {

    private final Universo universo;

    public UniversoBuilder(final int id, final String codigo) {
        this.universo = new Universo(id, codigo);
        this.universo.setGalaxias(new ArrayList<>());
        this.universo.setPMateriaBarionica(0);
        this.universo.setPMateriaOscura(0);
        this.universo.setPEnergiaOscura(0);
    }

    public UniversoBuilder pMateriaBarionica(final int pMateriaBarionica) {
        this.universo.setPMateriaBarionica(pMateriaBarionica);
        return this;
    }

    public UniversoBuilder pMateriaOscura(final int pMateriaOscura) {
        this.universo.setPMateriaOscura(pMateriaOscura);
        return this;
    }

    public UniversoBuilder pEnergiaOscura(final int pEnergiaOscura) {
        this.universo.setPEnergiaOscura(pEnergiaOscura);
        return this;
    }

    public UniversoBuilder galaxias(final List<Galaxia> galaxias) {
        this.universo.setGalaxias(galaxias);
        return this;
    }

    public Universo build() {
        return this.universo;
    }
}
