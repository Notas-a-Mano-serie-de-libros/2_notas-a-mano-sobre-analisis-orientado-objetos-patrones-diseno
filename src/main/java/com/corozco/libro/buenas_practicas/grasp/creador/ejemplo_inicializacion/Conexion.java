package com.corozco.libro.buenas_practicas.grasp.creador.ejemplo_inicializacion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Conexion {
    private String host;
    private String usuario;
    private String contrasena;
}