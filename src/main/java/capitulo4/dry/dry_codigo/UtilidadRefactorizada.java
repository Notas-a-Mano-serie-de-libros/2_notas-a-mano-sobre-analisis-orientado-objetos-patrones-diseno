package capitulo4.dry.dry_codigo;

import java.util.Arrays;

public class UtilidadRefactorizada {
    public static double getPromedio(double... args) {
        return Arrays.stream(args).average().getAsDouble();
    }
}
