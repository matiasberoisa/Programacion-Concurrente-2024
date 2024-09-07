package PC.TP3.Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Persona implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    private Area[] areas;
    private int cantReservas;
    private Semaphore semaforo;

    public Persona(Area[] ar, int cr, Semaphore se) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        this.areas = ar;
        this.cantReservas = cr;
        semaforo = se;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantReservas() {
        return this.cantReservas;
    }

    public void run() {
        System.out.println("la persona " + this.nombre + " desea reservar " + this.cantReservas + " lugares");
        try {
            this.realizarReservas();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void realizarReservas() throws InterruptedException {
        int pos = 0;
        semaforo.acquire();
        while (pos < areas.length) {
            if (areas[pos].cantEspaciosLibres() < this.cantReservas) {
                System.out.println("el area " + (pos + 1) + " no tiene espacio suficiente");
                pos++;
            } else {
                System.out.println(
                        "el area " + (pos + 1) + " tiene espacio para realizar la reserva");
            }
            Thread.sleep(1000);
        }
        areas[pos].reservar(this);
        semaforo.release();
    }
}
