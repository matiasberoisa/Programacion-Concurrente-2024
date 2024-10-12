package Clases;

public class Electrico extends Producto implements Runnable {
    private ControladorProduccion elControlador;

    public Electrico(ControladorProduccion elCon, int num) {
        super("Electrico", num);
        elControlador = elCon;
    }

    public void run() {
        elControlador.puedeIngresar(this);
    }

}
