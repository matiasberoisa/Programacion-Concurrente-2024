package TP8.clases.ej2;

import java.util.Random;
import java.util.concurrent.locks.*;

public class Observatorio {
    private ReentrantLock lock;
    private Condition visitantesEspera;
    private Condition personalEspera;
    private Condition investigadorEspera;
    private String quienEntra;
    private int capacidad;
    private int cantidadVisitante;
    private int visitantesActuales;
    private int visitanteEsperando;
    private int empleadoEsperando;
    private int investigadorEsperando;
    private int observaciones;
    private Random random;

    public Observatorio(int cap) {
        lock = new ReentrantLock();
        visitantesEspera = lock.newCondition();
        personalEspera = lock.newCondition();
        investigadorEspera = lock.newCondition();
        capacidad = cap;
        cantidadVisitante = 0;
        visitantesActuales = 0;
        empleadoEsperando = 0;
        investigadorEsperando = 0;
        observaciones = 0;
        quienEntra = "x";
    }

    // metodos referidos a los visitantes

    public void entraVisitante(Visitante unVisitante) throws InterruptedException {
        lock.lock();
        visitantesActuales = random.nextInt(50);
        System.out.println("visitantes actuales: " + visitantesActuales);
        try {
            if (quienEntra.equals("x")) {
                quienEntra = "Visitante";
                cantidadVisitante++;
                if (unVisitante.esDiscapacitado()) {
                    capacidad = 30;
                }
            } else {
                cantidadVisitante++;
                while (!quienEntra.equals("Visitante") || cantidadVisitante > capacidad) {
                    visitantesEspera.await();
                }
                if (unVisitante.esDiscapacitado()) {
                    capacidad = 30;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void dejarSala(Visitante unVisitante) {
        lock.lock();
        if (unVisitante.esDiscapacitado()) {
            capacidad = 50;
        }
        cantidadVisitante--;
        if (cantidadVisitante == 0) {
            if (empleadoEsperando > 0) {
                quienEntra = "Empleado";
                personalEspera.signalAll();
            }
            if (investigadorEsperando > 0) {
                quienEntra = "Investigador";
                investigadorEspera.signalAll();
            }
        }
        lock.unlock();
    }

    public int numeroEntrada() {
        return this.cantidadVisitante;
    }

    public int visitantes() {
        return this.visitantesActuales;
    }

    // metodos referidos a los personales de mantenimiento

    public void entraPersonal() throws InterruptedException {
        lock.lock();
        try {
            if (quienEntra.equals("x")) {
                quienEntra = "Personal";
            } else {
                if (!quienEntra.equals("Personal")) {
                    while (!quienEntra.equals("Personal")) {
                        personalEspera.await();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void salePersonal() {
        lock.lock();
        if (investigadorEsperando > 0) {
            quienEntra = "Investigador";
            investigadorEspera.signalAll();
        }
        if (visitanteEsperando > 0) {
            quienEntra = "Visitante";
            visitantesEspera.signalAll();
        }
        lock.unlock();
    }

    // metodos referidos a los investigadores

    public void entraInvestigador() throws InterruptedException {
        lock.lock();
        try {
            if (quienEntra.equals("x")) {
                quienEntra = "Investigador";
            } else {
                if (!quienEntra.equals("Investigador")) {
                    while (!quienEntra.equals("Investigador")) {
                        investigadorEspera.await();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void saleInvestigador() {
        lock.lock();
        if (visitanteEsperando > 0) {
            quienEntra = "Visitante";
            visitantesEspera.signalAll();
        }
        if (empleadoEsperando > 0) {
            quienEntra = "Empleado";
            personalEspera.signalAll();
        }
        lock.unlock();
    }

    public void registrarObservacion() {
        observaciones++;
    }

    public int getObsevarciones() {
        return this.observaciones;
    }
}
