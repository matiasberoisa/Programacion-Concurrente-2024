package Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private String nombre;
    private Semaphore semaforoFila;
    private Semaphore semaforoImpresora;
    private GestorImpresora gestor;
    private Random numRandom = new Random();
    private int longDeseada;

    public Cliente(Semaphore se, Semaphore si, GestorImpresora gi) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        semaforoFila = se;
        semaforoImpresora = si;
        gestor = gi;
    }

    public void run() {
        Impresora disponible = null;
        try {
            semaforoFila.acquire();
            System.out.println("avanza en la fila el cliente: " + this.nombre);
            semaforoImpresora.acquire();
            while (disponible == null) {
                disponible = gestor.buscarDisponible();
            }
            disponible.usar(this);
            semaforoFila.release();
            Thread.sleep(3000);
            disponible.liberar(this);
            semaforoImpresora.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
