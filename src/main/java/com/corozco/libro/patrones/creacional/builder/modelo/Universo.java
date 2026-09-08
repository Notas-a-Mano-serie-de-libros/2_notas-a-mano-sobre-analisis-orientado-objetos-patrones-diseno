package com.corozco.libro.patrones.creacional.builder.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Universo extends General {

    private int pMateriaBarionica;
    private int pMateriaOscura;
    private int pEnergiaOscura;
    private List<Galaxia> galaxias = new ArrayList<>();

    public Universo(int id, final String codigo) {
        super(id, codigo);
    }

    @Override
    public String toString() {
        return "Universo(id=" + super.getId() +
                ", pMateriaBarionica=" + this.pMateriaBarionica + "%" +
                ", pMateriaOscura=" + this.pMateriaOscura + "%" +
                ", pEnergiaOscura=" + this.pEnergiaOscura + "%" +
                ", galaxias=" + this.getGalaxias().size() + ")";
    }
}
