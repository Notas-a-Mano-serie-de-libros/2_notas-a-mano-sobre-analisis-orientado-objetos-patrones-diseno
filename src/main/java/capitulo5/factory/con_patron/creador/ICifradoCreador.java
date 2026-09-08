package capitulo5.factory.con_patron.creador;

import capitulo5.factory.con_patron.dominio.IAlgoritmoCifrado;

public interface ICifradoCreador {

    IAlgoritmoCifrado getAlgoritmo();
}
