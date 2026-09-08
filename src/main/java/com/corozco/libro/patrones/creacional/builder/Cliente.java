package com.corozco.libro.patrones.creacional.builder;

import com.corozco.libro.patrones.creacional.builder.constructor.GalaxiaBuilder;
import com.corozco.libro.patrones.creacional.builder.constructor.GalaxiaBuilderImplicito;
import com.corozco.libro.patrones.creacional.builder.constructor.UniversoBuilder;
import com.corozco.libro.patrones.creacional.builder.modelo.Galaxia;
import com.corozco.libro.patrones.creacional.builder.modelo.GalaxiaConConstructores;
import com.corozco.libro.patrones.creacional.builder.modelo.Universo;

import java.util.Arrays;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {

        // Galaxias con constructores (engorroso)
        final Galaxia galaxia1 = new GalaxiaConConstructores(1, "G001");
        final Galaxia galaxia2 = new GalaxiaConConstructores(2, "G002", 1000);
        final Galaxia galaxia3 = new GalaxiaConConstructores(3, "G003", 2000,
                "ESPIRAL", "GRUPO LOCAL");

        // Galaxia fijando los valores uno por uno (código espagueti)
        final Galaxia galaxia4 = new Galaxia();
        galaxia4.setId(5);
        galaxia4.setCodigo("G005");
        galaxia4.setMasa(5000);
        galaxia4.setGrupo("GRUPO LOCAL");

        final List<Galaxia> galaxias = Arrays.asList(galaxia1, galaxia2, galaxia3, galaxia4);

        // Universo tiene builder
        final Universo universo1 = new UniversoBuilder(1, "Universo 1").pMateriaBarionica(100).build();
        final Universo universo2 = new UniversoBuilder(2, "Universo 2").galaxias(galaxias).build();
        System.out.println(universo1 + "\n" + universo2);

        // Galaxia creada con builder
        final Galaxia galaxia5 = new GalaxiaBuilder(6, "G006").masa(1000).tipo("ESPIRAL").grupo("GRUPO DE SAGITARIO").build();

        // Galaxia con builder implícito
        final Galaxia galaxia6 = GalaxiaBuilderImplicito.builder(6, "G006").masa(6000).tipo("ELIPTICA").build();

        // Otro Universo con builder
        final Universo universo3 = new UniversoBuilder(3, "Universo 3")
                .pMateriaBarionica(0).pMateriaOscura(25).pEnergiaOscura(75)
                .galaxias(Arrays.asList(galaxia5, galaxia6))
                .build();

        System.out.println(universo3);
    }
}
