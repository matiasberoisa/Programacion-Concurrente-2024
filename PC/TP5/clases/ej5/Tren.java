package TP5.clases.ej5;

import java.util.concurrent.Semaphore;

public class Tren {
    private Semaphore semaforoAsientos;
    private Semaphore semaforoControl;
    private Semaphore semaforoViaje;
    private int limite;
    private int cantidad;

    public Tren(int lim) {
        limite = lim;
        cantidad = 0;
        semaforoAsientos = new Semaphore(lim);
        semaforoControl = new Semaphore(0);
        semaforoViaje = new Semaphore(0);
    }

    // metodo para el pasajero

    public void subirse() {
        try {
            semaforoAsientos.acquire();
            cantidad++;
            this.viajar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void esperarViaje() {
        try {
            semaforoViaje.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bajarse() {
        semaforoAsientos.release();
        cantidad--;
    }

    // metodo para el control

    public void viajar() {
        if (cantidad == limite) {
            semaforoControl.release();
        }

    }

    public void cerrarPuertas() {
        try {
            semaforoControl.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void abrirPuertas() {
        semaforoViaje.release(limite);
    }
}
