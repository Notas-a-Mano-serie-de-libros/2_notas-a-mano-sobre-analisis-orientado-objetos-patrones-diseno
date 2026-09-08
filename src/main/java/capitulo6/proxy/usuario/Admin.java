package capitulo6.proxy.usuario;

import lombok.Data;

@Data
public class Admin extends UsuarioSistema {

    public Admin(final String usuario, final String contrasena) {
        super(usuario, contrasena);
        super.setAdmin(true);
    }
}
