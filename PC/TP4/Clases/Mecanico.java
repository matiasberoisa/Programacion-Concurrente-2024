package Clases;

public class Mecanico extends Producto implements Runnable {
    private int numero;
    private ControladorProduccion elControlador;

    public Mecanico(ControladorProduccion elCon, int num) {
        super("Mecanico");
        elControlador = elCon;
        numero = num;
    }

    public void run() {
        System.out.println("el producto mecanico n° " + this.numero + " entra a la linea de ensamblaje");

    }

    public void llegaMecanico() {

    }
}
