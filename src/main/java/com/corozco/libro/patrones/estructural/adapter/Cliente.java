package com.corozco.libro.patrones.estructural.adapter;

import com.corozco.libro.patrones.estructural.adapter.dominio.Empleado;
import com.corozco.libro.patrones.estructural.adapter.dominio.IEmpleado;
import com.corozco.libro.patrones.estructural.adapter.dominio.Trabajador;
import com.corozco.libro.patrones.estructural.adapter.dominio.TrabajadorAdapter;

public class Cliente {
    public static void main(String[] args) {
        final IEmpleado empleadoA = new Empleado("11", "Pedro Perez", "+1234");
        final IEmpleado empleadoB = new Empleado("22", "Carlos López", "+5678");
        final IEmpleado empleadoC = new Empleado("33", "Cesar García", "+7890");
        final IEmpleado empleadoD = new Empleado("44", "Andrea Díaz", "+1252");

        System.out.println("Empleados");
        System.out.println("\t" + empleadoA);
        System.out.println("\t" + empleadoB);
        System.out.println("\t" + empleadoC);
        System.out.println("\t" + empleadoD);

        System.out.println("Trabajador adaptado");
        final IEmpleado empleadoE = new TrabajadorAdapter(
                new Trabajador(55, "Luisa", "", "Ramirez", null, 6789L, 57));
        System.out.println("\t" + empleadoE);
    }
}
