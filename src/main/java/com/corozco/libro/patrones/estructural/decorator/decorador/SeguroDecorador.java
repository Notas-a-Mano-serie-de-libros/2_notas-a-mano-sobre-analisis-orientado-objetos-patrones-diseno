package com.corozco.libro.patrones.estructural.decorator.decorador;

import com.corozco.libro.patrones.estructural.decorator.dominio.Seguro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SeguroDecorador extends Seguro {

    private Seguro seguro;
}
