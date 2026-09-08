package capitulo5.builder.constructor;

import capitulo5.builder.modelo.Galaxia;

public class GalaxiaBuilder {

    private final Galaxia galaxia;

    public GalaxiaBuilder(final int id, final String codigo) {
        this.galaxia = new Galaxia(id, codigo);
    }

    public GalaxiaBuilder masa(final float masa) {
        this.galaxia.setMasa(masa);
        return this;
    }

    public GalaxiaBuilder tipo(final String tipo) {
        this.galaxia.setTipo(tipo);
        return this;
    }

    public GalaxiaBuilder grupo(final String grupo) {
        this.galaxia.setGrupo(grupo);
        return this;
    }

    public Galaxia build() {
        return this.galaxia;
    }
}
