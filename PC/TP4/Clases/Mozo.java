package Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Mozo {
    private String nombre;
    private Semaphore semaforoAtiende;
    private Random numRandom = new Random();
    private int longDeseada;
    private Confiteria laConfiteria;

    public Mozo(Semaphore sa, Confiteria c) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        semaforoAtiende = sa;
        laConfiteria = c;
    }
}
