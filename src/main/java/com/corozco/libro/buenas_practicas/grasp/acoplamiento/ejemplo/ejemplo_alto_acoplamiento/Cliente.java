package com.corozco.libro.buenas_practicas.grasp.acoplamiento.ejemplo.ejemplo_alto_acoplamiento;

public class Cliente {
    public static void main(String[] args) {
        ServicioNotificacion manager = new ServicioNotificacion();
        manager.notificar("Hola mundo por mail", TipoServicio.EMAIL);
        manager.notificar("Hola mundo por mensaje SMS", TipoServicio.SMS);
        manager.notificar("Hola mundo como alerta push", TipoServicio.PUSH);
    }
}
