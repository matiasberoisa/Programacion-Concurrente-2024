package Clases;

public class Mecanico extends Producto implements Runnable {
    private int numero;
    private ControladorProduccion elControlador;
    private boolean entroHilo = false;

    public Mecanico(ControladorProduccion elCon, int num) {
        super("Mecanico");
        elControlador = elCon;
        numero = num;
    }

    public void run() {
        try {
            while (!entroHilo) {
                if (elControlador.puedeIngresarMecanico()) {
                    this.llegaMecanico();
                    System.out.println("el producto mecanico n° " + this.numero + " entra a la linea de ensamblaje");
                    Thread.sleep(1000);
                    this.ensamblar();
                    System.out.println(
                            "el producto mecanico n° " + this.numero + " termina el ensamblaje y sale de la linea");
                    elControlador.contarProducto();
                    elControlador.realizarCambio();
                    elControlador.sale();
                    entroHilo = true;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void llegaMecanico() {
        elControlador.ocuparLineaEnsamblaje();
    }

    public void ensamblar() {
        try {
            System.out.println("se comienza a ensamblar el producto mecanico n° " + this.numero);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
