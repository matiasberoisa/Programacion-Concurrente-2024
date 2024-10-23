package TP5.clases.ej8;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private Semaphore semaforoCuerda;
    // private Semaphore semaforoPaso;
    // private int contador;

    public Cuerda() {
        semaforoCuerda = new Semaphore(5);
        // semaforoPaso = new Semaphore(0);
    }

    public void pasarCuerda() {
        try {
            semaforoCuerda.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
