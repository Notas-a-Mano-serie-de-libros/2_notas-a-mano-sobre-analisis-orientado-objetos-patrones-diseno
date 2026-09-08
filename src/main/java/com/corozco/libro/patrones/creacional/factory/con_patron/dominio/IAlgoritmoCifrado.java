package com.corozco.libro.patrones.creacional.factory.con_patron.dominio;

public interface IAlgoritmoCifrado {
    void cifrar(String textoPlano);

    void descifrar(String textoCifrado);
}
