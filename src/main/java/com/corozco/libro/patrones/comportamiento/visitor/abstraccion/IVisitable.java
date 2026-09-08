package com.corozco.libro.patrones.comportamiento.visitor.abstraccion;

import com.corozco.libro.patrones.comportamiento.visitor.visitante.IVisitante;

public interface IVisitable {

    void aceptarVisitante(IVisitante visitante);
}
