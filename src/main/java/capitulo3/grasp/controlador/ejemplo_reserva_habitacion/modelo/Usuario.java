package capitulo3.grasp.controlador.ejemplo_reserva_habitacion.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Usuario {
    private String documento;
    private String nombre;
    private String email;
    private String telefono;
}
