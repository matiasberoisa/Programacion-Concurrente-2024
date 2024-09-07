package PC.TP3.Clases;

import java.util.concurrent.Semaphore;

public class Suma implements Runnable {
    private Integer[] numeros;
    private int numHilo;
    private Semaphore semaforo;
    private int limite;
    private int resultadoParcial;
    private boolean termino = false;

    public Suma(Integer[] nume, int nh, int lim, Semaphore se) {
        numeros = nume;
        numHilo = nh;
        limite = lim;
        semaforo = se;
    }

    public void run() {
        try {
            semaforo.acquire();
            System.out.println("el hilo #" + this.numHilo + " realiza la suma");
            this.sumar();
            System.out.println("el hilo #" + this.numHilo + " termino la suma");
            termino = true;
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sumar() {
        int pos = 0, contadorPosiciones = 0;
        try {
            while (numeros[pos] == null) {
                contadorPosiciones++;
                pos++;
            }
            while (pos < numeros.length && pos < (limite + contadorPosiciones)) {
                resultadoParcial += numeros[pos];
                numeros[pos] = null;
                pos++;
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getResultadoParcial() {
        return this.resultadoParcial;
    }

    public boolean terminoSumar() {
        return this.termino;
    }

}
