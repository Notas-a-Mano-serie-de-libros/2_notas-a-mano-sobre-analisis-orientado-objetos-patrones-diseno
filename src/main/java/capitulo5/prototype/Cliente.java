package capitulo5.prototype;

import capitulo5.prototype.oveja.IOvejaPrototipo;
import capitulo5.prototype.oveja.OvejaImpl;

public class Cliente {
    public static void main(String[] args) throws CloneNotSupportedException {

        final IOvejaPrototipo original = new OvejaImpl(1L, "original");
        final IOvejaPrototipo dolly = original.clonar();

        System.out.println("Información original");
        System.out.println("\toveja: " + original + "\n\tclon:  " + dolly);

        dolly.setId(2L);
        dolly.setNombre("Dolly");

        System.out.println("Información modificada");
        System.out.println("\toveja: " + original + "\n\tclon:  " + dolly);

        System.out.println("\nOvejas iguales: " + (original.equals(dolly) ? "En efecto" : "Soy un clon"));
        System.out.println("Referencia oveja original: " + original.hashCode());
        System.out.println("Referencia Dolly: " + dolly.hashCode());
        System.out.println("Referencias iguales: " + (original.hashCode() == dolly.hashCode()));
    }
}
