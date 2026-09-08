package capitulo5.prototype.oveja;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class IOvejaPrototipo implements Cloneable {

    private Long id;
    private String nombre;

    public abstract IOvejaPrototipo clonar() throws CloneNotSupportedException;
}
