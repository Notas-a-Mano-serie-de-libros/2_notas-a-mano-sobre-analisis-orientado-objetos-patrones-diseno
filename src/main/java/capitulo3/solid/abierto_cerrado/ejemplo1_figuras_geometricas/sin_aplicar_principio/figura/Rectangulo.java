package capitulo3.solid.abierto_cerrado.ejemplo1_figuras_geometricas.sin_aplicar_principio.figura;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rectangulo extends Figura {
    private double base;
    private double altura;
}
