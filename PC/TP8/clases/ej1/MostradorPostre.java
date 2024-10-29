package TP8.clases.ej1;

import java.util.concurrent.Semaphore;

public class MostradorPostre {
    private Semaphore semaforoPostre;

    public MostradorPostre() {
        semaforoPostre = new Semaphore(5);
    }

    public void tomarPostre() {
        try {
            semaforoPostre.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarPostre() {
        semaforoPostre.release();
    }
}
