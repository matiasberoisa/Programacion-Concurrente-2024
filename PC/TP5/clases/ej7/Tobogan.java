package TP5.clases.ej7;

import java.util.concurrent.Semaphore;

public class Tobogan {
    private int numero;
    private Semaphore semaforoTobogan;

    public Tobogan(int n) {
        numero = n;
        semaforoTobogan = new Semaphore(1);
    }

    public void usarTobogan() {
        try {
            semaforoTobogan.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarTobogan() {
        semaforoTobogan.release();
    }

    public int getNumero() {
        return this.numero;
    }
}
