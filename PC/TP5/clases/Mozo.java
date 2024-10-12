package TP5.clases;

public class Mozo implements Runnable {
    private Confiteria laConfiteria;

    public Mozo(Confiteria c) {
        laConfiteria = c;
    }

    public void run() {
        System.out.println("el mozo comienza a trabajar");
        while (true) {
            laConfiteria.atender();
            realizarOrden();
            laConfiteria.vigilarMozo();
            descansar();
            laConfiteria.habilitarMesa();
        }
    }

    public void realizarOrden() {
        String orden = "";
        try {
            orden = laConfiteria.obtenerOrdenBebida();
            System.out.println("el mozo prepara " + orden);
            Thread.sleep(3000);
            System.out.println("el mozo lleva " + orden);
            laConfiteria.llevarPedido();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void descansar() {
        System.out.println("el mozo descansa y busca inventar nuevas versiones de pollo");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
