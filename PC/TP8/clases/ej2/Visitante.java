package TP8.clases.ej2;

public class Visitante implements Runnable {
    private Observatorio elObservatorio;
    private int numero;
    private boolean discapacitado;
    private int numeroEntrada;

    public Visitante(Observatorio elObs, int num, boolean disc) {
        elObservatorio = elObs;
        numero = num;
        discapacitado = disc;
    }

    public void run() {
        try {
            elObservatorio.entraVisitante(this);
            numeroEntrada = elObservatorio.numeroEntrada();
            System.out.println("el visitante N° " + this.numero + " ingresa con el ticket N° " + this.numeroEntrada);
            Thread.sleep(3000);
            System.out.println("el visitante N° " + this.numero + " sale del observatorio");
            elObservatorio.dejarSala(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getNumeroEntrada() {
        return this.numeroEntrada;
    }

    public boolean esDiscapacitado() {
        return this.discapacitado;
    }

}
