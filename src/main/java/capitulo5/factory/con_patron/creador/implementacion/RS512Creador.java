package capitulo5.factory.con_patron.creador.implementacion;

import capitulo5.factory.con_patron.creador.ICifradoCreador;
import capitulo5.factory.con_patron.dominio.IAlgoritmoCifrado;
import capitulo5.factory.con_patron.dominio.implementacion.AlgoritmoRS512;

public class RS512Creador implements ICifradoCreador {

    @Override
    public IAlgoritmoCifrado getAlgoritmo() {
        return new AlgoritmoRS512();
    }
}
