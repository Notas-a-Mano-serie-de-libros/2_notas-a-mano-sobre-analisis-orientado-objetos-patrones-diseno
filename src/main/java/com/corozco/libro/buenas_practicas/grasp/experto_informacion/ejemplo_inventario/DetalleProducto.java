package com.corozco.libro.buenas_practicas.grasp.experto_informacion.ejemplo_inventario;

import lombok.Getter;

@Getter
public class DetalleProducto {

    private final Producto producto;
    private final int cantidad;
    private final double costoTotalProducto;

    public DetalleProducto(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoTotalProducto = producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "Código producto: " + this.producto.getCodigo()
                + "; Cantidad: " + this.cantidad
                + "; costo total unitario: " + this.costoTotalProducto;
    }
}
