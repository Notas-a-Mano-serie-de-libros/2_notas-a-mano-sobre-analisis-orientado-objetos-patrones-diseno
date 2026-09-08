package capitulo7.visitor.abstraccion;

import capitulo7.visitor.visitante.IVisitante;

public interface IVisitable {

    void aceptarVisitante(IVisitante visitante);
}
