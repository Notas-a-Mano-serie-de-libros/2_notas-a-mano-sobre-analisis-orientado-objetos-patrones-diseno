package com.corozco.libro.buenas_practicas.dry.dry_proceso;

public class Utilidad {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n no puede ser negativo");
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}