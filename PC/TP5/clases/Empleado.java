package TP5.clases;

import java.util.Random;

public class Empleado implements Runnable {
    private int nombre;
    private Random numRandom = new Random();
    private Confiteria laConfiteria;
    private int unaMesa;

    public Empleado(int n, Confiteria c) {
        this.nombre = n;
        laConfiteria = c;
    }

    public void run() {
        int pedido = numRandom.nextInt(1, 4);
        unaMesa = laConfiteria.ocuparMesa(this);
        System.out.println(unaMesa);
        System.out.println("el empleado " + this.nombre + " entra a la confiteria");
        switch (pedido) {
            case 1:
                System.out.println("el empleado " + this.nombre + " busca bebida");
                ordenarBebida();
                tomar();
                break;
            case 2:
                System.out.println("el empleado " + this.nombre + " busca comida");
                ordenarComida();
                comer();
                break;
            default:
                System.out.println("el empleado " + this.nombre + " busca comida y bebida");
                ordenarAmbos();
                break;
        }
    }

    public void ordenarComida() {
        String opcion = laConfiteria
                .obtenerOpcionComida(numRandom.nextInt(1, laConfiteria.obtenerLongitudComida()));
        System.out.println("el empleado " + this.nombre + " desea comer " + opcion);
        laConfiteria.realizarPedidoComida(opcion, unaMesa);

    }

    public void ordenarBebida() {
        String opcion = laConfiteria
                .obtenerOpcionBebida(numRandom.nextInt(1, laConfiteria.obtenerLongitudBebida()));
        System.out.println("el empleado " + this.nombre + " desea tomar " + opcion);
        laConfiteria.realizarPedidoBebida(opcion, unaMesa);

    }

    public void ordenarAmbos() {
        String opcionComida = laConfiteria
                .obtenerOpcionComida(numRandom.nextInt(1, laConfiteria.obtenerLongitudComida()));
        String opcionBebida = laConfiteria
                .obtenerOpcionBebida(numRandom.nextInt(1, laConfiteria.obtenerLongitudBebida()));
        try {
            laConfiteria.realizarPedido(opcionBebida, opcionComida, unaMesa);
            System.out.println("el empleado " + this.nombre + " desea tomar " + opcionBebida);
            laConfiteria.llamarMozo();
            this.esperar();
            System.out.println("el empleado recibe su bebida y ordena la comida");
            System.out.println("el empleado " + this.nombre + " desea comer " + opcionComida);
            laConfiteria.llamarCocinero();
            this.esperar();
            System.out.println("el empleado recibe su comida y comienza a comer");
            Thread.sleep(3000);
            System.out.println("el empleado termino, agradece a ambos y desocupa la mesa");
            laConfiteria.desocuparMesa(2, unaMesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void comer() {
        try {
            this.esperar();
            System.out.println("el empleado " + this.nombre + " empieza a comer");
            Thread.sleep(3000);
            System.out.println(
                    "el empleado " + this.nombre + " termina de comer, agradece al cocinero y desocupa la mesa");
            laConfiteria.desocuparMesa(2, unaMesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tomar() {
        try {
            this.esperar();
            System.out.println("el empleado " + this.nombre + " empieza a tomar");
            Thread.sleep(3000);
            System.out.println(
                    "el empleado " + this.nombre + " termina de tomar, agradece al mozo y desocupa la mesa");
            laConfiteria.desocuparMesa(1, unaMesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void registrarMesa(int num) {
        unaMesa = num;
    }

    public void esperar() {
        if (unaMesa == 1) {
            laConfiteria.esperarMesa1();
        } else {
            laConfiteria.esperarMesa2();
        }
    }

    public int getNombre() {
        return this.nombre;
    }

}
