package TP3.Clases;

public class Suma implements Runnable {
    private Integer[] numeros;
    private int numHilo;
    private int limite;
    private int resultadoParcial;
    private boolean termino = false;

    public Suma(Integer[] nume, int nh, int lim) {
        numeros = nume;
        numHilo = nh;
        limite = lim;
    }

    public void run() {
        System.out.println("el hilo #" + this.numHilo + " realiza la suma");
        this.sumar();
        termino = true;
        System.out.println("el hilo #" + this.numHilo + " termino la suma");
    }

    public synchronized void sumar() {
        int pos = 0;
        try {
            while (pos < numeros.length && pos < limite) {
                resultadoParcial += numeros[pos];
                pos++;
            }
            Thread.sleep(2000);
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
