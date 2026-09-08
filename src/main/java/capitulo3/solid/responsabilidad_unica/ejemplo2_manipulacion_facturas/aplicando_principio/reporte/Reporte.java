package capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte;

import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.Factura;

public interface Reporte {
    void exportar(Factura factura);
}