package TP7.clases.ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Computadora {
    private boolean disponible;
    private ReentrantLock lock;
    private Condition objDisponible;

    public Computadora() {
        disponible = true;
        lock = new ReentrantLock(true);
        objDisponible = lock.newCondition();
    }

    public synchronized void usarComputadora() {
        lock.lock();
        try {
            while (!disponible) {
                objDisponible.await();
            }
            this.ocuparComputadora();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public synchronized void ocuparComputadora() {
        disponible = false;
    }

    public synchronized void liberarComputadora() {
        disponible = false;
        objDisponible.signal();
    }
}
