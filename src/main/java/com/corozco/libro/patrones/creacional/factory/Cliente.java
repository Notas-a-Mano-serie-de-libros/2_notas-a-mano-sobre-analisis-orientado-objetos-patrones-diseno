package com.corozco.libro.patrones.creacional.factory;

import com.corozco.libro.patrones.creacional.factory.con_patron.creador.ICifradoCreador;
import com.corozco.libro.patrones.creacional.factory.con_patron.creador.implementacion.PS256Creador;
import com.corozco.libro.patrones.creacional.factory.con_patron.creador.implementacion.PS512Creador;
import com.corozco.libro.patrones.creacional.factory.con_patron.creador.implementacion.RS256Creador;
import com.corozco.libro.patrones.creacional.factory.con_patron.creador.implementacion.RS512Creador;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.IAlgoritmoCifrado;
import com.corozco.libro.patrones.creacional.factory.sin_patron.Algoritmo;
import com.corozco.libro.patrones.creacional.factory.sin_patron.FabricaCifrado;

public class Cliente {
    public static void main(String[] args) {
        factory_sin_patron();
        factory_patron();
    }

    public static void factory_sin_patron() {
        System.out.println("Factory sin patrón");
        final FabricaCifrado fabrica = new FabricaCifrado();

        final IAlgoritmoCifrado ps256 = fabrica.getAlgoritmo(Algoritmo.PS256);
        final IAlgoritmoCifrado rs256 = fabrica.getAlgoritmo(Algoritmo.RS256);
        final IAlgoritmoCifrado ps512 = fabrica.getAlgoritmo(Algoritmo.PS512);

        ps256.cifrar("datos");
        ps256.descifrar("datos cifrados");
        rs256.cifrar("datos");
        rs256.descifrar("datos cifrados");
        ps512.cifrar("datos");
        ps512.descifrar("datos cifrados");
    }

    public static void factory_patron() {

        System.out.println("Factory con patron");

        final ICifradoCreador ps256Creador = new PS256Creador();
        final IAlgoritmoCifrado ps256 = ps256Creador.getAlgoritmo();
        ps256.cifrar("datos");
        ps256.descifrar("datos cifrados");

        final ICifradoCreador ps512Creador = new PS512Creador();
        final IAlgoritmoCifrado ps512 = ps512Creador.getAlgoritmo();
        ps512.cifrar("datos");
        ps512.descifrar("datos cifrados");

        final ICifradoCreador rs256Creador = new RS256Creador();
        final IAlgoritmoCifrado rs256 = rs256Creador.getAlgoritmo();
        rs256.cifrar("datos");
        rs256.descifrar("datos cifrados");

        // Nuevo algoritmo
        final ICifradoCreador rs512Creador = new RS512Creador();
        final IAlgoritmoCifrado rs512 = rs512Creador.getAlgoritmo();
        rs512.cifrar("datos");
        rs512.descifrar("datos cifrados");
    }
}
