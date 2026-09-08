package com.corozco.libro.buenas_practicas.dry.dry_codigo;

import java.util.Arrays;

public class UtilidadRefactorizada {
    public static double getPromedio(double... args) {
        return Arrays.stream(args).average().getAsDouble();
    }
}
