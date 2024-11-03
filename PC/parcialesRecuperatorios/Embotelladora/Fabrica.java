package parcialesRecuperatorios.Embotelladora;

import java.util.concurrent.Semaphore;

public class Fabrica {
    private Semaphore mutex, semaforoCaja, semaforoTransporte;
    private int cantCaja, cantAlmacen;
    private String cajaActual;
    private boolean existeCaja;

    public Fabrica() {
        mutex = new Semaphore(1);
        semaforoCaja = new Semaphore(0);
        semaforoTransporte = new Semaphore(0);
        cantCaja = 0;
        cantAlmacen = 0;
        cajaActual = "Vino";
        existeCaja = true;
    }

    public void entraEmbotellador() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void prepararBotella() {
        cantCaja++;
        if (cantCaja == 10) {
            semaforoCaja.release();
        }
    }

    public void cambiarCaja() {
        try {
            semaforoCaja.acquire();
            existeCaja = false;
            cantAlmacen += cantCaja;
            cantCaja = 0;
            if (cantAlmacen == 100) {
                semaforoTransporte.release();
                cantAlmacen = 0;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void habilitarEmbotellador() {
        if (cajaActual.equals("Vino")) {
            cajaActual = "Agua";
        } else {
            cajaActual = "Vino";
        }
        existeCaja = true;
    }

    public void saleEmbotellador() {
        mutex.release();
    }

    public void transportarCaja() {
        try {
            semaforoTransporte.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean existeCaja() {
        return this.existeCaja;
    }

    public String tipoCaja() {
        return this.cajaActual;
    }

    public int cantCajas() {
        return this.cantCaja;
    }
}
