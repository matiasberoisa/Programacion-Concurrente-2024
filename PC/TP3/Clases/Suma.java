package PC.TP3.Clases;

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
        System.out.println("el hilo #" + this.numHilo + " termino la suma");
        termino = true;

    }

    public void sumar() {
        int pos = 0, contadorPosiciones = 0;
        synchronized (this) {
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
    }

    public int getResultadoParcial() {
        return this.resultadoParcial;
    }

    public boolean terminoSumar() {
        return this.termino;
    }

}
