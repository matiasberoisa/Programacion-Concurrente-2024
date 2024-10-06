package PC.TP5.Test;

import PC.TP5.clases.ej5.*;

public class TestTren {
    public static void main(String[] args) {
        Boleteria laBoleteria = new Boleteria();
        Tren unTren = new Tren(10);
        Thread hiloVendedor = new Thread(new VendedorTicket(laBoleteria));
        Thread hiloControl = new Thread(new ControlTren(unTren));
        hiloVendedor.start();
        hiloControl.start();
        while (true) {
            Thread hiloPasajero = new Thread(new Pasajero(laBoleteria, unTren));
            hiloPasajero.start();
        }
    }
}
