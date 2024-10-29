package TP8.clases.ej2;

import java.util.concurrent.locks.*;

public class Observatorio {
    private ReentrantLock lock;
    private Condition visitantesEspera;
    private Condition personalEspera;
    private Condition investigadorEspera;
    private String quienEntra;
    private int capacidad;
    private int cantidadVisitante;
    private int cantidadEmpleado;
    private int cantidadInvestigador;
    private int visitanteEsperando;
    private int empleadoEsperando;
    private int investigadorEsperando;
    private int observaciones;

    public Observatorio(int cap) {
        lock = new ReentrantLock();
        visitantesEspera = lock.newCondition();
        personalEspera = lock.newCondition();
        investigadorEspera = lock.newCondition();
        capacidad = cap;
        cantidadVisitante = 0;
        cantidadEmpleado = 0;
        cantidadInvestigador = 0;
        empleadoEsperando = 0;
        investigadorEsperando = 0;
        observaciones = 0;
        quienEntra = "x";
    }

    // metodos referidos a los visitantes

    public void entraVisitante(Visitante unVisitante) throws InterruptedException {
        lock.lock();
        try {
            if (quienEntra.equals("x")) {
                quienEntra = "Visitante";
                cantidadVisitante++;
                if (unVisitante.esDiscapacitado()) {
                    capacidad = 30;
                }
            } else {
                if (unVisitante.esDiscapacitado()) {
                    capacidad = 30;
                }
                visitanteEsperando++;
                while (!quienEntra.equals("Visitante") || cantidadVisitante > capacidad) {
                    visitantesEspera.await();
                }
                visitanteEsperando--;
                cantidadVisitante++;
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
                quienEntra = "Personal";
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

    // metodos referidos a los personales de mantenimiento

    public void entraPersonal() throws InterruptedException {
        lock.lock();
        try {
            if (quienEntra.equals("x")) {
                quienEntra = "Personal";
                cantidadEmpleado++;
            } else {
                empleadoEsperando++;
                while (!quienEntra.equals("Personal") || cantidadEmpleado > 2) {
                    personalEspera.await();
                }
                empleadoEsperando--;
                cantidadEmpleado++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void salePersonal() {
        lock.lock();
        cantidadEmpleado--;
        if (cantidadEmpleado == 0) {
            if (investigadorEsperando > 0) {
                quienEntra = "Investigador";
                investigadorEspera.signalAll();
            }
            if (visitanteEsperando > 0) {
                quienEntra = "Visitante";
                visitantesEspera.signalAll();
            }
        }
        lock.unlock();
    }

    // metodos referidos a los investigadores

    public void entraInvestigador() throws InterruptedException {
        lock.lock();
        try {
            if (quienEntra.equals("x")) {
                quienEntra = "Investigador";
                cantidadInvestigador++;
            } else {
                investigadorEsperando++;
                while (!quienEntra.equals("Investigador") || cantidadInvestigador > 2) {
                    investigadorEspera.await();
                }
                investigadorEsperando--;
                cantidadInvestigador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void saleInvestigador() {
        lock.lock();
        cantidadInvestigador--;
        if (cantidadInvestigador == 0) {
            if (visitanteEsperando > 0) {
                quienEntra = "Visitante";
                visitantesEspera.signalAll();
            }
            if (empleadoEsperando > 0) {
                quienEntra = "Personal";
                personalEspera.signalAll();
            }
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
