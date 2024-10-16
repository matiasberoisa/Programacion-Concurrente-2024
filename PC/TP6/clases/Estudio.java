package TP6.clases;

public class Estudio {
    private Mesa[] mesas;

    public Estudio(Mesa[] mes) {
        mesas = mes;
    }

    public synchronized Mesa esperarMesa() throws InterruptedException {

        Mesa mesaDisponible = this.buscarMesa();
        if (mesaDisponible == null) {
            while (mesaDisponible == null) {
                wait();
            }
        }

        return mesaDisponible;
    }

    private synchronized Mesa buscarMesa() {
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

    public synchronized void notificar() {
        notifyAll();
    }
}
