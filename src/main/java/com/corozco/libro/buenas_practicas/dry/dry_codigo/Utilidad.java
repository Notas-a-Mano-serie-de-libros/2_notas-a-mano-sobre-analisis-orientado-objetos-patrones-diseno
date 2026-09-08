package com.corozco.libro.buenas_practicas.dry.dry_codigo;

public class Utilidad {

    public double getPromedioCalificaciones(double nota1, double nota2) {
        return (nota1 + nota2) / 2;
    }

    public double getPromedioVentas(double venta1, double venta2, double venta3) {
        return (venta1 + venta2 + venta3) / 3;
    }

    public double getPromedioEdades(double edad1, double edad2, double edad3, double edad4) {
        return (edad1 + edad2 + edad3 + edad4) / 4;
    }
}
