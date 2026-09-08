package capitulo6.proxy.usuario;

import lombok.Data;

@Data
public class UsuarioBasico extends UsuarioSistema {

    private String nombreCompleto;

    public UsuarioBasico(final String usuario, final String contrasena, final String nombreCompleto) {
        super(usuario, contrasena);
        this.nombreCompleto = nombreCompleto;
        this.setAdmin(false);
    }
}
