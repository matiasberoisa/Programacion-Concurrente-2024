package MaU;

public class Consumidor implements Runnable {
    private String id;
    private Buffer almacen;

    public Consumidor(String i, Buffer unAlmacen) {
        this.id = i;
        this.almacen = unAlmacen;
    }

    public void run() {
        while (true) {
            while (this.almacen.cantElemDisponibles() <= 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException var3) {
                    var3.printStackTrace();
                }
            }

            try {
                this.almacen.empezarConsumir();
                this.almacen.terminarConsumir();
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }
        }
    }

    public String getId() {
        return this.id;
    }
}
