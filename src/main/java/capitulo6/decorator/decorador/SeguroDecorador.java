package capitulo6.decorator.decorador;

import capitulo6.decorator.dominio.Seguro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SeguroDecorador extends Seguro {

    private Seguro seguro;
}
