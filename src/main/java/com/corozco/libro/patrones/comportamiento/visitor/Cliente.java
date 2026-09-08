package com.corozco.libro.patrones.comportamiento.visitor;

import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.Tarjeta;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaBasica;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaBlack;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaGold;
import com.corozco.libro.patrones.comportamiento.visitor.abstraccion.implementacion.TarjetaPlatino;
import com.corozco.libro.patrones.comportamiento.visitor.visitante.concreto.VisitanteCoutaManejo;
import com.corozco.libro.patrones.comportamiento.visitor.visitante.concreto.VisitanteMillas;

public class Cliente {
    public static void main(String[] args) {

        //Crea tarjetas y visitantes
        final Tarjeta basica = new TarjetaBasica();
        final Tarjeta gold = new TarjetaGold();
        final Tarjeta platino = new TarjetaPlatino();
        final Tarjeta black = new TarjetaBlack();

        //Crea los visitantes
        final VisitanteCoutaManejo coutaManejo = new VisitanteCoutaManejo();
        final VisitanteMillas millas = new VisitanteMillas();

        // Realiza compras en el mes con cada tarjeta
        realizarCompras(1, basica, coutaManejo, millas);
        realizarCompras(3, gold, coutaManejo, millas);
        realizarCompras(5, platino, coutaManejo, millas);
        realizarCompras(7, black, coutaManejo, millas);
    }

    private static void realizarCompras(final int n, Tarjeta tarjeta, final VisitanteCoutaManejo coutaManejo, final VisitanteMillas millas) {
        System.out.println(tarjeta.getClass().getSimpleName());
        System.out.printf("\t%d Compras en el mes { ", n);

        for (int i = 0; i < n; i++) {
            int pago = (int) (Math.random() * (100000 - 10000)) + 10000;
            System.out.print(pago + " ");
            tarjeta.comprar(coutaManejo, millas, pago);
        }

        System.out.println("}");
        System.out.println("\tultimoPago: " + tarjeta.getUltimoPago() + "; " + "totalPagos: " + tarjeta.getTotalPagos());
        System.out.println("\tinterés: " + tarjeta.getInteresAcumulado() + "; " + "millas: " + tarjeta.getMillasAcumuladas());

    }
}
