package PC.TP2;

import java.util.ArrayList;

public class CajeroRunnable implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    // Constructor, y métodos de acceso

    public CajeroRunnable(String nn, Cliente cli, long it) {
        nombre = nn;
        cliente = cli;
        initialTime = it;
    }

    public void run() {
        System.out.println("El cajero " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println(
                    "Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + "->Tiempo: " +
                            (System.currentTimeMillis() - this.initialTime) / 1000
                            + "seg");
        }
        System.out.println(
                "El cajero " + this.nombre + " HA TERMINADO DE PROCESAR" + this.cliente.getNombre() + " EN EL TIEMPO: "
                        +
                        (System.currentTimeMillis() - this.initialTime) / 1000 +
                        "seg");
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        ArrayList<Thread> cajeroHilos = new ArrayList<Thread>();
        Cliente[] clientes = new Cliente[2];
        clientes[0] = cliente1;
        clientes[1] = cliente2;
        long initialTime = System.currentTimeMillis();
        for (int i = 0; i < clientes.length; i++) {

            CajeroRunnable cajero = new CajeroRunnable("Cajero #" + (i + 1), clientes[i], initialTime);
            Thread hiloCajero = new Thread(cajero);
            cajeroHilos.add(hiloCajero);
        }
        cajeroHilos.forEach(caj -> caj.start());

    }

    public void esperarXsegundos(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}