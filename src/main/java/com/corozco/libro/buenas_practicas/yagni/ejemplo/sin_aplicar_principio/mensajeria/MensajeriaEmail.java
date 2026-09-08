package com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.mensajeria;


import com.corozco.libro.buenas_practicas.yagni.ejemplo.sin_aplicar_principio.Nota;

// Clase MensajeriaEmail
public class MensajeriaEmail implements ServicioMensajeria {
    @Override
    public void compartirNota(Nota nota) {
        System.out.println("Compartiendo nota por correo electrónico: " + nota.getContenido());
    }
}
