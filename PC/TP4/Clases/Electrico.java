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
        this.llegaElectrico();
        System.out.println("el producto electrico n° " + this.numero + " termina el ensamblaje");
        elControlador.sale();
        elControlador.realizarCambio();
    }

    public void llegaElectrico() {
        try {
            elControlador.ocuparLineaEnsamblaje();
            System.out.println("se comienza a ensamblar el producto electrico n° " + this.numero);
            Thread.sleep(3000);
            elControlador.liberarLineaEnsamblaje();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
