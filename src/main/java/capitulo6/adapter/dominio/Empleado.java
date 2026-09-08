package capitulo6.adapter.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Empleado implements IEmpleado {

    private String documento;
    private String nombreCompleto;
    private String telefono;
}
