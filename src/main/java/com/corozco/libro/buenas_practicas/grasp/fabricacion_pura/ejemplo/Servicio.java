package com.corozco.libro.buenas_practicas.grasp.fabricacion_pura.ejemplo;

public class Servicio {
    private Logger logger = new Logger();

    public void realizarOperacion() {
        logger.info("Operación realizada");
    }
}
