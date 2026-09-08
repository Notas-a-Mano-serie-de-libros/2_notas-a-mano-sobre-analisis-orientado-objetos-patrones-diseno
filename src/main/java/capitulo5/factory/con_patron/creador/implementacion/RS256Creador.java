package capitulo5.factory.con_patron.creador.implementacion;

import capitulo5.factory.con_patron.creador.ICifradoCreador;
import capitulo5.factory.con_patron.dominio.IAlgoritmoCifrado;
import capitulo5.factory.con_patron.dominio.implementacion.AlgoritmoRS256;

public class RS256Creador implements ICifradoCreador {

    @Override
    public IAlgoritmoCifrado getAlgoritmo() {
        return new AlgoritmoRS256();
    }
}
