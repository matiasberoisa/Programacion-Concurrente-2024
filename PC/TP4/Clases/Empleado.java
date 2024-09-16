package Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Empleado {
    private String nombre;
    private Semaphore semaforoPedido;
    private Random numRandom = new Random();
    private int longDeseada;
    private Confiteria laConfiteria;

    public Empleado(Semaphore sp, Confiteria c) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        semaforoPedido = sp;
        laConfiteria = c;
    }
}
