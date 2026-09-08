package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte;

import com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.Factura;

public class ReporteTextoPlano implements Reporte {
    @Override
    public void exportar(Factura factura) {
        System.out.println("Exporta a texto plano: " + factura.getContenido());
    }
}
