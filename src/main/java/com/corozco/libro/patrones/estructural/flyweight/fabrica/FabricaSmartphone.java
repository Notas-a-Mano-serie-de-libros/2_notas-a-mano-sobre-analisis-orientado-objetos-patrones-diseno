package com.corozco.libro.patrones.estructural.flyweight.fabrica;

import com.corozco.libro.patrones.estructural.flyweight.dominio.Hardware;
import com.corozco.libro.patrones.estructural.flyweight.dominio.SmartphoneLigero;

import java.util.HashMap;
import java.util.Map;

public class FabricaSmartphone {

    private static final Map<String, Hardware> propiedades = new HashMap<>();

    public static SmartphoneLigero crear(final String id, final String ram, final String disco, final float costo) {
        final Hardware hardware = getPropiedades(ram, disco, costo);
        return new SmartphoneLigero(id, hardware);
    }

    private static Hardware getPropiedades(final String ram, final String disco, final float costo) {
        final String key = ram + ":" + disco + ":" + costo;
        if (!propiedades.containsKey(key)) {
            System.out.println("\tSe crea una nueva instancia");
            propiedades.put(key, new Hardware(ram, disco, costo));
        } else {
            System.out.println("\tEl objeto compartido ya existe");
        }
        return propiedades.get(key);
    }
}
