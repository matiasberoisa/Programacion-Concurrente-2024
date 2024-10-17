package TP6.clases.ej3;

import java.util.Random;

public class Estudiante implements Runnable {
    private int numero;
    private Estudio elEstudio;
    private Random random = new Random();

    public Estudiante(
            int num, Estudio est) {
        numero = num;
        elEstudio = est;
    }

    public void run() {
        Mesa mesaDisponible = null;
        try {
            elEstudio.ponerseEnLaFila();
            elEstudio.ocuparMesa();
            mesaDisponible = elEstudio.buscarMesa();
            System.out
                    .println("el estudiante " + this.numero + " ocupa la mesa "
                            + mesaDisponible.obtenerNumero());
            elEstudio.dejarFila();
            mesaDisponible.ocuparMesa();
            Thread.sleep(random.nextInt(3, 5) * 1000);
            mesaDisponible.liberarMesa();
            System.out.println(
                    "el estudiante " + this.numero + " libera la mesa " + mesaDisponible.obtenerNumero());
            elEstudio.desocuparMesa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
