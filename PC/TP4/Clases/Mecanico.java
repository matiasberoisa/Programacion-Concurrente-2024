package Clases;

public class Mecanico extends Producto implements Runnable {
    private ControladorProduccion elControlador;
    private boolean ensamblado = false;

    public Mecanico(ControladorProduccion elCon, int num) {
        super("Mecanico", num);
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
