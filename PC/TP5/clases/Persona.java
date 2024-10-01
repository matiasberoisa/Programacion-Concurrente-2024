package PC.TP5.clases;

import java.util.Random;
import java.util.UUID;

public class Persona implements Runnable {
    private Piscina laPiscina;
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;

    public Persona(Piscina laP) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        ;
        laPiscina = laP;
    }

    public void run() {
        laPiscina.entrarFila();
        System.out.println("la persona " + this.nombre + " quiere entrar a la piscina");
        this.meterse();

    }

    public void meterse() {
        try {
            laPiscina.entrar();
            laPiscina.salirFila();
            System.out.println("la persona " + this.nombre + " entra a la piscina");
            Thread.sleep(3000);
            System.out.println("la persona " + this.nombre + " sale de la piscina");
            laPiscina.salir();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
