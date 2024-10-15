package MaM;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private Elemento[] elementos;
    private int cantidadElementosListos;
    private Lock candado = new ReentrantLock(true);
    private Condition consumidores = candado.newCondition();
    private Condition productores = candado.newCondition();
    private boolean listoC;
    private boolean listoP;

    public Buffer(int var1) {
        elementos = new Elemento[var1];
    }

    public synchronized void producir() {
        candado.lock();
        try {
            while (!listoP) {
                productores.await();
            }

            consumidores.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            candado.unlock();
        }
    }

    public void terminarProducir() {
        listoC = true;
        listoP = false;

    }

    public void terminarConsumir() {
        listoC = false;
        listoP = true;

    }

    public synchronized void consumir() {
        candado.lock();
        try {
            while (!listoC) {
                consumidores.await();
            }

            productores.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            candado.unlock();
        }
    }

    public int cantElemDisponibles() {
        return this.cantidadElementosListos;
    }

    public int topeBuffer() {
        return this.elementos.length;
    }
}
