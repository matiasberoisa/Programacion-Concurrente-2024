package TP8.clases.ej5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Olla {
    private Semaphore semaforoComer;
    private Semaphore semaforoCocinar;
    private Semaphore mutex;
    private boolean quedanRaciones;
    private int raciones;
    private Random random = new Random();

    public Olla() {
        raciones = random.nextInt(5, 10);
        semaforoComer = new Semaphore(raciones);
        semaforoCocinar = new Semaphore(0);
        mutex = new Semaphore(1);
        quedanRaciones = true;
    }

    public void entrarFila() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejarFila() {
        mutex.release();
    }

    public void comer() {
        try {
            semaforoComer.acquire();
            raciones--;
            if (raciones == 0) {
                quedanRaciones = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean quedanRaciones() {
        return this.quedanRaciones;
    }

    public void cocinar() {
        try {
            semaforoCocinar.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void servir() {
        raciones = random.nextInt(5, 10);
        semaforoComer.release(raciones);
        quedanRaciones = true;
    }

    public void despertarCocinero() {
        semaforoCocinar.release();
    }

}
