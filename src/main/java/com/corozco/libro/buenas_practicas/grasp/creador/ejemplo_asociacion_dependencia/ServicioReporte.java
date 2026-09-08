package com.corozco.libro.buenas_practicas.grasp.creador.ejemplo_asociacion_dependencia;

public class ServicioReporte {

    public Reporte generarReporteVentas(float ventasTotales, float ventasMes) {
        Reporte reporte = new Reporte();
        reporte.agregarContenido("\nReporte de Ventas\n");
        reporte.agregarContenido("Ventas totales: " + ventasTotales +"\n");
        reporte.agregarContenido("Ventas del mes: " + ventasMes +"\n");
        reporte.agregarContenido("Ventas del Día: " + ventasMes/30 +"\n");
        return reporte;
    }
}