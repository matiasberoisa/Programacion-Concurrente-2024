package TP5.clases.ej8;

public class Babuino implements Runnable {
    private int numero;
    private String lado;
    private Cuerda unaCuerda;

    public Babuino(int num, String la, Cuerda laC) {
        numero = num;
        lado = la;
        unaCuerda = laC;
    }

    public void run() {
        if (lado.equals("")) {
            unaCuerda.pasarCuerda();
            System.out.println("el babuino " + this.numero + " pasa por la cuerda");
        }
    }
}
