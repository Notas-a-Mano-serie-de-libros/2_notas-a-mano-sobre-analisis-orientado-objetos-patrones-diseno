package capitulo7.visitor.visitante;

import capitulo7.visitor.abstraccion.implementacion.TarjetaBlack;
import capitulo7.visitor.abstraccion.implementacion.TarjetaGold;
import capitulo7.visitor.abstraccion.implementacion.TarjetaPlatino;

public interface IVisitante {

    void visitar(TarjetaGold tarjeta);

    void visitar(TarjetaPlatino tarjeta);

    void visitar(TarjetaBlack tarjeta);
}
