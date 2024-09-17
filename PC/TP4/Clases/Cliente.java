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
        Impresora disponible1 = null, disponible2 = null;
        try {
            semaforoFila.acquire();
            System.out.println("avanza en la fila el cliente: " + this.nombre + ", utiliza impresora tipo: "
                    + this.tipoImpresion);
            if (this.tipoImpresion.equals("A") || this.tipoImpresion.equals("B")) {
                // si es de tipo A o tipo B la impresion
                disponible1 = buscarDisponible(this.tipoImpresion);
                if (this.tipoImpresion.equals("A")) {
                    semaforoImpresoraA.acquire();
                    disponible1.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponible1.liberar(this);
                    semaforoImpresoraA.release();
                }
                if (this.tipoImpresion.equals("B")) {
                    semaforoImpresoraB.acquire();
                    disponible1.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponible1.liberar(this);
                    semaforoImpresoraB.release();
                }
            } else {
                // si es de tipo C, busca la impresora disponible mas cercana
                disponible1 = buscarDisponible("A");
                disponible2 = buscarDisponible("B");
                if (disponible1.obtenerTipo().equals("A")) {
                    semaforoImpresoraA.acquire();
                    disponible1.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponible1.liberar(this);
                    semaforoImpresoraA.release();
                }
                if (disponible2.obtenerTipo().equals("B")) {
                    semaforoImpresoraB.acquire();
                    disponible1.usar(this);
                    semaforoFila.release();
                    Thread.sleep(3000);
                    disponible1.liberar(this);
                    semaforoImpresoraB.release();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Impresora buscarDisponible(String tipo) {
        Impresora disponible = null;
        while (disponible == null) {
            disponible = gestor.buscarDisponibleTipo(tipo);
        }
        return disponible;
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
