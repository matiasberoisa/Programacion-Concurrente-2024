package TP6.clases;

public class Carril {
    private String direccionActual;
    private boolean listo = false;

    public Carril() {
        direccionActual = "Norte";
    }

    public synchronized void EntrarCocheDelNorte() throws InterruptedException {
        while (!listo) {
            wait(); // Espera hasta que otro hilo llame a notify
        }
        System.out.println("Continuando...");
    }

    public synchronized void listoNorte() {
        listo = true;
        notify(); // Notifica a los hilos en espera
    }

    public synchronized void EntrarCocheDelSur() throws InterruptedException {
        while (listo) {
            wait(); // Espera hasta que otro hilo llame a notify
        }
        System.out.println("Continuando...");
    }

    public synchronized void listoSur() {
        listo = false;
        notify(); // Notifica a los hilos en espera
    }

}
