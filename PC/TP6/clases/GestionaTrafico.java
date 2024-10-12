package TP6.clases;

public class GestionaTrafico implements Runnable {
    private Carril puente = new Carril();

    public GestionaTrafico() {

    }

    public void run() {
        while (true) {
            try {
                puente.listoNorte();
                Thread.sleep(2000);
                puente.listoSur();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
