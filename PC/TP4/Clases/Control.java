package Clases;

public class Control implements Runnable {
    private ControladorProduccion elControlador;

    public Control(ControladorProduccion contr) {
        this.elControlador = contr;
    }

    public void run() {
        while (true) {
            elControlador.controlar();
            System.out.println("CAMBIO DE LINEA, NORTE A OESTE");
            elControlador.cambiaLineas("Mecanico");
            elControlador.controlar();
            System.out.println("CAMBIO DE LINEA, OESTE A NORTE");
            elControlador.cambiaLineas("Electrico");
        }
    }
}
