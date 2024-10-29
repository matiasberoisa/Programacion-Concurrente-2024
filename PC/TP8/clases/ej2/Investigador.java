package TP8.clases.ej2;

public class Investigador implements Runnable {
    private Observatorio elObservatorio;
    private int numero;

    public Investigador(Observatorio elObs, int num) {
        elObservatorio = elObs;
        numero = num;
    }

    public void run() {
        while (true) {
            try {
                elObservatorio.entraInvestigador();
                System.out.println("el investigador " + this.numero + " entra al observatorio a trabajar");
                Thread.sleep(5000);
                elObservatorio.registrarObservacion();
                System.out.println("el investigador " + this.numero + " deja el observatorio");
                elObservatorio.saleInvestigador();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumero() {
        return this.numero;
    }
}
