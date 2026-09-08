package com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.exporte;

import com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.Nota;

public class ExporteImagen implements ServicioExporte {
    @Override
    public void exportarNota(Nota nota) {
        System.out.println("Exportando nota a imagen: " + nota.getContenido());
    }
}
