package TP6.clases;

public class Carril {
    private String direccionActual;
    private boolean listoNorte = true;
    private boolean listoSur = false;

    public Carril() {
        direccionActual = "Norte";
    }

    @SuppressWarnings("unlikely-arg-type")
    public synchronized void EntrarCocheDelNorte(Coche unCoche) throws InterruptedException {
        while (!listoNorte && !unCoche.equals(direccionActual)) {
            wait(); // Espera hasta que otro hilo llame a notify
        }
        System.out.println("avanza por el norte el auto " + unCoche.getNumero());

    }

    public synchronized void salirCocheDelNorte() {
        listoSur = true;
        listoNorte = false;
        direccionActual = "Sur";
        notify(); // Notifica a los hilos en espera
    }

    @SuppressWarnings("unlikely-arg-type")
    public synchronized void EntrarCocheDelSur(Coche unCoche) throws InterruptedException {
        while (!listoSur && !unCoche.equals(direccionActual)) {
            wait(); // Espera hasta que otro hilo llame a notify
        }
        System.out.println("avanza por el sur el auto " + unCoche.getNumero());
    }

    public synchronized void salirCocheDelSur() {
        listoNorte = true;
        listoSur = false;
        direccionActual = "Norte";
        notify(); // Notifica a los hilos en espera
    }

}
