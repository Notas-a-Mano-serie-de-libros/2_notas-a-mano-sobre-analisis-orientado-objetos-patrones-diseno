package com.corozco.libro.patrones.creacional.factory.con_patron.creador.implementacion;

import com.corozco.libro.patrones.creacional.factory.con_patron.creador.ICifradoCreador;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.IAlgoritmoCifrado;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.implementacion.AlgoritmoPS256;

public class PS256Creador implements ICifradoCreador {

    @Override
    public IAlgoritmoCifrado getAlgoritmo() {
        return new AlgoritmoPS256();
    }
}
