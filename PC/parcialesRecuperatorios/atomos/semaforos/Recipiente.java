package parcialesRecuperatorios.atomos.semaforos;

import java.util.concurrent.Semaphore;

public class Recipiente {
    private Semaphore mutex, semaforoOxigeno, semaforoHidrogeno, semaforoEspera;
    private int limite, recipiente, cantHidrogeno;
    private boolean Olisto, Hlisto;

    public Recipiente(int lim) {
        mutex = new Semaphore(1);
        semaforoOxigeno = new Semaphore(1);
        semaforoHidrogeno = new Semaphore(2);
        semaforoEspera = new Semaphore(0);
        limite = lim;
        recipiente = 0;
        cantHidrogeno = 0;
        Olisto = false;
        Hlisto = false;
    }

    public void entraOxigeno() {
        try {
            semaforoOxigeno.acquire();
            mutex.acquire();
            Olisto = true;
        } catch (Exception e) {
        }
    }

    public void entraHidrogeno() {
        try {
            semaforoHidrogeno.acquire();
            mutex.acquire();
            cantHidrogeno++;
            if (cantHidrogeno == 2) {
                Hlisto = true;
            }
        } catch (Exception e) {

        }
    }

    public boolean hacerAgua() {
        boolean hizoAgua = false;
        if (Olisto && Hlisto) {
            hizoAgua = true;
            Olisto = false;
            Hlisto = false;
            cantHidrogeno = 0;
            recipiente++;
            semaforoHidrogeno.release(2);
            semaforoOxigeno.release();
            semaforoEspera.release(3);
        }
        return hizoAgua;
    }

    public void dejarRecipiente() {
        mutex.release();
    }

    public boolean vaciarRecipiente() {
        boolean vaciar = false;
        if (recipiente == limite) {
            vaciar = true;
            recipiente = 0;
        }
        return vaciar;
    }

    public int cantRecipiente() {
        return recipiente;
    }

    public void terminarEjecucion() {
        try {
            semaforoEspera.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
