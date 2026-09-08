package com.corozco.libro.patrones.creacional.singleton;

import com.corozco.libro.patrones.creacional.singleton.dominio.SingletonUniverso;

public class Cliente {

    public static void main(String[] args) {

        System.out.println();
        singleton();

        System.out.println();
        singleton_break();

        singleton_error();
    }

    public static void singleton_error() {
        // final SingletonUniverso singletonUniverso = new SingletonUniverso();
    }

    public static void singleton() {
        SingletonUniverso universo = SingletonUniverso.getInstancia(1L);
        SingletonUniverso universo2 = SingletonUniverso.getInstancia(2L);

        System.out.println("Referencia Universo: " + universo.hashCode());
        System.out.println("Referencia Universo2: " + universo2.hashCode());
        System.out.println("Referencias iguales: " + (universo.hashCode() == universo2.hashCode()));
    }

    public static void singleton_break() {
        try {
            SingletonUniverso universo = SingletonUniverso.getInstancia(1);
            SingletonUniverso universo2 = (SingletonUniverso) universo.clone();

            System.out.println("Referencia Universo: " + universo.hashCode());
            System.out.println("Referencia otro Universo: " + universo2.hashCode());
            System.out.println("Referencias iguales: " + (universo.hashCode() == universo2.hashCode()));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
