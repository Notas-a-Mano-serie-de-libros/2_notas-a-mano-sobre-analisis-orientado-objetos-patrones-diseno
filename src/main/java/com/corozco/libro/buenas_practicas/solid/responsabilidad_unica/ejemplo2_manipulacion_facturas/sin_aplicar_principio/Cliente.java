package com.corozco.libro.buenas_practicas.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.sin_aplicar_principio;

public class Cliente {

    public static void main(String[] args) {
        Factura factura = new Factura("Hola mundo");
        factura.imprimir();
        factura.exportarPDF();
        factura.exportarTextoPlano();
        factura.exportarXLS();
    }
}
