package TP6.clases;

public class Estudiante implements Runnable {
    private int numero;
    private Mesa[] mesas;
    private Estudio elEstudio;

    public Estudiante(int num, Mesa[] me, Estudio est) {
        numero = num;
        mesas = me;
        elEstudio = est;
    }

    public void run() {
        System.out.println("el estudiante N° " + this.numero + " llega al estudio");
        try {
            elEstudio.esperarMesa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("el estudiante N° " + this.numero + " busca una mesa");
        Mesa mesaDisponible = this.buscarMesa();
        if (mesaDisponible != null) {
            try {
                mesaDisponible.ocuparMesa();
                Thread.sleep(5000);
                mesaDisponible.dejarMesa();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized Mesa buscarMesa() {
        Mesa mesaDisponible = null;
        int pos = 0;
        while (pos < mesas.length && mesaDisponible == null) {
            if (mesas[pos].mesaDisponible()) {
                mesaDisponible = mesas[pos];
            }
            pos++;
        }

        return mesaDisponible;
    }

}
