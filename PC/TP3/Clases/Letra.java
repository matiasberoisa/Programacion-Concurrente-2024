package PC.TP3.Clases;

import java.util.Random;

public class Letra implements Runnable {
    private String nombre;
    private String letra;
    private int cantidad;
    private Random numRandom = new Random();
    private String cadena;
    private boolean termino = false;

    public Letra(String nn, String le, String ca) {
        nombre = nn;
        letra = le;
        cantidad = numRandom.nextInt(1, 5);
        cadena = ca;
    }

    public void run() {
        String valor = "";
        boolean terminado = false;
        String[] hilos = new String[3];
        int pos = 0;
        hilos[0] = "hiloA";
        hilos[1] = "hiloB";
        hilos[2] = "hiloC";
        for (int i = 0; i < cantidad; i++) {
            valor = valor + letra;
        }
        System.out.println(this.nombre + " concatena " + valor);
        while (!terminado) {
            if (pos < hilos.length) {
                if (hilos[pos].equals(this.nombre)) {
                    pos++;
                    this.concatenar();
                }
            } else {
                terminado = true;
            }
        }

    }

    private synchronized void concatenar() {
        try {
            for (int i = 0; i < cantidad; i++) {
                cadena = letra;
                System.out.print(cadena);
                Thread.sleep(1000);
            }
            termino = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean termino() {
        return this.termino;
    }
}
