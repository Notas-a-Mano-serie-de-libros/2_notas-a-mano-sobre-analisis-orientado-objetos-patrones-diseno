package capitulo7.state.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {

    private long id;
    private String nombre;
    private int edad;
}
