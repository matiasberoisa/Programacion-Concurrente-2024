package TP5.clases;

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
        switch (numRandom.nextInt(1, 3)) {
            case 1:
                System.out.println("el empleado " + this.nombre + " busca bebida");
                ordenarBebida();
                break;
            case 2:
                System.out.println("el empleado " + this.nombre + " busca comida");
                ordenarComida();
                break;
            default:
                System.out.println("el empleado " + this.nombre + " busca comida y bebida");
                ordenarAmbos();
                break;
        }
    }

    public void ordenarComida() {
        try {
            String opcion = laConfiteria
                    .obtenerOpcionComida(numRandom.nextInt(1, laConfiteria.obtenerLongitudComida()));
            System.out.println("el empleado desea ordenar " + opcion);
            Thread.sleep(2000);
            laConfiteria.realizarPedidoComida(opcion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void ordenarBebida() {
        try {
            String opcion = laConfiteria
                    .obtenerOpcionComida(numRandom.nextInt(1, laConfiteria.obtenerLongitudBebida()));
            System.out.println("el empleado desea ordenar " + opcion);
            Thread.sleep(2000);
            laConfiteria.realizarPedidoBebida(opcion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void comer() {
        try {
            laConfiteria.esperar();
            System.out.println("el empleado empieza a comer");
            Thread.sleep(3000);
            System.out.println("el empleado termina de comer, agradece al cocinero y desocupa la mesa");
            laConfiteria.desocuparMesa(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tomar() {
        try {
            laConfiteria.esperar();
            System.out.println("el empleado empieza a tomar");
            Thread.sleep(3000);
            System.out.println("el empleado termina de tomar, agradece al mozo y desocupa la mesa");
            laConfiteria.desocuparMesa(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ordenarAmbos() {
        try {
            this.ordenarBebida();
            laConfiteria.esperar();
            System.out.println("el empleado recibe su bebida y ordena la comida");
            this.ordenarComida();
            laConfiteria.esperar();
            System.out.println("el empleado recibe su comida y comienza a comer");
            Thread.sleep(3000);
            System.out.println("el empleado termino, agradece a ambos y desocupa la mesa");
            laConfiteria.desocuparMesa(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
