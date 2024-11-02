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
        recipiente = 0;
        cantH = 0;
        limite = lim;
        atomos[0] = "Hidrogeno";
        atomos[1] = "Oxigeno";
        bandera = atomos[random.nextInt(0, 2)];
        hiloDentro = false;
    }

    public synchronized void prepararHidrogeno() throws InterruptedException {
        if (!bandera.equals("Hidrogeno") || Hlisto || cantH > 2) {
            while (!bandera.equals("Hidrogeno") || Hlisto || cantH > 2) {
                wait();
            }
        } else {
            if (!hiloDentro) {
                while (!hiloDentro) {
                    wait();
                }
            } else {
                hiloDentro = true;
                cantH++;
                if (cantH == 2) {
                    Hlisto = true;
                }
            }

        }
    }

    public synchronized void prepararOxigeno() throws InterruptedException {
        if (!bandera.equals("Oxigeno") || Olisto) {
            while (!bandera.equals("oxigeno") || Olisto) {
                wait();
            }
        } else {
            if (!hiloDentro) {
                while (!hiloDentro) {
                    wait();
                }
            } else {
                hiloDentro = true;
                Olisto = true;
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
    }

    public synchronized void oxigenoListo() {
        bandera = "Hidrogeno";
        hiloDentro = false;
        notifyAll();
    }

    public synchronized void hidrogenoListo() {
        bandera = "Oxigeno";
        hiloDentro = false;
        notifyAll();
    }

    public boolean OListo() {
        return Olisto;
    }

    public boolean Hlisto() {
        return Hlisto;
    }
}
