package PC.TP5.clases.ej5;

import java.util.Random;
import java.util.UUID;

public class Pasajero implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    private Boleteria laBoleteria;
    private Tren elTren;

    public Pasajero() {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
    }

    public void run() {

    }
}
