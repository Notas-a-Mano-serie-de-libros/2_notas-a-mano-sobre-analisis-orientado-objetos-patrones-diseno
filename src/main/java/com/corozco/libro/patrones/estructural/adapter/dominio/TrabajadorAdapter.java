package com.corozco.libro.patrones.estructural.adapter.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TrabajadorAdapter implements IEmpleado {

    private Trabajador trabajador;

    @Override
    public String getDocumento() {
        return String.valueOf((int) trabajador.getId());
    }

    @Override
    public String getNombreCompleto() {
        return trabajador.getPNombre() + (null != trabajador.getSNombre() ? " " + trabajador.getSNombre() : "") + trabajador.getPApellido() + (null != trabajador.getSApellido() ? " " + trabajador.getSApellido() : "");
    }

    @Override
    public String getTelefono() {
        return null != trabajador.getContacto() ? "+" + trabajador.getIndicador() + trabajador.getContacto() : "NA";
    }

    @Override
    public String toString() {
        return "TrabajadorAdapter(documento=" + this.getDocumento() + ", nombreCompleto=" + this.getNombreCompleto() + ", telefono=" + this.getTelefono() + ")";
    }
}
