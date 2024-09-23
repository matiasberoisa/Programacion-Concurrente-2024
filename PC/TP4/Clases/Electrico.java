package Clases;

public class Electrico extends Producto implements Runnable {
    private ControladorProduccion elControlador;
    private int numero;

    public Electrico(ControladorProduccion elCon, int num) {
        super("Electrico");
        elControlador = elCon;
        numero = num;
    }

    public void run() {
        System.out.println("el producto electrico n° " + this.numero + " entra a la linea de ensamblaje");
    }

    public void llegaElectrico() {

    }
}
