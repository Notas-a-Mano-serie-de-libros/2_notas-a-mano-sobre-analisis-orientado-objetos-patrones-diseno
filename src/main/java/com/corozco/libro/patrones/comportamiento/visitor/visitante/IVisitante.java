package com.corozco.libro.patrones.comportamiento.visitor.visitante;

import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaBlack;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaGold;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaPlatino;

public interface IVisitante {

    void visitar(TarjetaGold tarjeta);

    void visitar(TarjetaPlatino tarjeta);

    void visitar(TarjetaBlack tarjeta);
}
