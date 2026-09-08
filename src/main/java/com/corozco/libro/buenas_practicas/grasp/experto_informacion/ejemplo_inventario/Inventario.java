package com.corozco.libro.buenas_practicas.grasp.experto_informacion.ejemplo_inventario;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Inventario {

    private List<DetalleProducto> registros = new ArrayList<>();
    private double total = 0;

    public void agregarProducto(String codigo, double precio, int cantidad) {
        Producto producto = new Producto(codigo, precio);
        DetalleProducto detalle = new DetalleProducto(producto, cantidad);
        registros.add(detalle);
        this.total += detalle.getCostoTotalProducto();
    }

    public void getInfo() {
        registros.forEach(
                detalleProducto -> {
                    System.out.println(detalleProducto.toString());
                }
        );

    }
}