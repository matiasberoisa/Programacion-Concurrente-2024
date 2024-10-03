package PC.TP5.clases.ej5;

import java.util.concurrent.Semaphore;

public class Tren {
    private int cantidad = 0;
    private int limite;
    private Semaphore semaforoAsientos;
    private Semaphore semaforoControl = new Semaphore(0);

    public Tren(int lim) {
        limite = lim;
        semaforoAsientos = new Semaphore(lim);
    }

    public void subirse() {
        boolean subio = false;
        while (!subio) {
            if (semaforoAsientos.tryAcquire()) {
                ocuparAsiento();
            }
        }
    }

    public void ocuparAsiento() {
        semaforoControl.release();
    }

    public void anotarAsiento() {
        try {
            semaforoControl.acquire();
            semaforoAsientos.acquire();
            cantidad++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int limite() {
        return this.limite;
    }
}
