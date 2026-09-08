package com.corozco.libro.patrones.estructural.proxy;

import com.corozco.libro.patrones.estructural.proxy.dominio.IServidor;
import com.corozco.libro.patrones.estructural.proxy.dominio.implementacion.Proxy;
import com.corozco.libro.patrones.estructural.proxy.usuario.Admin;
import com.corozco.libro.patrones.estructural.proxy.usuario.UsuarioBasico;
import com.corozco.libro.patrones.estructural.proxy.usuario.UsuarioSistema;

public class Cliente {
    public static void main(String[] args) {
        final UsuarioSistema admin = new Admin("admin", "admin");
        final UsuarioSistema corozco = new UsuarioBasico("corozco", "111",
                "Carlos Orozco");

        final IServidor proxyServer = new Proxy("host_remoto", "8081");
        proxyServer.acceder(corozco, "login");
        proxyServer.acceder(corozco, "admin");
        proxyServer.acceder(admin, "admin");
        proxyServer.acceder(admin, "server");
    }
}
