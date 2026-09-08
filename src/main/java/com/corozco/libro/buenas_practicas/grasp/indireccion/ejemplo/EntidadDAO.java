package com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo;

import com.corozco.libro.buenas_practicas.grasp.indireccion.ejemplo.entidad.General;

public class EntidadDAO<T extends General> {

    public void guardar(T entidad) {
        System.out.println("Crea una entidad con id: " + entidad.getId());
    }

    public void editar(String id) {
        System.out.println("Edita la entidad con id: " + id);
    }

    public void eliminar(String id) {
        System.out.println("Elimina la entidad con id: " + id);
    }
}
