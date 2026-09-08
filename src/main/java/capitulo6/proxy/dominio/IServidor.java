package capitulo6.proxy.dominio;

import capitulo6.proxy.usuario.UsuarioSistema;

public interface IServidor {

    void acceder(UsuarioSistema usuario, String url);
}
