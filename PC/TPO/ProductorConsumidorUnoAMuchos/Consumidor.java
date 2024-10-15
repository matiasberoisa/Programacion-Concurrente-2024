package ProductorConsumidorUnoAMuchos;

public class Consumidor implements Runnable {
    private int numCliente;
    private Buffer rc;

    public Consumidor(Buffer rc, int nc) {
        this.rc = rc;
        numCliente = nc;
    }

    @Override
    public void run() {
        while (true) {
            try {
                rc.consumir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int getNum() {
        return this.numCliente;
    }
}
