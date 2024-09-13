package Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private String nombre;
    private Semaphore semaforoFila;
    private Semaphore semaforoImpresoraA;
    private Semaphore semaforoImpresoraB;
    private String tipoImpresion;
    private GestorImpresora gestor;
    private Random numRandom = new Random();
    private int longDeseada;

    public Cliente(Semaphore se, Semaphore sa, Semaphore sb, GestorImpresora gi, String ti) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        semaforoFila = se;
        semaforoImpresoraA = sa;
        semaforoImpresoraB = sb;
        gestor = gi;
        tipoImpresion = ti;
    }

    public void run() {
        Impresora disponibleA = null, disponibleB = null;
        try {
            semaforoFila.acquire();
            System.out.println("avanza en la fila el cliente: " + this.nombre + ", utiliza impresora tipo: "
                    + this.tipoImpresion);
            while (disponibleA == null && disponibleB == null) {
                disponibleA = gestor.buscarDisponibleTipo("A");
                disponibleB = gestor.buscarDisponibleTipo("B");
            }
            if (this.tipoImpresion.equals("A") || this.tipoImpresion.equals("B")) {
                if (this.tipoImpresion.equals("A")) {
                    semaforoImpresoraA.acquire();
                    disponibleA.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponibleA.liberar(this);
                    semaforoImpresoraA.release();
                }
                if (this.tipoImpresion.equals("B")) {
                    semaforoImpresoraB.acquire();
                    disponibleB.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponibleB.liberar(this);
                    semaforoImpresoraB.release();
                }
            } else {
                if (disponibleA.obtenerTipo().equals("A")) {
                    semaforoImpresoraA.acquire();
                    disponibleA.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponibleA.liberar(this);
                    semaforoImpresoraA.release();
                }
                if (disponibleA.obtenerTipo().equals("B")) {
                    semaforoImpresoraB.acquire();
                    disponibleB.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponibleB.liberar(this);
                    semaforoImpresoraB.release();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
