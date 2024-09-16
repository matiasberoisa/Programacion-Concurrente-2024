package Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Persona implements Runnable {
    private String nombre;
    private Semaphore semaforoPasajero;
    private Random numRandom = new Random();
    private int longDeseada;
    private Taxi[] taxis;

    public Persona(Semaphore sv, Taxi[] tax) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        semaforoPasajero = sv;
        taxis = tax;
    }

    public void run() {
        Taxi taxiDisponible = null;
        try {
            semaforoPasajero.acquire();
            System.out.println("el pasajero " + this.nombre + " busca un taxi");
            taxiDisponible = buscarTaxi();
            Thread.sleep(2000);
            semaforoPasajero.release();
            taxiDisponible.comenzarViaje(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Taxi buscarTaxi() {
        int pos = 0;
        while (!taxis[pos].disponible() && pos < taxis.length - 1) {
            pos++;
        }
        return this.taxis[pos];
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
