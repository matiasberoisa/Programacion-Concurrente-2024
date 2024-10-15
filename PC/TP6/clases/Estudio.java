package TP6.clases;

public class Estudio {
    private boolean disponible;

    public synchronized void esperarMesa() throws InterruptedException {
        while (!disponible) {
            wait();
        }

    }
}
