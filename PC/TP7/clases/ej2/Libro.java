package TP7.clases.ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Libro {
    private boolean disponible;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition objDisponible = lock.newCondition();

    public Libro() {
        disponible = true;
        lock = new ReentrantLock(true);
        objDisponible = lock.newCondition();
    }

    public synchronized void usarLibro() {
        lock.lock();
        try {
            while (!disponible) {
                objDisponible.await();
            }
            this.ocuparLibro();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public synchronized void ocuparLibro() {
        disponible = false;
    }

    public synchronized void liberarLibro() {
        disponible = true;
        objDisponible.signal();
    }
}
