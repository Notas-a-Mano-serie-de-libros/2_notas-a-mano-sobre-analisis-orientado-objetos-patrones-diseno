package capitulo6.composite.archivo;

public interface Archivo {
    String getNombre();
    String info(int nivel);

    default String info() {
        return info(0);
    }
}
