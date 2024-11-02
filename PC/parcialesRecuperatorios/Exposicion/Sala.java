package parcialesRecuperatorios.Exposicion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {
    private ReentrantLock lock;
    private Condition visitantes;
    private Condition responsables;
    private Condition criticos;
    private int visitantesDentro;
    private int responsableDentro;
    private int criticosDentro;
    private int capacidad;
    private int visitantesEsperando;
    private int responsablesEsperando;
    private int criticosEsperando;
    private String condicionActual;

    public Sala(int cap) {
        lock = new ReentrantLock();
        visitantes = lock.newCondition();
        criticos = lock.newCondition();
        responsables = lock.newCondition();
        visitantesDentro = 0;
        responsableDentro = 0;
        criticosDentro = 0;
        capacidad = cap;
        visitantesEsperando = 0;
        responsablesEsperando = 0;
        criticosEsperando = 0;
        condicionActual = "X";
    }

    public void entraVisitante() {
        lock.lock();
        try {
            if (condicionActual.equals("X")) {
                condicionActual = "Visitante";
                visitantesDentro++;
            } else {
                visitantesEsperando++;
                while (condicionActual.equals("Critico") || visitantesDentro > capacidad) {
                    visitantes.await();
                }
                visitantesEsperando--;
                visitantesDentro++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void entraResponsable() {
        lock.lock();
        try {
            if (condicionActual.equals("X")) {
                condicionActual = "Responsable";
                responsableDentro++;
            } else {
                responsablesEsperando++;
                while (condicionActual.equals("Critico") || responsableDentro > 0) {
                    responsables.await();
                }
                responsablesEsperando--;
                responsableDentro++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void entraCritico() {
        lock.lock();
        try {
            if (condicionActual.equals("X")) {
                condicionActual = "Critico";
                criticosDentro++;
            } else {
                criticosEsperando++;
                while (!condicionActual.equals("Critico") || criticosDentro >= 5) {
                    criticos.await();
                }
                criticosEsperando--;
                criticosDentro++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void saleVisitante() {
        lock.lock();
        visitantesDentro--;
        if (responsableDentro == 0 && visitantesDentro == 0) {
            condicionActual = "Critico";
            criticos.signalAll();
        }
        lock.unlock();
    }

    public void saleResponsable() {
        lock.lock();
        responsableDentro--;
        if (responsableDentro == 0 && visitantesDentro == 0) {
            condicionActual = "Critico";
            criticos.signalAll();
        }
        lock.unlock();
    }

    public void saleCritico() {
        lock.lock();
        criticosDentro--;
        if (criticosDentro == 0) {
            if (visitantesEsperando > 0) {
                condicionActual = "Visitante";
                visitantes.signalAll();
            }
            if (responsablesEsperando > 0) {
                condicionActual = "Responsable";
                responsables.signalAll();
            }
        }
        lock.unlock();
    }

    public int criticosDentro() {
        return this.criticosDentro;
    }

    public int visitantesDentro() {
        return this.visitantesDentro;
    }

    public int responsablesDentro() {
        return this.responsableDentro;
    }

    public int criticosEsperando() {
        return this.criticosEsperando;
    }
}
