package com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.exporte;

import com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.Nota;

public class ExportePDF implements ServicioExporte {
    @Override
    public void exportarNota(Nota nota) {
        System.out.println("Exportando nota a PDF: " + nota.getContenido());
    }
}