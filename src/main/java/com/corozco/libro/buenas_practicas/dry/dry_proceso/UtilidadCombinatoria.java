package com.corozco.libro.buenas_practicas.dry.dry_proceso;

public class UtilidadCombinatoria {
    public static int coeficienteBinomial(int n, int k) {
        if (k < 0 || k > n) {
            throw new IllegalArgumentException("k debe estar entre 0 y n");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n no puede ser negativo");
        }

        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
