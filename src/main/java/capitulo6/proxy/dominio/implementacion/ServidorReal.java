package capitulo6.proxy.dominio.implementacion;

import capitulo6.proxy.dominio.IServidor;
import capitulo6.proxy.usuario.UsuarioSistema;
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
