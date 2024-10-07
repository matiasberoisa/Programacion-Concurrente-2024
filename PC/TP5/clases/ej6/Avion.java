package PC.TP5.clases.ej6;

import java.util.Random;

public class Avion implements Runnable {
    private int numero;
    private Pista laPista;
    private Random numRandom = new Random();
    private String condicion;

    public Avion(Pista laPis) {
        numero = numRandom.nextInt(0, 10);
        laPista = laPis;
    }

    public void run() {
        System.out.println("el avion " + this.numero + " empieza a circular");
    }
}
