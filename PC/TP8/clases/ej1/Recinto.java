package TP8.clases.ej1;

import java.util.concurrent.Semaphore;

public class Recinto {
    private Semaphore semaforoFila;
    private Semaphore semaforoAlmuerzo;
    private Semaphore semaforoAbridor;
    private Semaphore semaforoPostre;

    public Recinto() {
        semaforoFila = new Semaphore(1);
        semaforoAlmuerzo = new Semaphore(5);
        semaforoAbridor = new Semaphore(10);
        semaforoPostre = new Semaphore(3);
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

    public void tomarBandeja() {
        try {
            semaforoAlmuerzo.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarBandeja() {
        semaforoAlmuerzo.release();
    }

    public void tomarAbridor() {
        try {
            semaforoAbridor.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarAbridor() {
        semaforoAbridor.release();
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
