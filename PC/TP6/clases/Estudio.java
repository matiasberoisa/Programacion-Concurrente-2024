package TP6.clases;

public class Estudio {
    private Mesa[] mesas;
    private boolean puedoEntrar = true;

    public Estudio(Mesa[] mes) {
        mesas = mes;
    }

    public synchronized Mesa esperarMesa() throws InterruptedException {
        Mesa mesaDisponible = null;
        this.usarMesa();
        if (!puedoEntrar) {
            while (!puedoEntrar) {
                wait();
            }
        }
        mesaDisponible = this.buscarMesa();
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

    public void usarMesa() {
        int pos = 0;
        boolean encontrado = false;
        while (pos < mesas.length && !encontrado) {
            if (mesas[pos].mesaDisponible()) {
                encontrado = true;
            }
            pos++;
        }
        puedoEntrar = encontrado;
    }

    public synchronized void habilitarMesa() {
        puedoEntrar = true;
        notify();
    }
}
