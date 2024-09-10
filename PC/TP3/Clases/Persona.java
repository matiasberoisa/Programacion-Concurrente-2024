package PC.TP3.Clases;

import java.util.Random;
import java.util.UUID;

public class Persona implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    // private Area[] areas;
    private Area unArea;
    private int cantReservas;

    public Persona(Area[] ar, int cr) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        // this.areas = ar;
        this.cantReservas = cr;
    }

    public Persona(Area ar, int cr) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        this.unArea = ar;
        this.cantReservas = cr;
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
            this.realizarReserva();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * private void realizarReservas() throws InterruptedException {
     * int pos = 0;
     * boolean encontrado = false;
     * while (pos < areas.length && !encontrado) {
     * if (areas[pos].cantEspaciosLibres() < this.cantReservas) {
     * System.out.println("el area " + (pos + 1) + " no tiene espacio suficiente");
     * pos++;
     * } else {
     * System.out.println(
     * "el area " + (pos + 1) + " tiene espacio para realizar la reserva");
     * areas[pos].reservar(this);
     * encontrado = true;
     * }
     * }
     * Thread.sleep(1000);
     * }
     */

    private void realizarReserva() throws InterruptedException {
        if (unArea.cantEspaciosLibres() > this.cantReservas) {
            System.out.println("el area tiene espacio, la persona " + this.nombre + " comienza a reservar");
            unArea.reservar(this);
        } else {
            System.out.println("el area no tiene espacio suficiente");
        }
        if (unArea.cantEspaciosLibres() != 0) {
            System.out.println("quedan " + unArea.cantEspaciosLibres() + " espacios libres");
        }
        Thread.sleep(1000);
    }
}
