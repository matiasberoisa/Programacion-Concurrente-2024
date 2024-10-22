package TP5.clases;

public class Mozo implements Runnable {
    private Confiteria laConfiteria;

    public Mozo(Confiteria c) {
        laConfiteria = c;
    }

    public void run() {
        System.out.println("el mozo comienza a trabajar");
        while (true) {
            laConfiteria.trabajar();
            if (laConfiteria.mesa1ocupada() == false && laConfiteria.obtenerOrdenBebida(1) != null) {
                System.out.println("//////////MESA 1//////////");
                laConfiteria.atender();
                realizarOrden(1);
                laConfiteria.llevarPedidoMesa1();
                laConfiteria.vigilarMozo();
                descansar();
            }
            if (laConfiteria.mesa2ocupada() == false && laConfiteria.obtenerOrdenBebida(2) != null) {
                System.out.println("//////////MESA 2//////////");
                laConfiteria.atender();
                realizarOrden(2);
                laConfiteria.llevarPedidoMesa2();
                laConfiteria.vigilarMozo();
                descansar();
            }
        }
    }

    public void realizarOrden(int mesa) {
        String orden = "";
        try {
            orden = laConfiteria.obtenerOpcionBebida(mesa);
            System.out.println("el mozo prepara " + orden);
            Thread.sleep(3000);
            System.out.println("el mozo lleva " + orden);
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
        laConfiteria.habilitarMesa();
    }

}
