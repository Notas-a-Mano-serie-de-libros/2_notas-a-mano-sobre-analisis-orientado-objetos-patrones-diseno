package capitulo7.mediator.colega;

import capitulo7.mediator.mediador.Mediador;
import capitulo7.mediator.modelo.General;
import lombok.Data;

@Data
public abstract class Colega<T extends General> {

    private Mediador<T> mediador;
    private String id;
    private T colega;
    private String label;

    public Colega(final Mediador<T> mediador, final T colega, final String label) {
        this.mediador = mediador;
        this.colega = colega;
        this.id = colega.getId();
        this.label = label;
    }

    public abstract void enviarMensaje(String msg, String id);

    public abstract void recibirMensaje(String msg);
}
