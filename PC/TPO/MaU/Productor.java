package MaU;

public class Productor implements Runnable {
    private String id;
    private Buffer almacen;

    public Productor(String i, Buffer unAlmacen) {
        this.id = i;
        this.almacen = unAlmacen;
    }

    public void run() {
        while (true) {
            while (this.almacen.topeBuffer() <= this.almacen.cantElemDisponibles()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }
            }

            try {
                this.almacen.empezarProducir();
                this.almacen.terminarProducir();
            } catch (InterruptedException var3) {
                var3.printStackTrace();
            }
        }
    }

    public String getId() {
        return this.id;
    }
}
