package Clases;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Taxi implements Runnable {
    private int numeroAuto;
    private Semaphore semaforoViaje;
    private Random numRandom = new Random();

    public Taxi(Semaphore sv, GestorImpresora gi, String ti) {
        this.numeroAuto = numRandom.nextInt(10, 100);
        semaforoViaje = sv;
    }

    public void run() {
        System.out.println("el taxi " + this.numeroAuto + " empieza a circular");
        while (true) {

        }
    }

    public void viajarHastaPasajero(Persona pasajero) {
        try {
            semaforoViaje.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void subirPasajero(Persona pasajero) {
        pasajero.viajar();

    }

    public void siesta() {
        System.out.println("el chofer del taxi " + this.numeroAuto + " termina el viaje y duerme una siesta");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
