package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte;

import com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.Factura;

public interface Reporte {
    void exportar(Factura factura);
}