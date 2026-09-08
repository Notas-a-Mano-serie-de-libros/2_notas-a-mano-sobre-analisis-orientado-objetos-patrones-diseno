package com.corozco.libro.patrones.creacional.factory.con_patron.creador.implementacion;

import com.corozco.libro.patrones.creacional.factory.con_patron.creador.ICifradoCreador;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.IAlgoritmoCifrado;
import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.implementacion.AlgoritmoPS512;

public class PS512Creador implements ICifradoCreador {

    @Override
    public IAlgoritmoCifrado getAlgoritmo() {
        return new AlgoritmoPS512();
    }
}
