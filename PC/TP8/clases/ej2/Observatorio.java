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
    private int cantidadEmpleados;
    private int cantidadInvestigadores;
    private Object[] observaciones;
    private int cantObservaciones;

    public Observatorio(int cap, int cantE, int cantI) {
        lock = new ReentrantLock(true);
        visitantesEspera = lock.newCondition();
        personalEspera = lock.newCondition();
        investigadorEspera = lock.newCondition();
        capacidad = cap;
        cantidadVisitante = 0;
        cantidadEmpleados = cantE;
        cantidadInvestigadores = cantI;
        observaciones = new Object[30];
        cantObservaciones = 0;
        quienEntra = "x";
    }

    // metodos referidos a los visitantes

    public void entraVisitante(Visitante unVisitante) throws InterruptedException {
        lock.lock();
        try {
            if (quienEntra.equals("x")) {
                quienEntra = "Visitante";
                ocuparSala();
                verificarDiscapacidad(unVisitante);
            } else {
                if (!quienEntra.equals("Visitante")) {
                    while (!quienEntra.equals("Visitante")) {
                        visitantesEspera.await();
                    }
                } else {
                    ocuparSala();
                    verificarDiscapacidad(unVisitante);
                    if (cantidadVisitante > capacidad) {
                        while (cantidadVisitante > capacidad) {
                            visitantesEspera.await();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private void verificarDiscapacidad(Visitante unVisitante) {
        if (unVisitante.esDiscapacitado()) {
            cambiarCapacidad();
        }

    }

    private void ocuparSala() {
        cantidadVisitante++;
    }

    public void dejarSala(Visitante unVisitante) {
        lock.lock();
        if (unVisitante.esDiscapacitado()) {
            retornarCapacidad();
        }
        if (unVisitante.getNumeroEntrada() == capacidad) {
            quienEntra = "x";// se deja en vacio para que cualquiera de los restantes pueda entrar
            cantidadVisitante = 0;
            personalEspera.signalAll();
            investigadorEspera.signalAll();
        }
        lock.unlock();
    }

    private void cambiarCapacidad() {
        capacidad = 30;
    }

    public int numeroEntrada() {
        return this.cantidadVisitante;
    }

    private void retornarCapacidad() {
        capacidad = 50;
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

    public void salePersonal(PersonalMantenimiento elPersonal) {
        lock.lock();
        if (elPersonal.getNumero() == cantidadEmpleados) {
            quienEntra = "x";// se deja en vacio para que cualquiera de los restantes pueda entrar
            visitantesEspera.signalAll();
            investigadorEspera.signalAll();
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

    public void saleInvestigador(Investigador elInvestigador) {
        lock.lock();
        if (elInvestigador.getNumero() == cantidadInvestigadores) {
            quienEntra = "x";// se deja en vacio para que cualquiera de los restantes pueda entrar
            visitantesEspera.signalAll();
            personalEspera.signalAll();
        }
        lock.unlock();
    }

    public void registrarObservacion() {
        observaciones[cantObservaciones] = new Object();
        cantObservaciones++;
    }
}
