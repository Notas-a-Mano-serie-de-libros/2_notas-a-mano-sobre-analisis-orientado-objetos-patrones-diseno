package com.corozco.libro.patrones.creacional.factory.con_patron.creador;

import com.corozco.libro.patrones.creacional.factory.con_patron.dominio.IAlgoritmoCifrado;

public interface ICifradoCreador {

    IAlgoritmoCifrado getAlgoritmo();
}
