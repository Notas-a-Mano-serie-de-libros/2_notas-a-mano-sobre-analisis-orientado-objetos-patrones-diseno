package com.corozco.libro.patrones.creacional.abstract_factory;

import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadNaval;
import com.corozco.libro.patrones.creacional.abstract_factory.dominio.UnidadTierra;
import com.corozco.libro.patrones.creacional.abstract_factory.fabrica.FabricaAbstracta;
import com.corozco.libro.patrones.creacional.abstract_factory.fabrica.concreto.FabricaEraIndustrial;
import com.corozco.libro.patrones.creacional.abstract_factory.fabrica.concreto.FabricaEraMedieval;

public class Cliente {
    public static void main(String[] args) {

        // Crea unidades específicas de la era medieval
        final FabricaAbstracta eraMedieval = new FabricaEraMedieval();
        final UnidadTierra espadachin = eraMedieval.crearUnidadTierra();
        final UnidadNaval galeon = eraMedieval.crearUnidadNaval();

        System.out.println("Era medieval");
        espadachin.atacar();
        espadachin.defender();
        galeon.navegar();
        galeon.atacar();

        // Crea unidades específicas de la era industrial
        final FabricaAbstracta eraIndustrial = new FabricaEraIndustrial();
        final UnidadTierra fusilero = eraIndustrial.crearUnidadTierra();
        final UnidadNaval buqueVapor = eraIndustrial.crearUnidadNaval();

        System.out.println("Era industrial");
        fusilero.atacar();
        fusilero.defender();
        buqueVapor.navegar();
        buqueVapor.atacar();
    }
}
