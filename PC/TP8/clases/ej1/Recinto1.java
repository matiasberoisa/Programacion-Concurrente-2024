package TP8.clases.ej1;

import java.util.concurrent.Semaphore;

public class Recinto1 {
    // private MostradorAlmuerzo[] mostradorAlmuerzos;
    // private MostradorPostre[] mostradorPostres;
    private Semaphore semaforoFila;
    // private Semaphore semaforoPostre;

    public Recinto1(MostradorAlmuerzo[] mA, MostradorPostre[] mP) {
        // mostradorAlmuerzos = mA;
        // mostradorPostres = mP;
        semaforoFila = new Semaphore(1);
        // semaforoPostre = new Semaphore(1);
    }

    public void entrarFila() {
        try {
            semaforoFila.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarFila() {
        semaforoFila.release();
    }

}
