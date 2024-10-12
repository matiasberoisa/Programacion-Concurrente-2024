package Clases;

public class Mecanico extends Producto implements Runnable {
    private ControladorProduccion elControlador;

    public Mecanico(ControladorProduccion elCon, int num) {
        super("Mecanico", num);
        elControlador = elCon;
    }

    public void run() {
        elControlador.puedeIngresar(this);
    }
}
