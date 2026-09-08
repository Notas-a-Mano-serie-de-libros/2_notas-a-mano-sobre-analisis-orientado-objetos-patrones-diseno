package com.corozco.libro.patrones.estructural.flyweight;

import com.corozco.libro.patrones.estructural.flyweight.dominio.Smartphone;
import com.corozco.libro.patrones.estructural.flyweight.dominio.SmartphoneLigero;
import com.corozco.libro.patrones.estructural.flyweight.fabrica.FabricaSmartphone;

public class Cliente {
    public static void main(String[] args) {
        flyweight_sin_patron();
        flyweight_con_patron();
    }

    public static void flyweight_sin_patron() {
        System.out.println("Objeto completo");

        final Smartphone iphone = new Smartphone("1", "8GB", "500GB", 8000);
        System.out.println("\t" + iphone);

        final Smartphone samsungS22 = new Smartphone("2", "8GB", "256GB", 6500);
        System.out.println("\t" + samsungS22);

        final Smartphone xiaomi = new Smartphone("3", "8GB", "128GB", 1800);
        System.out.println("\t" + xiaomi);

        float descuentoSamsungC22 = samsungS22.aplicarDescuento(20);
        float descuentoXiaomi = xiaomi.aplicarDescuento(15);

        System.out.println("\n\tCosto con descuento por temporada");
        System.out.println("\t\tSamsungS22 -> Costo original: " + samsungS22.getCosto() + "; Costo con descuento: " + descuentoSamsungC22);
        System.out.println("\t\tXiaomi -> Costo original: " + xiaomi.getCosto() + "; Costo con descuento: " + descuentoXiaomi);
    }

    public static void flyweight_con_patron() {
        System.out.println("Objeto ligero");

        final SmartphoneLigero iphone12 = FabricaSmartphone.crear("1", "8GB",
                "500GB", 10000);
        final SmartphoneLigero samsungS21 = FabricaSmartphone.crear("2", "8GB",
                "500GB", 7000);
        final SmartphoneLigero xiaomi24 = FabricaSmartphone.crear("3", "4GB",
                "256GB", 5500);

        System.out.println("\t" + iphone12 + "\n");
        System.out.println("\t" + samsungS21 + "\n");
        System.out.println("\t" + xiaomi24 + "\n");

        float descuentoIphone12 = iphone12.getHardware().aplicarDescuento(50);
        float descuentoXiaomiX = xiaomi24.getHardware().aplicarDescuento(25);

        System.out.println("\tCosto con descuento por temporada");
        System.out.println("\t\tIphone12 -> Costo original: "
                + iphone12.getHardware().getCosto() + "; Costo con descuento: "
                + descuentoIphone12);
        System.out.println("\t\tXiaomi24 -> Costo original: "
                + xiaomi24.getHardware().getCosto() + "; Costo con descuento: "
                + descuentoXiaomiX);
    }
}
