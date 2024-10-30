package TP5.clases.ej6;

import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore semaforoPista;
    private Semaphore semaforoTorre;
    private int contador;
    private String bandera;

    public Pista() {
        contador = 0;
        bandera = "Aterrizar";
        semaforoPista = new Semaphore(1);
        semaforoTorre = new Semaphore(0);
    }

    public void aterrizar() {
        try {
            if (bandera.equals("Aterrizar")) {
                semaforoPista.acquire();
            }
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
            if (bandera.equals("Despegar")) {
                semaforoPista.acquire();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void priorizarDespegue() {
        semaforoPista.release();
        bandera = "Aterrizar";
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
