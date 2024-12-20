package TP7.clases.ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Libro {
    private boolean disponible;
    private ReentrantLock lock;
    private Condition objDisponible;

    public Libro() {
        disponible = true;
        lock = new ReentrantLock(true);
        objDisponible = lock.newCondition();
    }

    public void usarLibro() {
        lock.lock();
        try {
            if (!disponible) {
                while (!disponible) {
                    objDisponible.await();
                }
            }
            disponible = false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void liberarLibro() {
        lock.lock();
        disponible = true;
        objDisponible.signal();
        lock.unlock();
    }
}
