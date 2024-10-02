package PC.TP5.clases;

public class Cocinero implements Runnable {
    private Confiteria laConfiteria;

    public Cocinero(Confiteria laC) {
        laConfiteria = laC;
    }

    public void run() {
        System.out.println("el cocinero empieza a trabajar");
        while (true) {
            laConfiteria.atender();
            realizarOrden();
            laConfiteria.vigilarCocinero();
            ordenarCocina();
            laConfiteria.habilitarMesa();
        }
    }

    public void ordenarCocina() {
        System.out.println("el cocinero ordena la cocina");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void realizarOrden() {
        String orden = "";
        try {
            orden = laConfiteria.obtenerOrdenComida();
            System.out.println("el cocinero prepara " + orden);
            Thread.sleep(3000);
            System.out.println("el cocinero lleva " + orden);
            laConfiteria.llevarPedido();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
