import java.util.concurrent.Semaphore;

public class Casa {
    private Semaphore comer;
    private Semaphore sentarse;
    private Semaphore avisar;
    private int bancosOcupados;

    public Casa() {
        comer = new Semaphore(0);
        avisar = new Semaphore(0);
        sentarse = new Semaphore(4);
        bancosOcupados = 0;
    }

    public void buscarBanco() {
        try {
            sentarse.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void servirComida() {
        comer.release();
    }

    public void ocuparBanco() {
        if (bancosOcupados == 0) {
            avisar.release();
        }
        bancosOcupados++;
    }

    public void comer() {
        try {
            comer.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void liberarBanco() {
        bancosOcupados--;
        sentarse.release();
    }

    public int hayBancosOcupados() {
        return this.bancosOcupados;
    }

    public void llevarComida() {
        try {
            avisar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
