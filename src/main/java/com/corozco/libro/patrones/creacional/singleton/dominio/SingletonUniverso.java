package com.corozco.libro.patrones.creacional.singleton.dominio;

import lombok.Getter;

public final class SingletonUniverso implements Cloneable {

    private static SingletonUniverso universo;
    @Getter
    private long id;

    private SingletonUniverso() { // Constructor privado

    }

    public static SingletonUniverso getInstancia(long id) {
        if (null == universo) {
            System.out.println("Big Bang\n");
            universo = new SingletonUniverso();
            universo.id = id;
        }
        return universo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}