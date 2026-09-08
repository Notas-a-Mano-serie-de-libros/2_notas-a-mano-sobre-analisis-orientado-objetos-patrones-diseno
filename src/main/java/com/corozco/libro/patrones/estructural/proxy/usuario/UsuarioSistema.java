package com.corozco.libro.patrones.estructural.proxy.usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class UsuarioSistema {

    private String usuario;

    private String contrasena;

    private boolean admin;

    public UsuarioSistema(final String usuario, final String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
