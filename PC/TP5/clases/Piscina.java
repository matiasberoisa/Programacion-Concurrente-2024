package TP5.clases;

import java.util.concurrent.Semaphore;

public class Piscina {
    private Semaphore semaforoCapacidad;
    private Semaphore semaforoFila;

    public Piscina(int cant) {
        semaforoCapacidad = new Semaphore(cant);
        semaforoFila = new Semaphore(1);
    }

    public void entrarFila() {
        try {
            semaforoFila.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void salirFila() {
        semaforoFila.release();
    }

    public void entrar() {
        try {
            semaforoCapacidad.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void salir() {
        semaforoCapacidad.release();
    }
}
