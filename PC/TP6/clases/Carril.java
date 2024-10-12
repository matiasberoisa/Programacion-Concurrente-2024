package PC.TP6.clases;

import java.util.concurrent.Semaphore;

public class Carril {
    private Semaphore semaforoCarrilNorte;
    private Semaphore semaforoCarrilSur;
    private Semaphore semaforoCircular;

    public Carril() {
        semaforoCarrilNorte = new Semaphore(1);
        semaforoCarrilSur = new Semaphore(0);
        semaforoCircular = new Semaphore(1);
    }

    public void circular() {
        try {
            semaforoCircular.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void liberar() {
        semaforoCircular.release();
    }

    public void norteASur() {
        try {
            semaforoCarrilNorte.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaforoCarrilSur.release();
    }

    public void surANorte() {
        try {
            semaforoCarrilSur.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaforoCarrilNorte.release();
    }

    public boolean puedeCruzarNorte() {
        return semaforoCarrilNorte.tryAcquire();
    }

    public boolean puedeCruzarSur() {
        return semaforoCarrilSur.tryAcquire();
    }
}
