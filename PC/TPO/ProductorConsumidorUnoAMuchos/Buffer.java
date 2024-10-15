package ProductorConsumidorUnoAMuchos;

import java.util.concurrent.Semaphore;

public class Buffer {
    private Object[] elementos;
    private int ultimo;
    private Semaphore mutex = new Semaphore(1), consumidor = new Semaphore(3);

    public Buffer(int cantidad) {
        elementos = new Object[cantidad];
        ultimo = -1;
    }

    public void producir(int cant) throws InterruptedException {
        System.out.println("El productor intenta producir");
        try {
            mutex.acquire();
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("El productor entro a producir");
        int contador = 0, i = cant;
        while (i > 0) {
            if (ultimo < elementos.length) {
                ultimo++;
                elementos[ultimo] = new Object();
                i--;
                contador++;
                Thread.sleep(2000);
            } else {
                System.out.println("No se puede agregar mas porque el buffer esta lleno");
                i = 0;
            }
        }
        if (contador > 0) {
            System.out.println("Se han ingresado " + contador + " productos de " + cant);
        } else {
            System.out.println("Se intentaron agregar " + cant + " productos pero el buffer esta lleno");
        }
        Thread.sleep(2000);
        System.out.println("El productor dejo de producir");
        mutex.release();
    }

    public void consumir() throws InterruptedException {
        System.out.println("Soy " + Thread.currentThread().getName() + " y estoy intentando entrar a consumir");
        try {
            consumidor.acquire();
            System.out.println("Entro " + Thread.currentThread().getName() + " a consumir");
            mutex.acquire();
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        if (ultimo >= 0) {
            System.out.println("Soy " + Thread.currentThread().getName() + " y entre a consumir");
            elementos[ultimo] = null;
            ultimo--;
            Thread.sleep(2000);
            System.out.println("Soy " + Thread.currentThread().getName() + " y deje de consumir");

        } else {
            System.out.println("Soy " + Thread.currentThread().getName() + " y no pude consumir");
            System.out.println("El buffer esta vacio");
        }
        mutex.release();
        consumidor.release();
    }

    public int longitudlementos() {
        return this.elementos.length;
    }
}
