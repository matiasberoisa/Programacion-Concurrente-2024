package TP6.clases;

import java.util.concurrent.Semaphore;

public class Carril {
    private String direccionActual;
    private boolean listoNorte = true;
    private boolean listoSur = false;
    private boolean puedePasar = true;
    private Semaphore semaforoPasar = new Semaphore(1);
    // private int contador = 0;

    public Carril() {
        direccionActual = "Norte";
    }

    public synchronized void EntrarCocheDelNorte(Coche unCoche) throws InterruptedException {
        while (puedePasar) {
            while (!listoNorte) {
                wait(); // Espera hasta que otro hilo llame a notify
            }
            semaforoPasar.acquire();
            if (unCoche.getDireccion().equals(direccionActual)) {
                puedePasar = false;
                System.out.println("avanza por el norte el auto " + unCoche.getNumero());
            }
            semaforoPasar.release();
        }
    }

    public synchronized void salirCocheDelNorte() {
        listoSur = true;
        listoNorte = false;
        puedePasar = true;
        direccionActual = "Sur";
        notify(); // Notifica a los hilos en espera
    }

    public synchronized void EntrarCocheDelSur(Coche unCoche) throws InterruptedException {
        while (puedePasar) {
            while (!listoSur) {
                wait(); // Espera hasta que otro hilo llame a notify
            }
            semaforoPasar.acquire();
            if (unCoche.getDireccion().equals(direccionActual)) {
                puedePasar = false;
                System.out.println("avanza por el sur el auto " + unCoche.getNumero());
            }
            semaforoPasar.release();
        }

    }

    public synchronized void salirCocheDelSur() {
        listoNorte = true;
        listoSur = false;
        puedePasar = true;
        direccionActual = "Norte";
        notify(); // Notifica a los hilos en espera
    }

}
