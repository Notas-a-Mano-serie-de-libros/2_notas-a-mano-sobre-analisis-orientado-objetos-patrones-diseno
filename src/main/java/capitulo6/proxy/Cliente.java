package capitulo6.proxy;

import capitulo6.proxy.dominio.IServidor;
import capitulo6.proxy.dominio.implementacion.Proxy;
import capitulo6.proxy.usuario.Admin;
import capitulo6.proxy.usuario.UsuarioBasico;
import capitulo6.proxy.usuario.UsuarioSistema;

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
