package com.corozco.libro.buenas_practicas.grasp.experto_informacion.ejemplo_inventario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Producto {
    private final String codigo;
    private final double precio;
}
