package com.corozco.libro.buenas_practicas.grasp.fabricacion_pura.ejemplo;

public class Logger {

    public void info(String msg) {
        System.out.println("Info: " + msg);
    }

    public void debug(String msg) {
        System.out.println("Debug: " + msg);
    }

    public void error(String msg) {
        System.out.println("Error: " + msg);
    }
}
