package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.sin_aplicar_principio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Factura {

    private String contenido;

    public void imprimir() {
        System.out.println("Imprime factura: " + contenido);
    }

    public void exportarPDF() {
        System.out.println("Exporta a PDF: " + contenido);
    }

    public void exportarTextoPlano() {
        System.out.println("Exporta a texto plano: " + contenido);
    }

    public void exportarXLS() {
        System.out.println("Exporta a XLS: " + contenido);
    }
}
