package com.corozco.libro.patrones.estructural.facade.abstraccion;

import com.corozco.libro.patrones.estructural.facade.subsistemas.ValidadorIntegracion;
import com.corozco.libro.patrones.estructural.facade.subsistemas.ValidadorPruebas;

public class ValidadorDespliegue implements IValidador {

    private final ValidadorIntegracion integracion = new ValidadorIntegracion();
    private final ValidadorPruebas stage = new ValidadorPruebas();

    @Override
    public void validar() {
        validarIntegracion();
        validarPruebas();
        System.out.println("Artefacto listo para paso a producción");
    }

    // Verificaciones en ambiente de integración
    private void validarIntegracion() {
        System.out.println("Integración");
        integracion.validarEstilo();
        integracion.construir();
        integracion.pruebasUnitarias();
        System.out.println("Estado: OK");
    }

    // Verificaciones en ambiente de pruebas
    private void validarPruebas() {
        System.out.println("\nStage");
        stage.pruebasEstres();
        stage.pruebasHumo();
        stage.pruebasIntegracion();
        System.out.println("Estado: OK");
    }
}
