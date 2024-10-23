package TP5.clases.ej6;

import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore semaforoPista;
    private Semaphore semaforoDespegue;
    private Semaphore semaforoTorre;
    private int contador;

    public Pista() {
        contador = 0;
        semaforoPista = new Semaphore(1);
        semaforoDespegue = new Semaphore(0);
        semaforoTorre = new Semaphore(0);
    }

    public void aterrizar() {
        try {
            semaforoPista.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void estacionar() {
        contador++;
        if (contador == 3) {
            semaforoTorre.release();
        }

    }

    public void liberarPista() {
        semaforoPista.release();
    }

    public void despegar() {
        try {
            semaforoDespegue.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void priorizarDespegue() {
        semaforoDespegue.release();
        contador = 0;
    }

    public int revisarContador() {
        return this.contador;
    }

    public void confirmarDespegue() {
        semaforoTorre.release();
    }

    public void habilitarTorre() {
        try {
            semaforoTorre.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
