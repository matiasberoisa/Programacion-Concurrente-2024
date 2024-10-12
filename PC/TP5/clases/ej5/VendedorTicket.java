package TP5.clases.ej5;

public class VendedorTicket implements Runnable {
    private Boleteria laBoleteria;

    public VendedorTicket(Boleteria laBole) {
        laBoleteria = laBole;
    }

    public void run() {
        System.out.println("el vendedor comienza a trabajar");
        while (true) {
            laBoleteria.venderTicket();

        }
    }
}
