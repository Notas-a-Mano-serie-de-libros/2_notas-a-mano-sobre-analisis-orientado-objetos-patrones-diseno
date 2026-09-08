package com.corozco.libro.patrones.creacional.builder.constructor;

import com.corozco.libro.patrones.creacional.builder.modelo.Galaxia;

public class GalaxiaBuilderImplicito extends Galaxia {

    public static Builder builder(final int id, final String codigo) {
        return new Builder(id, codigo);
    }

    public static class Builder {

        private final Galaxia galaxia;

        public Builder(final int id, final String codigo) {
            this.galaxia = new Galaxia(id, codigo);
        }

        public Builder masa(final float masa) {
            this.galaxia.setMasa(masa);
            return this;
        }

        public Builder tipo(final String tipo) {
            this.galaxia.setTipo(tipo);
            return this;
        }

        public Galaxia build() {
            return this.galaxia;
        }
    }
}
