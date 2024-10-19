package TP6.clases.ej7;

public class Barco {
    private int cantidad;
    private int limite;
    private Boolean pasaPasajero;
    private Boolean pasaAuto;
    private boolean puedeSubir;
    private boolean puedeBajar;
    private boolean puedeSalir;
    private boolean dejarSubir;

    public Barco() {
        cantidad = 0;
        limite = 50;
        pasaPasajero = true;
        pasaAuto = false;
        puedeSubir = false;
        puedeBajar = false;
        puedeSalir = false;
        dejarSubir = false;
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

    public synchronized void autoAPasajero() {
        pasaAuto = false;
        pasaPasajero = true;
        notifyAll();
    }

    public synchronized void pasajeroAAuto() {
        pasaAuto = true;
        pasaPasajero = false;
        notifyAll();
    }

    public synchronized void bajarAuto() throws InterruptedException {
        if (!puedeBajar) {
            while (!puedeBajar) {
                wait();
            }

        }
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

    public synchronized void bajarPasajero() throws InterruptedException {
        if (!puedeBajar) {
            while (!puedeBajar) {
                wait();
            }

        }
        cantidad--;
    }

    private void puedeSalir() {
        if (cantidad >= limite) {
            puedeSalir = true;
        }
    }

    public synchronized void subieronTodos() throws InterruptedException {
        this.puedeSalir();
        if (!puedeSalir) {
            while (!puedeSalir) {
                wait();
            }
        }
    }

    public void terminar() {
        puedeSalir = false;
    }

    public synchronized void habilitarSubida() {
        puedeSubir = true;
        puedeBajar = false;
        notifyAll();
    }

    public synchronized void habilitarBajada() {
        puedeBajar = true;
        puedeSubir = false;
        notifyAll();
    }

    private void bajarObjetos() {
        if (cantidad == 0) {
            dejarSubir = true;
        }
    }

    public synchronized void bajaronTodos() throws InterruptedException {
        this.bajarObjetos();
        if (!dejarSubir) {
            while (!dejarSubir) {
                wait();
            }
        }
    }

}
