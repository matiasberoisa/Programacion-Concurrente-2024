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
        this.llegaMecanico();
        System.out.println("el producto mecanico n° " + this.numero + " termina el ensamblaje");
        elControlador.sale();
        elControlador.realizarCambio();
    }

    public void llegaMecanico() {
        try {
            elControlador.ocuparLineaEnsamblaje();
            System.out.println("se comienza a ensamblar el producto Mecanico n° " + this.numero);
            Thread.sleep(3000);
            elControlador.liberarLineaEnsamblaje();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
