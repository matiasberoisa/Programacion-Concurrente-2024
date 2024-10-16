package TP6.clases;

public class Carril {
    private String direccionActual;
    private boolean puedePasar = true;
    // private int contador = 0;

    public Carril() {
        direccionActual = "Norte";
    }

    public synchronized void EntrarCocheDelNorte(Coche unCoche) throws InterruptedException {
        while (!unCoche.getDireccion().equals("Norte")) {
            wait(); // Espera hasta que otro hilo llame a notify
        }
        if (unCoche.getDireccion().equals(direccionActual) && puedePasar) {
            puedePasar = false;

        } else {
            while (!puedePasar) {
                wait(); // Espera hasta que otro hilo llame a notify
            }
        }
    }

    public synchronized void salirCocheDelNorte() {
        puedePasar = true;
        direccionActual = "Sur";
        notify(); // Notifica a los hilos en espera
    }

    public synchronized void EntrarCocheDelSur(Coche unCoche) throws InterruptedException {

        while (!unCoche.getDireccion().equals("Sur")) {
            wait(); // Espera hasta que otro hilo llame a notify
        }
        if (unCoche.getDireccion().equals(direccionActual) && puedePasar) {
            puedePasar = false;
        } else {
            while (!puedePasar) {
                wait(); // Espera hasta que otro hilo llame a notify
            }
        }

    }

    public synchronized void salirCocheDelSur() {
        puedePasar = true;
        direccionActual = "Norte";
        notify(); // Notifica a los hilos en espera
    }

}
