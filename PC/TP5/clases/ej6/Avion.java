package TP5.clases.ej6;

import java.util.Random;

public class Avion implements Runnable {
    private int numero;
    private Pista laPista;
    private Random numRandom = new Random();
    private String condicion;

    public Avion(Pista laPis, String cond) {
        numero = numRandom.nextInt(100, 1000);
        laPista = laPis;
        condicion = cond;
    }

    public void run() {
        try {
            if (condicion.equals("Aterrizar")) {
                laPista.aterrizar();
                System.out.println("el avion " + this.numero + " aterriza en la pista");
                Thread.sleep(3000);
                System.out.println("el avion " + this.numero + " ha estacionado");
                laPista.estacionar();
                laPista.liberarPista();
                cambiarCondicion();
                laPista.despegar();
                System.out.println("el avion " + this.numero + " empieza a despegar");
                Thread.sleep(3000);
                System.out.println("el avion " + this.numero + " despego");
                laPista.confirmarDespegue();
            } else {
                laPista.despegar();
                System.out.println("el avion " + this.numero + " empieza a despegar");
                Thread.sleep(3000);
                System.out.println("el avion " + this.numero + " despego");
                laPista.confirmarDespegue();
            }

        } catch (

        InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void cambiarCondicion() {
        condicion = "Despegar";
    }

    public String getCondicion() {
        return this.condicion;
    }

}
