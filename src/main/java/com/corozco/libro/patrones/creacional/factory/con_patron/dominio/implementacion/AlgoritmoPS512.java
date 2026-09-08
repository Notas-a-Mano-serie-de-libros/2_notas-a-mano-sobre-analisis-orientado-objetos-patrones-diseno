package com.corozco.libro.patrones.creacional.factory.con_patron.dominio.implementacion;

import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.IAlgoritmoCifrado;

public class AlgoritmoPS512 implements IAlgoritmoCifrado {

    @Override
    public void cifrar(final String textoPlano) {
        System.out.println("\tCifraste el texto (" + textoPlano + ") con el algoritmo PS512");
    }

    @Override
    public void descifrar(final String textoCifrado) {
        System.out.println("\tDescifraste el texto (" + textoCifrado + ") con el algoritmo PS512");
    }
}
