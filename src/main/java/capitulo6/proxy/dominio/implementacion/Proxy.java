package capitulo6.proxy.dominio.implementacion;

import capitulo6.proxy.dominio.IServidor;
import capitulo6.proxy.usuario.UsuarioSistema;

import java.util.Arrays;

public class Proxy implements IServidor {

    private final String host;
    private final String port;
    private ServidorReal servidor;

    public Proxy(final String host, final String port) {
        this.host = host;
        this.port = port;
    }

    private boolean tieneAcceso(final UsuarioSistema usuario, final String url) {
        return usuario.isAdmin() || !Arrays.asList("admin", "server").contains(url);
    }

    @Override
    public void acceder(final UsuarioSistema usuario, final String url) {
        if (tieneAcceso(usuario, url)) {
            if (null == servidor)
                servidor = new ServidorReal(host, port);
            servidor.acceder(usuario, url);
        } else {
            System.out.println("El usuario " + usuario.getUsuario() + " no tiene acceso al recurso solicitado");
        }
    }
}
