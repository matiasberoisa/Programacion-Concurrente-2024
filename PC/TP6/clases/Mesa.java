package TP6.clases;

public class Mesa {
    private int numero;
    private boolean disponible;

    public Mesa(int num) {
        numero = num;
        disponible = true;
    }

    public synchronized void esperarMesa() throws InterruptedException {
        while (!disponible) {
            wait();
        }

    }

    public synchronized void dejarMesa() {
        notify();
    }

    public void ocuparMesa() {
        disponible = false;
    }

    public void liberarMesa() {
        disponible = true;
    }

    public boolean mesaDisponible() {
        return this.disponible;
    }

    public int obtenerNumero() {
        return this.numero;
    }
}
