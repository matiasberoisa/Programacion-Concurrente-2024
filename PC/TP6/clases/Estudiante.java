package TP6.clases;

public class Estudiante implements Runnable {
    private int numero;
    private Estudio elEstudio;

    public Estudiante(int num, Estudio est) {
        numero = num;
        elEstudio = est;
    }

    public void run() {
        Mesa mesaDisponible = null;
        try {
            mesaDisponible = elEstudio.esperarMesa();
            mesaDisponible.ocuparMesa();
            System.out
                    .println("el estudiante " + this.numero + " ocupa la mesa "
                            + mesaDisponible.obtenerNumero());

            Thread.sleep(5000);
            mesaDisponible.liberarMesa();
            System.out.println(
                    "el estudiante " + this.numero + " libera la mesa " + mesaDisponible.obtenerNumero());
            elEstudio.habilitarMesa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getNumero() {
        return this.numero;
    }

}
