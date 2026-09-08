package com.corozco.libro.buenas_practicas.grasp.creador.ejemplo_asociacion_dependencia;

public class Cliente {

    public static void main(String[] args) {
        ServicioReporte servicioReporte = new ServicioReporte();
        Reporte reporte = servicioReporte.generarReporteVentas(100, 120);
    }
}
