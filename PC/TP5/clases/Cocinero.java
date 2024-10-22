package TP5.clases;

public class Cocinero implements Runnable {
    private Confiteria laConfiteria;

    public Cocinero(Confiteria laC) {
        laConfiteria = laC;
    }

    public void run() {
        System.out.println("el cocinero empieza a trabajar");
        while (true) {
            laConfiteria.trabajar();
            if (laConfiteria.mesa1ocupada() == false && laConfiteria.obtenerOrdenComida(1) != null) {
                System.out.println("//////////MESA 1//////////");
                laConfiteria.cocinar();
                realizarOrden(1);
                laConfiteria.llevarPedidoMesa1();
                laConfiteria.vigilarCocinero();
                ordenarCocina();
            }
            if (laConfiteria.mesa2ocupada() == false && laConfiteria.obtenerOrdenComida(2) != null) {
                System.out.println("//////////MESA 2//////////");
                laConfiteria.cocinar();
                realizarOrden(2);
                laConfiteria.llevarPedidoMesa2();
                laConfiteria.vigilarCocinero();
                ordenarCocina();
            }
        }
    }

    public void ordenarCocina() {
        System.out.println("el cocinero ordena la cocina");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        laConfiteria.habilitarMesa();
    }

    public void realizarOrden(int mesa) {
        String orden = "";
        try {
            orden = laConfiteria.obtenerOpcionComida(mesa);
            System.out.println("el cocinero prepara " + orden);
            Thread.sleep(3000);
            System.out.println("el cocinero lleva " + orden);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
