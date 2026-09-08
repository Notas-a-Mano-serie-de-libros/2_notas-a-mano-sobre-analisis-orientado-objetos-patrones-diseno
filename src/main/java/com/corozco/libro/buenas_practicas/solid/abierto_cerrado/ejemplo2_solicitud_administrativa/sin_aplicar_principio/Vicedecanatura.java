package com.corozco.libro.buenas_practicas.solid.abierto_cerrado.ejemplo2_solicitud_administrativa.sin_aplicar_principio;

public class Vicedecanatura {

    public void realizarSolicitud(TipoSolicitud tipo) {
        switch (tipo) {
            case HOMOLOGACION:
                homologar();
                break;
            case CANCELACION:
                cancelar();
                break;
            case VALIDACION:
                validar();
                break;
            default:
                System.out.println("Tipo de solicitud incorrecto");
                break;
        }
    }

    private void homologar() {
        System.out.println("Realiza homologación");
    }

    private void cancelar() {
        System.out.println("Realiza cancelación");
    }

    private void validar() {
        System.out.println("Realiza validación");
    }

}
