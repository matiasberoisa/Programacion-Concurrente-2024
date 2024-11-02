package parcialesRecuperatorios.atomos.monitores;

import java.util.Random;

public class Recipiente {
    private boolean Olisto;
    private boolean Hlisto;
    private int recipiente;
    private int limite;
    private int cantH;
    private String bandera;
    private boolean hiloDentro;
    private Random random = new Random();
    private String[] atomos = new String[2];

    public Recipiente(int lim) {
        Olisto = false;
        Hlisto = false;
        hiloDentro = false;
        recipiente = 0;
        cantH = 0;
        limite = lim;
        atomos[0] = "Hidrogeno";
        atomos[1] = "Oxigeno";
        bandera = atomos[random.nextInt(0, 2)];
    }

    public synchronized void prepararHidrogeno(Hidrogeno atomoHidrogeno) throws InterruptedException {
        while (!atomoHidrogeno.getAtomo().equals(bandera) || Hlisto) {
            wait();
        }
        if (atomoHidrogeno.getAtomo().equals(bandera) && !Hlisto && !hiloDentro) {
            hiloDentro = true;
            cantH++;
            if (cantH == 2) {
                Hlisto = true;
            }
        } else {
            while (hiloDentro) {
                wait();
            }
        }
    }

    public synchronized void prepararOxigeno(Oxigeno atomoOxigeno) throws InterruptedException {
        while (!atomoOxigeno.getAtomo().equals(bandera) || Olisto) {
            wait();
        }
        if (atomoOxigeno.getAtomo().equals(bandera) && !Olisto && !hiloDentro) {
            hiloDentro = true;
            Olisto = true;
        } else {
            while (hiloDentro) {
                wait();
            }
        }
    }

    public synchronized void hacerAgua() {
        recipiente++;
        cantH = 0;
        Olisto = false;
        Hlisto = false;
        if (recipiente == limite) {
            System.out.println("el recipiente se ha llenado");
            recipiente = 0;
        }
        notifyAll();
    }

    public synchronized void oxigenoListo() {
        bandera = "Hidrogeno";
        hiloDentro = false;
        notify();
    }

    public synchronized void hidrogenoListo() {
        if (cantH == 2) {
            bandera = "Oxigeno";
        }
        hiloDentro = false;
        notify();
    }

    public boolean OListo() {
        return Olisto;
    }

    public boolean Hlisto() {
        return Hlisto;
    }

    public int cantRecipiente() {
        return this.recipiente;
    }
}
