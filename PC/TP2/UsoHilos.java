package PC.TP2;

public class UsoHilos {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        // Primero, construye un objeto unHilo.
        //unHilo mh=new unHilo("#1");
        Hilo hilo1 = new Hilo("#1");
        Hilo hilo2 = new Hilo("#2");
        Hilo hilo3 = new Hilo("#3");
        // Luego, construye un hilo de ese objeto.
        //Thread nuevoHilo=new Thread(mh);
        // Finalmente, comienza la ejecución del hilo.
        hilo1.start();
        hilo2.start();
        hilo3.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
        // el main termina antes que el run(), ya que primero se termina de ejecutar el
        // hilo
        // del main y luego se ejecuta el hilo creado de la clase
    }
}
