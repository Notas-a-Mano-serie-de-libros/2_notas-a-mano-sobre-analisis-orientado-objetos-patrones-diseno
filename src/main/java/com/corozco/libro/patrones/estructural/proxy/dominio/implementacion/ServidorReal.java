package com.corozco.libro.patrones.estructural.proxy.dominio.implementacion;

import com.corozco.libro.patrones.estructural.proxy.dominio.IServidor;
import com.corozco.libro.patrones.estructural.proxy.usuario.UsuarioSistema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServidorReal implements IServidor {

    private String host;
    private String port;

    @Override
    public void acceder(final UsuarioSistema usuario, final String url) {
        System.out.println("Usuario: " + usuario.getUsuario() + "; Url: " + this.host + ":" + this.port + "/" + url);
    }
}
