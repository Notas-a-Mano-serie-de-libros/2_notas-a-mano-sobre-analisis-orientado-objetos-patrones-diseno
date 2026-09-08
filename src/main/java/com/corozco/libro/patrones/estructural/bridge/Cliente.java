package com.corozco.libro.patrones.estructural.bridge;

import com.corozco.libro.patrones.estructural.bridge.arquitectura.Arquitectura;
import com.corozco.libro.patrones.estructural.bridge.arquitectura.ArquitecturaX32;
import com.corozco.libro.patrones.estructural.bridge.arquitectura.ArquitecturaX64;
import com.corozco.libro.patrones.estructural.bridge.sistema_operativo.Linux;
import com.corozco.libro.patrones.estructural.bridge.sistema_operativo.SistemaOperativo;
import com.corozco.libro.patrones.estructural.bridge.sistema_operativo.Windows;

public class Cliente {
    public static void main(String[] args) {

        final Arquitectura x32 = new ArquitecturaX32("x32", "Arquitectura de 32-bits");
        final Arquitectura x64 = new ArquitecturaX64("x64", "Arquitectura de 64-bits");

        final SistemaOperativo windows7 = new Windows("Windows 7", "1", x32);
        final SistemaOperativo windows10 = new Linux("Windows 10", "1", x64);
        final SistemaOperativo ubuntu = new Linux("Ubuntu 22.04", "rls", x32);
        final SistemaOperativo mint = new Linux("Mint", "latest-version", x64);

        System.out.println(windows7 + "\n" + windows10);
        System.out.println(ubuntu + "\n" + mint);
    }
}
