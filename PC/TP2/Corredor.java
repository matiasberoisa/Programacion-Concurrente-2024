package PC.TP2;

import java.util.ArrayList;
import java.util.Random;

public class Corredor implements Runnable {
    private String nombre;
    private int distancia;
    private boolean terminar = false;
    private Random random = new Random();

    public Corredor(String nn) {
        this.nombre = nn;
        this.distancia = 0;
    }

    public void run() {

        try {
            System.out.println("Comenzando " + this.nombre);
            for (int i = 0; i < 20; i++) {
                int distanciaActual = random.nextInt(1, 10);
                this.distancia += distanciaActual;
                System.out.println(this.nombre + " realiza paso " + (i + 1) + ", recorrio " + distanciaActual);
                Thread.sleep(400);
            }
            System.out.println(this.nombre + " recorrio " + this.distancia);
            terminar = true;
        } catch (InterruptedException exc) {
            System.out.println(this.nombre + "Interrumpido.");
        }
    }

    public int getDistancia() {
        return this.distancia;
    }

    public boolean terminoCorrer() {
        return this.terminar;
    }

    public String getNombre() {
        return this.nombre;
    }

    public static void main(String[] args) {
        Corredor[] corredores = new Corredor[4];
        int[] distancias = new int[4];
        int pos = 0, distanciaMasLarga = 0;
        Corredor ganador = null;
        ArrayList<Thread> corredoresHilos = new ArrayList<Thread>();
        boolean terminado = true;
        System.out.println("Comienza la carrera");
        for (int i = 0; i < 4; i++) {
            Corredor corredor = new Corredor("Corredor#" + (i + 1));
            Thread primerHilo = new Thread(corredor);
            corredoresHilos.add(primerHilo);
            corredores[i] = corredor;
        }
        corredoresHilos.forEach(e -> e.start());
        while (terminado) {
            if (pos < corredores.length) {
                if (corredores[pos].terminoCorrer()) {
                    distancias[pos] = corredores[pos].getDistancia();
                    if (ganador == null) {
                        ganador = corredores[pos];
                        distanciaMasLarga = corredores[pos].getDistancia();
                    } else {
                        if (distanciaMasLarga < corredores[pos].getDistancia()) {
                            ganador = corredores[pos];
                            distanciaMasLarga = corredores[pos].getDistancia();
                        }
                    }
                    pos++;
                }
            } else {
                terminado = false;
            }
        }
        System.out.println(
                "el ganador de la carrera es el " + ganador.getNombre() + " con distancia " + distanciaMasLarga);
    }
}
