package com.corozco.libro.patrones.estructural.decorator;

import com.codepoetics.protonpack.StreamUtils;
import com.corozco.libro.patrones.estructural.decorator.decorador.SeguroDecorador;
import com.corozco.libro.patrones.estructural.decorator.decorador.decorador_concreto.SeguroAccidente;
import com.corozco.libro.patrones.estructural.decorator.decorador.decorador_concreto.SeguroDefuncion;
import com.corozco.libro.patrones.estructural.decorator.decorador.decorador_concreto.SeguroIncapacidad;
import com.corozco.libro.patrones.estructural.decorator.dominio.Seguro;
import com.corozco.libro.patrones.estructural.decorator.dominio.SeguroBasico;

import java.util.Arrays;
import java.util.List;

public class Cliente {

    // Lista de etiquetas para imprimir los datos de cada seguro
    private static List<String> labels = Arrays.asList("base", "accidente",
            "incapacidad", "defuncion");

    public static void main(String[] args) {
        final Seguro seguro = new SeguroBasico("Seguro empresa X", 1000, false);

        final SeguroDecorador accidente = new SeguroAccidente(seguro);
        final SeguroDecorador incapacidad = new SeguroIncapacidad(seguro);
        final SeguroDecorador defuncion = new SeguroDefuncion(seguro);

        final List<Seguro> segurosConcretos = Arrays.asList(seguro, accidente,
                incapacidad, defuncion);

        System.out.println("Empresa X");
        printValor(segurosConcretos);
    }

    private static void printValor(final List<Seguro> seguros) {
        StreamUtils.zip(seguros.stream(), labels.stream(),
                (seguro, label) -> " \tCosto seguro " + label + ": "
                        + seguro.getValor()).forEach(System.out::println);
    }
}
