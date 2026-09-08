package capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio;

import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.Reporte;
import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.ReportePDF;
import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.ReporteTextoPlano;
import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.ReporteXLS;

public class Cliente {
    public static void main(String[] args) {
        Factura factura = new Factura("Hola mundo");
        Impresora impresora = new Impresora();

        impresora.imprimir(factura);

        Reporte reportePDF = new ReportePDF();
        Reporte reporteTextoPlano = new ReporteTextoPlano();
        Reporte reporteXLS = new ReporteXLS();

        reportePDF.exportar(factura);
        reporteTextoPlano.exportar(factura);
        reporteXLS.exportar(factura);
    }
}
