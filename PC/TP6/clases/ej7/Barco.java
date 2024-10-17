package TP6.clases.ej7;

public class Barco {
    private int cantidad;
    private int limite;
    private Boolean pasaPasajero;
    private Boolean pasaAuto;
    private boolean puedeSubir;

    public Barco() {
        cantidad = 0;
        limite = 50;
        pasaPasajero = true;
        pasaAuto = false;
        puedeSubir = true;
    }

    public synchronized void subirAuto() throws InterruptedException {
        while (!pasaAuto) {
            wait();
        }

        if (limite - cantidad >= 4) {
            cantidad += 4;
        } else {
            while (!puedeSubir) {
                wait();
            }
        }
    }

    public synchronized void bajarAuto() {
        cantidad -= 4;
    }

    public synchronized void subirPasajero() throws InterruptedException {
        while (!pasaPasajero) {
            wait();
        }

        if (limite - cantidad >= 1) {
            cantidad++;
        } else {
            while (!puedeSubir) {
                wait();
            }
        }
    }

    public synchronized void bajarPasajero() {
        cantidad--;
    }
}
