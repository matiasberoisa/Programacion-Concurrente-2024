package Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Persona implements Runnable {
    private String nombre;
    private Semaphore semaforoViaje;
    private Random numRandom = new Random();
    private int longDeseada;

    public Persona(Semaphore sv, GestorImpresora gi, String ti) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        semaforoViaje = sv;
    }

    public void run() {

    }

    public void buscarTaxi() {

    }

    public void viajar() {
    }
}
