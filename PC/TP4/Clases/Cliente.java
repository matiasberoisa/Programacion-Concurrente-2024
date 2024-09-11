package Clases;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private String nombre;
    private Semaphore semaforo;
    private GestorImpresora[] gestor;

    public Cliente(String nn, Semaphore se, GestorImpresora[] gi) {
        nombre = nn;
        semaforo = se;
        gestor = gi;
    }

    public void run() {
        int pos = 0;
        try {
            if (semaforo.tryAcquire()) {
                semaforo.acquire();
                while (gestor[pos] != null) {
                    pos++;
                }
                gestor[pos].usar();
                Thread.sleep(3000);
                gestor[pos].liberar();
                semaforo.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
