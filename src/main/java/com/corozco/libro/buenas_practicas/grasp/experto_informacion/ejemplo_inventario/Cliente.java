package com.corozco.libro.buenas_practicas.grasp.experto_informacion.ejemplo_inventario;

public class Cliente {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregarProducto("Producto 1", 1000.0, 3);
        inventario.agregarProducto("Producto 2", 2000.0, 5);

        inventario.getInfo();
    }
}
