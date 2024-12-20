package TP5.Test;

import TP5.clases.ej5.*;

public class TestTren {
    public static void main(String[] args) {
        Boleteria laBoleteria = new Boleteria();
        Tren unTren = new Tren(5);
        int i = 1;
        Thread hiloVendedor = new Thread(new VendedorTicket(laBoleteria));
        Thread hiloControl = new Thread(new ControlTren(unTren));
        hiloVendedor.start();
        hiloControl.start();
        while (i <= 20) {
            Thread hiloPasajero = new Thread(new Pasajero(i, laBoleteria, unTren));
            hiloPasajero.start();
            i++;
        }
    }
}
