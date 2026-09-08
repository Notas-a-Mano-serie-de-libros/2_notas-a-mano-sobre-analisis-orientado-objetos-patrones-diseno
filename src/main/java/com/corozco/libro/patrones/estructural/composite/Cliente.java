package com.corozco.libro.patrones.estructural.composite;

import com.corozco.libro.patrones.estructural.composite.archivo.ArchivoSimple;
import com.corozco.libro.patrones.estructural.composite.archivo.Carpeta;

public class Cliente {

    public static void main(String[] args) {
        final Carpeta root = new Carpeta("root");

        final Carpeta imagenes = new Carpeta("imagenes");
        imagenes.add(new ArchivoSimple("paisaje", "png"));
        imagenes.add(new ArchivoSimple("wallpaper", "jpg"));

        final Carpeta documentos = new Carpeta("documentos");
        final Carpeta otros = new Carpeta("otros");

        root.add(new ArchivoSimple("README", "md"));

        root.add(imagenes);
        root.add(documentos);
        root.add(otros);

        System.out.println(root.info());
    }
}
