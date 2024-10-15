package MaM;

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
            this.almacen.consumir();
        }
    }

    public String getId() {
        return this.id;
    }
}
