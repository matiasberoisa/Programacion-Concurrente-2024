package Clases;

import java.util.Random;
import java.util.UUID;

public class Mozo implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    private Confiteria laConfiteria;

    public Mozo(Confiteria c) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        laConfiteria = c;
    }

    public void run() {
        System.out.println("el mozo " + this.nombre + " comienza a trabajar");
        while (true) {

        }
    }

    public void realizarOrden(String orden) {
        try {
            System.out.println("el mozo prepara " + orden);
            Thread.sleep(3000);
            System.out.println(" el mozo lleva " + orden);
            laConfiteria.llevarPedido();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void descansar() {
        System.out.println("el mozo descansa y busca inventar nuevas versiones de pollo");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
