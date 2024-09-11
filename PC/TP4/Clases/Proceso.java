package Clases;

import java.util.concurrent.Semaphore;

public class Proceso implements Runnable {
    private String nombre;
    private Semaphore sem1;
    private Semaphore sem2;

    public Proceso(String nn, Semaphore s1, Semaphore s2) {
        nombre = nn;
        sem1 = s1;
        sem2 = s2;
    }

    public void run() {
        try {
            while (true) {
                sem1.acquire();
                System.out.println("ejecutando " + this.nombre);
                Thread.sleep(1000);
                sem2.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
