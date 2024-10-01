package Clases;

import java.util.Random;
import java.util.UUID;

public class Empleado implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    private Confiteria laConfiteria;

    public Empleado(Confiteria c) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        laConfiteria = c;
    }

    public void run() {
        laConfiteria.ocuparMesa(this);
        System.out.println("el empleado " + this.nombre + " entra a la confiteria");
        this.ordenar();
        this.comer();
    }

    public void ordenar() {
        try {
            String opcion = laConfiteria.obtenerOpcion(numRandom.nextInt(1, laConfiteria.obtenerLongitud()));
            System.out.println("el empleado desea ordenar " + opcion);
            Thread.sleep(2000);
            laConfiteria.comenzarPedido(opcion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void comer() {
        try {
            laConfiteria.esperar();
            System.out.println("el empleado empieza a comer");
            Thread.sleep(3000);
            System.out.println("el empleado termina de comer, agradece al mozo y desocupa la mesa");
            laConfiteria.desocuparMesa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
