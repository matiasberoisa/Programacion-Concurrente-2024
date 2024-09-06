package PC.TP3;

import java.util.Random;
import java.util.UUID;

public class Persona implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    private Area[] areas;
    private int cantReservas;

    public Persona(Area[] ar, int cr) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        this.areas = ar;
        this.cantReservas = cr;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantReservas() {
        return this.cantReservas;
    }

    public void run() {
        int pos = 0;
        boolean reservado = false;
        System.out.println("la persona " + this.nombre + " empieza a reservar");
        while (!reservado && pos < areas.length) {
            try {
                if (areas[pos].cantEspaciosLibres() < this.cantReservas) {

                    System.out.println("el area " + (pos + 1) + " no tiene espacio suficiente");
                    pos++;
                } else {
                    reservado = true;
                    System.out.println("el area " + (pos + 1) + " tiene espacio para realizar la reserva");
                    areas[pos].reservar(this);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
