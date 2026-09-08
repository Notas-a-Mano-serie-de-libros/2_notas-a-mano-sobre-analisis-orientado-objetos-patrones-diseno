package com.corozco.libro.patrones.comportamiento.command.receptor;

public abstract class BaseDatos {
    public abstract void consultar(String sql);
}
