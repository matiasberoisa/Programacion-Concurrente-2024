package TP5.clases.ej7;

public class Persona implements Runnable {
    private int numero;
    private Escalera laEscalera;

    public Persona(int num, Escalera laE) {
        numero = num;
        laEscalera = laE;
    }

    public void run() {
        int numeroEscalera;
        try {
            laEscalera.ocuparEscalera();
            System.out.println("la persona " + this.numero + " entra a la escalera");
            numeroEscalera = laEscalera.pasarAlTobogan();
            laEscalera.dejarEscalera();
            System.out.println("la persona " + this.numero + " entra al tobogan " + numeroEscalera);
            Thread.sleep(3000);
            System.out.println("la persona " + this.numero + " deja el tobogan " + numeroEscalera);
            if (numeroEscalera == 1) {
                laEscalera.dejarTobogan1();
            } else {
                laEscalera.dejarTobogan2();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
