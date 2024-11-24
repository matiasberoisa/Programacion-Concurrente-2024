package Clases;

public class Electrico extends Producto implements Runnable {
    private ControladorProduccion elControlador;
    private boolean ensamblado = false;

    public Electrico(ControladorProduccion elCon, int num) {
        super("Electrico", num);
        elControlador = elCon;
    }

    public void run() {
        while (!ensamblado) {
            if (elControlador.puedeIngresar(this)) {
                ensamblado = true;
            }
        }

    }

}
