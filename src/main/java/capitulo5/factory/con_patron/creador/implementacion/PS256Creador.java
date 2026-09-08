package capitulo5.factory.con_patron.creador.implementacion;

import capitulo5.factory.con_patron.creador.ICifradoCreador;
import capitulo5.factory.con_patron.dominio.IAlgoritmoCifrado;
import capitulo5.factory.con_patron.dominio.implementacion.AlgoritmoPS256;

public class PS256Creador implements ICifradoCreador {

    @Override
    public IAlgoritmoCifrado getAlgoritmo() {
        return new AlgoritmoPS256();
    }
}
