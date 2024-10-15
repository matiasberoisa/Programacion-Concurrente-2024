package TP6.clases;

public class Estudiante implements Runnable {
    private int numero;
    private Mesa[] mesas;

    public Estudiante(int num, Mesa[] me) {
        numero = num;
        mesas = me;
    }

    public void run() {

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
