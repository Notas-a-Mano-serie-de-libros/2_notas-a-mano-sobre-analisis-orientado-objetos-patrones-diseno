package com.corozco.libro.patrones.estructural.bridge.sistema_operativo;

import com.corozco.libro.patrones.estructural.bridge.arquitectura.Arquitectura;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class SistemaOperativo {

    private String nombre;
    private String version;
    private Arquitectura arquitectura;

    @Override
    public String toString() {
        return "SistemaOperativo(nombre=" + this.nombre +
                ", version=" + this.version +
                ", arquitectura=" + this.arquitectura.getNombre() + ")";
    }
}
