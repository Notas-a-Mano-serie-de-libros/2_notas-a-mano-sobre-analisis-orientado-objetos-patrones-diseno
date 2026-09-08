package com.corozco.libro.patrones.comportamiento.cadena_responsabilidad;

import com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.cadena.SolicitudCredito;
import com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.manejadores.Asesor;
import com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.manejadores.EvaluadorDirectivo;
import com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.manejadores.EvaluadorJudicial;
import com.corozco.libro.patrones.comportamiento.cadena_responsabilidad.manejadores.EvaluadorRiesgo;

public class Cliente {
    public static void main(String[] args) {

        // Inicializa los objetos de la cadena de responsabilidad
        final SolicitudCredito asesor = new Asesor();
        final SolicitudCredito evaluadorRiesgo = new EvaluadorRiesgo();
        final SolicitudCredito evaluadorJudicial = new EvaluadorJudicial();
        final SolicitudCredito evaluadorDirectivo = new EvaluadorDirectivo();

        // Crea la cadena de responsabilidad
        asesor.setSiguiente(evaluadorRiesgo);
        evaluadorRiesgo.setSiguiente(evaluadorJudicial);
        evaluadorJudicial.setSiguiente(evaluadorDirectivo);

        System.out.print("Solicitud por 100000: ");
        asesor.solicitar(100000);
        System.out.print("Solicitud por 7000000: ");
        asesor.solicitar(7000000);
        System.out.print("Solicitud por 12000000: ");
        asesor.solicitar(12000000);
        System.out.print("Solicitud por 20000000: ");
        asesor.solicitar(20000000);
    }
}
