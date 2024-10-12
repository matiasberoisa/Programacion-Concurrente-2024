package TP5.clases.ej5;

import java.util.Random;
import java.util.UUID;

public class Pasajero implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    private Boleteria laBoleteria;
    private Tren elTren;

    public Pasajero(Boleteria laBole, Tren elT) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
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
        elTren.bajarse();
        System.out.println("el pasajero " + this.nombre + " se baja al tren");
    }
}
