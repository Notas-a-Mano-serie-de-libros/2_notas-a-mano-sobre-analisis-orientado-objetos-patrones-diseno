package capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio;

public class Impresora {
    public void imprimir(Factura factura) {
        System.out.println("Imprimiendo factura: " + factura.getContenido());
    }
}