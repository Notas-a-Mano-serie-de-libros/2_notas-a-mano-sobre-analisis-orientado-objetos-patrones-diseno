package com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo;

import com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo.entidad.Persona;
import com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo.entidad.Producto;

public class Cliente {

    public static void main(String[] args) {
        Persona luisa = new Persona("Luisa", "2345", "1062");
        Producto producto = new Producto("Producto", "p1");

        EntidadDAO<Persona> daoPersona = new EntidadDAO<>();
        EntidadDAO<Producto> daoProducto = new EntidadDAO<>();

        daoPersona.guardar(luisa);
        daoPersona.editar(luisa.getId());
        daoProducto.guardar(producto);
        daoProducto.eliminar(producto.getId());
    }
}
