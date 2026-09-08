package capitulo6.bridge.arquitectura;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Arquitectura {

    private String nombre;
    private String descripcion;
}
