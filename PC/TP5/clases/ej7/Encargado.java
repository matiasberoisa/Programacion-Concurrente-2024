package TP5.clases.ej7;

public class Encargado implements Runnable {
    private Escalera laEscalera;

    public Encargado(Escalera laE) {
        laEscalera = laE;
    }

    public void run() {
        while (true) {
            try {
                laEscalera.habilitarTobogan(1);
                Thread.sleep(3000);
                laEscalera.habilitarTobogan(2);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
