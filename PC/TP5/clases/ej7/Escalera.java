package TP5.clases.ej7;

import java.util.concurrent.Semaphore;

public class Escalera {
    private Tobogan tobogan1;
    private Tobogan tobogan2;
    private Semaphore semaforoEscalera;
    private Semaphore semaforoAvanzar;
    private int numero;

    public Escalera() {
        tobogan1 = new Tobogan(1);
        tobogan2 = new Tobogan(2);
        semaforoEscalera = new Semaphore(10);
        semaforoAvanzar = new Semaphore(0);
    }

    public void ocuparEscalera() {
        try {
            semaforoEscalera.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarEscalera() {
        semaforoEscalera.release();
    }

    public int pasarAlTobogan() {
        try {
            semaforoAvanzar.acquire();
            if (numero == 1) {
                tobogan1.usarTobogan();
            } else {
                tobogan2.usarTobogan();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numero;
    }

    public void dejarTobogan1() {
        tobogan1.dejarTobogan();
    }

    public void dejarTobogan2() {
        tobogan2.dejarTobogan();
    }

    public void habilitarTobogan(int num) {
        numero = num;
        semaforoAvanzar.release();
    }
}
