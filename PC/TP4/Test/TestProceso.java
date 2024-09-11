package Test;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import Clases.Proceso;

public class TestProceso {
    public static void main(String[] args) {
        Semaphore semaforo1 = new Semaphore(1);
        Semaphore semaforo2 = new Semaphore(0);
        Semaphore semaforo3 = new Semaphore(0);
        Proceso P1 = new Proceso("P1", semaforo1, semaforo2);
        Proceso P2 = new Proceso("P2", semaforo2, semaforo3);
        Proceso P3 = new Proceso("P3", semaforo3, semaforo1);
        ArrayList<Thread> hilos = new ArrayList<>();
        hilos.add(new Thread(P1));
        hilos.add(new Thread(P2));
        hilos.add(new Thread(P3));
        hilos.forEach(p -> p.start());

    }
}
