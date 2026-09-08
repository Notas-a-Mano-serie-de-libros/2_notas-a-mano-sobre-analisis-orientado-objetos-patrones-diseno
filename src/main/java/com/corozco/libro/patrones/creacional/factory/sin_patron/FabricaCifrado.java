package com.corozco.libro.patrones.creacional.factory.sin_patron;

import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.IAlgoritmoCifrado;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.implementacion.AlgoritmoPS256;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.implementacion.AlgoritmoPS512;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.implementacion.AlgoritmoRS256;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.implementacion.AlgoritmoRS512;

public class FabricaCifrado {

    public IAlgoritmoCifrado getAlgoritmo(final Algoritmo algoritmo) {
        switch (algoritmo) {
            case PS256:
                return new AlgoritmoPS256();
            case PS512:
                return new AlgoritmoPS512();
            case RS256:
                return new AlgoritmoRS256();
            case RS512:
                return new AlgoritmoRS512();
            default:
                return null;
        }

    }
}

