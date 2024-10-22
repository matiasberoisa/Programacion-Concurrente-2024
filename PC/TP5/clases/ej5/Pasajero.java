package TP5.clases.ej5;

public class Pasajero implements Runnable {
    private int nombre;
    private Boleteria laBoleteria;
    private Tren elTren;

    public Pasajero(int nn, Boleteria laBole, Tren elT) {
        this.nombre = nn;
        laBoleteria = laBole;
        elTren = elT;
    }

    public void run() {
        laBoleteria.ponerseEnLaFila();
        System.out.println("el pasajero " + this.nombre + " hace la fila para comprar el boleto");
        laBoleteria.comprarTicket();
        System.out.println("avanza el pasajero " + this.nombre);
        System.out.println("compra el boleto n° " + laBoleteria.numeroTicket());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        laBoleteria.dejarFila();
        elTren.subirse();
        System.out.println("el pasajero " + this.nombre + " se sube al tren");
        elTren.esperarViaje();
        System.out.println("el pasajero " + this.nombre + " se baja al tren");
        elTren.bajarse();
    }
}
