package TPO.MaU;

public class Buffer {
    private Elemento[] elementos;
    private int cantidadElementosListos;
    private boolean listoC;
    private boolean listoP;

    public Buffer(int var1) {

    }

    public synchronized void empezarProducir() throws InterruptedException {
        while (!listoP) {
            wait();
        }
    }

    public void terminarProducir() throws InterruptedException {
        listoC = true;
        listoP = false;
        notifyAll();
    }

    public synchronized void empezarConsumir() throws InterruptedException {
        while (!listoC) {
            wait();
        }
    }

    public void terminarConsumir() {
        listoC = false;
        listoP = true;
        notifyAll();
    }

    public synchronized Boolean getEstadoP() {
        return this.listoP;
    }

    public int cantElemDisponibles() {
        return this.cantidadElementosListos;
    }

    public int topeBuffer() {
        return this.elementos.length;
    }
}
