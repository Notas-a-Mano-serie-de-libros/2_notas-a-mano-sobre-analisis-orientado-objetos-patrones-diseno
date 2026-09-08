package com.corozco.libro.patrones.comportamiento.iterator.iterador_persona;

import com.corozco.libro.patrones.comportamiento.iterator.Iterador;
import com.corozco.libro.patrones.comportamiento.iterator.modelo.Persona;

public class IteradorPersona implements Iterador {

    private final Persona persona;
    private final String[] hermanos;
    private int indice;
    private int indiceHermanos;

    public IteradorPersona(final Persona persona) {
        this.persona = persona;
        this.indice = 0;
        this.indiceHermanos = 0;
        this.hermanos = null == persona.getNombreHermanos() ? new String[]{} : persona.getNombreHermanos().split(",");
    }

    @Override
    public void siguiente() {
        if (this.indice <= 2)
            this.indice += 1;
        else
            this.indiceHermanos += 1;
    }

    @Override
    public String actual() {
        if (this.indice <= 2) {
            switch (this.indice) {
                case 0:
                    return "Nombre: " + this.persona.getNombre();
                case 1:
                    return "\n\tPadre: " + this.persona.getNombrePadre();
                case 2:
                    return "\n\tMadre: " + this.persona.getNombreMadre();
            }
        }

        if (this.hermanos.length == 0) {
            return "\n\tNo tiene hermanos.";
        }

        return "\n\tHermano_" + (this.indiceHermanos + 1) + ": " + this.hermanos[indiceHermanos].trim();
    }

    @Override
    public boolean hasNext() {
        return this.indice <= 2 || this.indiceHermanos == 0 || this.indiceHermanos < this.hermanos.length;
    }
}
