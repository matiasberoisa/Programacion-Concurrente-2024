package TP6.clases;

public class Coche implements Runnable {
    private int numero;
    private String direccion;
    private Carril puente;

    public Coche(int num, String dir, Carril pu) {
        numero = num;
        direccion = dir;
        puente = pu;
    }

    public void run() {

    }
}
