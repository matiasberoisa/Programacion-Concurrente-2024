package TP6.clases.ej3;

import java.util.concurrent.Semaphore;

public class Estudio {
    private Mesa[] mesas;
    private Semaphore semaforoMesas;
    private Semaphore semaforoFila;

    public Estudio(Mesa[] mes) {
        mesas = mes;
        semaforoFila = new Semaphore(1);
        semaforoMesas = new Semaphore(mesas.length);
    }

    public synchronized Mesa buscarMesa() {
        Mesa mesaDisponible = null;
        int pos = 0;
        while (pos < mesas.length && mesaDisponible == null) {
            if (mesas[pos].mesaDisponible()) {
                mesaDisponible = mesas[pos];
            }
            pos++;
        }

        return mesaDisponible;
    }

    public void ocuparMesa() {
        try {
            semaforoMesas.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void desocuparMesa() {
        semaforoMesas.release();
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
