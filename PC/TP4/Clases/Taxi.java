package Clases;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Taxi implements Runnable {
    private int numeroAuto;
    private Semaphore semaforoViaje;
    private Random numRandom = new Random();
    private Persona pasajero;
    private Boolean estado = true;

    public Taxi(Semaphore sv) {
        this.numeroAuto = numRandom.nextInt(10, 100);
        semaforoViaje = sv;
    }

    public void run() {
        System.out.println("el taxi " + this.numeroAuto + " empieza a circular");
        while (true) {
        }
    }

    public void comenzarViaje(Persona unPasajero) {
        try {
            semaforoViaje.acquire();
            this.pasajero = unPasajero;
            estado = false;
            System.out.println("el taxi " + this.numeroAuto + " tiene un viaje y conduce hasta el pasajero");
            Thread.sleep(2000);
            subirPasajero();
            Thread.sleep(3000);
            dejarPasajero();
            semaforoViaje.release();
            terminarViaje();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void subirPasajero() {
        System.out.println("el pasajero " + pasajero.obtenerNombre() + " se sube al taxi " + this.numeroAuto
                + " y comienza el viaje");
    }

    public void terminarViaje() {
        System.out.println("el chofer del taxi " + this.numeroAuto + " termina el viaje y duerme una siesta");
        this.estado = true;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarPasajero() {
        System.out.println("el pasajero " + pasajero.obtenerNombre() + " ha llegado a su destino");
    }

    public synchronized boolean disponible() {
        return this.estado;
    }

}
