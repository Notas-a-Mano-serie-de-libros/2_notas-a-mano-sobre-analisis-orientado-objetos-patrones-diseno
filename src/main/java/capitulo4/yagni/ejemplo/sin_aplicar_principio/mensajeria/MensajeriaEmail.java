package capitulo4.yagni.ejemplo.sin_aplicar_principio.mensajeria;


import capitulo4.yagni.ejemplo.sin_aplicar_principio.Nota;

// Clase MensajeriaEmail
public class MensajeriaEmail implements ServicioMensajeria {
    @Override
    public void compartirNota(Nota nota) {
        System.out.println("Compartiendo nota por correo electrónico: " + nota.getContenido());
    }
}
