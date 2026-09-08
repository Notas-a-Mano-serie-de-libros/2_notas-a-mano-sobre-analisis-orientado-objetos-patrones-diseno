package com.corozco.libro.patrones.comportamiento.visitor.abstraccion;

import com.corozco.libro.patrones.comportamiento.visitor.visitante.IVisitante;
import lombok.Data;

@Data
public abstract class Tarjeta {

    private double ultimoPago;

    private double totalPagos;

    private double interesAcumulado;

    private double millasAcumuladas;

    public void info() {
        operacionLegada1();
        operacionLegada2();
        operacionLegada3();
        operacionLegada4();
        operacionLegadaN();
    }

    public abstract void operacionLegada1();

    public abstract void operacionLegada2();

    public abstract void operacionLegada3();

    public abstract void operacionLegada4();

    public abstract void operacionLegadaN();

    public abstract void comprar(IVisitante cuotaManejo, IVisitante millas, double monto);

}
