package TP6.test;

import TP6.clases.ej7.*;

public class TestBarco {
    public static void main(String[] args) {
        Barco unBarco = new Barco();
        int i = 1;
        Thread hiloControl = new Thread(new ControlBarco(unBarco));
        hiloControl.start();
        while (i <= 20) {
            Thread hiloPasajero = new Thread(new Pasajero(i, unBarco));
            Thread hiloAuto = new Thread(new Auto(i, unBarco));
            hiloPasajero.start();
            hiloAuto.start();
            i++;
        }
    }
}
