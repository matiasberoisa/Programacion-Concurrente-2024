package TP7.clases.ej3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cocina {
    private ReentrantLock lock;
    private Condition cocineros;
    private boolean disponible;

    public Cocina() {
        lock = new ReentrantLock(true);
        cocineros = lock.newCondition();
        disponible = true;
    }

    public void usarCocina() {
        lock.lock();
        try {
            if (!disponible) {
                while (!disponible) {
                    cocineros.await();
                }
            }
            disponible = false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void liberarCocina() {
        lock.lock();
        disponible = true;
        cocineros.signal();
        lock.unlock();
    }
}
