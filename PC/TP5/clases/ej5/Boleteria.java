package TP5.clases.ej5;

import java.util.concurrent.Semaphore;

public class Boleteria {
    private Semaphore semaforoVenta;
    private Semaphore semaforoFila;
    private int numeroTicket;

    public Boleteria() {
        semaforoVenta = new Semaphore(0);
        semaforoFila = new Semaphore(1);
        numeroTicket = 0;
    }

    public void comprarTicket() {
        semaforoVenta.release();
    }

    public void venderTicket() {
        try {
            semaforoVenta.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        numeroTicket++;
    }

    public int numeroTicket() {
        return this.numeroTicket;
    }

    public void ponerseEnLaFila() {
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
