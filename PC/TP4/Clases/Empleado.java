package Clases;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Empleado implements Runnable {
    private String nombre;
    private Random numRandom = new Random();
    private int longDeseada;
    private Confiteria laConfiteria;
    private Semaphore semaforoMesa;

    public Empleado(Confiteria c, Semaphore sm) {
        longDeseada = numRandom.nextInt(1, 10);
        this.nombre = UUID.randomUUID()
                .toString()
                .substring(0, longDeseada);
        laConfiteria = c;
        semaforoMesa = sm;
    }

    public void run() {
        try {
            semaforoMesa.acquire();
            System.out.println("el empleado " + this.nombre + " entra a la confiteria");
            laConfiteria.ocuparMesa(this);
            this.ordenar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            System.out.println("el empleado empieza a comer");
            Thread.sleep(3000);
            System.out.println("el empleado termina de comer, agradece al mozo y desocupa la mesa");
            laConfiteria.desocuparMesa();
            semaforoMesa.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
