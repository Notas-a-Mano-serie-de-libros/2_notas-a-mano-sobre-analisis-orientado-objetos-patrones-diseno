package com.corozco.libro.patrones.estructural.proxy.dominio;

import com.corozco.libro.patrones.estructural.proxy.usuario.UsuarioSistema;

public interface IServidor {

    void acceder(UsuarioSistema usuario, String url);
}
