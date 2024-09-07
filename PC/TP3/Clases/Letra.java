package PC.TP3.Clases;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Letra implements Runnable {
    private String nombre;
    private String letra;
    private int cantidad;
    private Random numRandom = new Random();
    private String cadena;
    private Semaphore semaforo1;
    private boolean termino = false;

    public Letra(String nn, String le, String ca, Semaphore se1) {
        nombre = nn;
        letra = le;
        cantidad = numRandom.nextInt(1, 5);
        cadena = ca;
        semaforo1 = se1;
    }

    public void run() {
        String valor = "";
        for (int i = 0; i < cantidad; i++) {
            valor = valor + letra;
        }
        System.out.println(this.nombre + " concatena " + valor);
        try {
            semaforo1.acquire();
            this.concatenar();
            termino = true;
            semaforo1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void concatenar() {
        try {
            for (int i = 0; i < cantidad; i++) {
                cadena = letra;
                System.out.print(cadena);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean termino() {
        return this.termino;
    }
}
