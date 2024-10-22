package TP7.clases.ej4;

import java.util.concurrent.Semaphore;

public class Cocina {
    private Semaphore semaforoIngrediente;
    private Semaphore semaforoCocina;

    public Cocina() {
        semaforoCocina = new Semaphore(1);
        semaforoIngrediente = new Semaphore(1);
    }

    public void usarCocina() throws InterruptedException {
        semaforoCocina.acquire();
        semaforoIngrediente.acquire();
    }

    public void liberarCocina() {
        semaforoIngrediente.release();
        semaforoCocina.release();
    }
}
