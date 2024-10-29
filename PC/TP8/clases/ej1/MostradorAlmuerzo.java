package TP8.clases.ej1;

import java.util.concurrent.Semaphore;

public class MostradorAlmuerzo {
    private Semaphore semaforoBandeja;

    public MostradorAlmuerzo() {
        semaforoBandeja = new Semaphore(5);
    }

    public void tomarBandeja() {
        try {
            semaforoBandeja.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarBandeja() {
        semaforoBandeja.release();
    }
}
