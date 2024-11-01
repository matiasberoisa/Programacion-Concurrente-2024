package parcialesRecuperatorios.atomos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Recipiente {
    private ReentrantLock lock;
    private Condition hidrogenos;
    private Condition oxigenos;
    private boolean Olisto;
    private boolean Hlisto;
    private int recipiente;
    private int envase;
    private int limite;
    private int cantH;

    public Recipiente(int lim) {
        lock = new ReentrantLock(true);
        hidrogenos = lock.newCondition();
        oxigenos = lock.newCondition();
        Olisto = false;
        Hlisto = false;
        recipiente = 0;
        envase = 0;
        cantH = 0;
        limite = lim;
    }

    public void prepararHidrogeno() {
        lock.lock();
        try {
            if (Hlisto) {
                while (Hlisto) {
                    hidrogenos.await();
                }
            } else {
                cantH++;
                if (cantH == 2) {
                    Hlisto = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void prepararOxigeno() {
        lock.lock();
        try {
            if (Olisto) {
                while (Olisto) {
                    oxigenos.await();
                }
            } else {
                Olisto = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void hacerAgua() {
        lock.lock();
        try {
            recipiente++;
            System.out.println("recipiente: " + recipiente);
            cantH = 0;
            Olisto = false;
            Hlisto = false;
            if (recipiente == limite) {
                envase++;
                recipiente = 0;
                System.out.println("se lleno el recipiente");
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void oxigenoListo() {
        lock.lock();
        hidrogenos.signalAll();
        oxigenos.signalAll();
        lock.unlock();
    }

    public void hidrogenoListo() {
        lock.lock();
        oxigenos.signalAll();
        hidrogenos.signalAll();
        lock.unlock();
    }

    public int envasesLlenos() {
        return envase;
    }

    public boolean OListo() {
        return Olisto;
    }

    public boolean Hlisto() {
        return Hlisto;
    }
}
