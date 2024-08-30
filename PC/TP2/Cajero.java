package PC.TP2;

public class Cajero {
    private String nombre;

    public Cajero(String nn) {
        nombre = nn;
    }

    // Agregar Constructor, y métodos de acceso
    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
                    "->Tiempo: " + (System.currentTimeMillis() - timeStamp) /
                            1000
                    + "seg");
        }
        System.out.println(
                "El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +
                        (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        Cajero cajero1 = new Cajero("Cajero 1");
        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
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
