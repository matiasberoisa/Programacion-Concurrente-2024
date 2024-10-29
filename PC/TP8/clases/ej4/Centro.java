package TP8.clases.ej4;

import java.util.concurrent.Semaphore;

public class Centro {
    private Semaphore semaforoCamilla;
    private Semaphore semaforoSilla;
    private Semaphore semaforoRevista;
    private Semaphore mutex;
    private int revistasUsadas;
    private int camillasUsadas;
    private int sillasUsadas;
    private int cantidadSillas;
    private int cantidadCamillas;
    private int cantidadRevistas;
    private boolean camillaDisponible;
    private boolean revistaDisponible;
    private boolean sillaDisponible;

    public Centro(int cS, int cC, int cR) {
        mutex = new Semaphore(10);
        semaforoCamilla = new Semaphore(cC);
        semaforoSilla = new Semaphore(cS);
        semaforoRevista = new Semaphore(cR);
        revistasUsadas = 0;
        camillasUsadas = 0;
        sillasUsadas = 0;
        camillaDisponible = true;
        revistaDisponible = true;
        cantidadCamillas = cC;
        cantidadRevistas = cR;
        cantidadSillas = cS;
    }

    public boolean buscarCamilla(Donador elDonador) {
        boolean encontroCamilla = true;
        try {
            if (!camillaDisponible) {
                encontroCamilla = false;
                if (sillaDisponible && elDonador.deseaSentarse()) {
                    sillasUsadas++;
                    if (sillasUsadas == cantidadSillas) {
                        sillaDisponible = false;
                    }
                    elDonador.tomarAsiento();
                    System.out.println("el donador N° " + elDonador.getNumero() + " toma un asiento");
                    semaforoSilla.acquire();
                }
                if (revistaDisponible) {
                    elDonador.tomarRevista();
                    System.out.println("el donador N° " + elDonador.getNumero() + " toma una revista");
                    agarrarRevista();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return encontroCamilla;
    }

    public void dejarSilla() {
        semaforoSilla.release();
    }

    public void entrarAlCentro() throws InterruptedException {
        mutex.acquire();
    }

    public void usarCamilla() throws InterruptedException {
        semaforoCamilla.acquire();
        camillasUsadas++;
        if (camillasUsadas == cantidadCamillas) {
            camillaDisponible = false;
        }
    }

    public void dejarCamilla() {
        camillasUsadas--;
        camillaDisponible = true;
        semaforoCamilla.release();
        mutex.release();
    }

    public void agarrarRevista() throws InterruptedException {
        semaforoRevista.acquire();
        revistasUsadas++;
        if (revistasUsadas == cantidadRevistas) {
            revistaDisponible = false;
        }
    }

    public void dejarRevista() {
        revistasUsadas--;
        revistaDisponible = true;
        semaforoRevista.release();
    }

}
