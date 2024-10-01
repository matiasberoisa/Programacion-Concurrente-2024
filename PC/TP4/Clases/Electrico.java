package Clases;

public class Electrico extends Producto implements Runnable {
    private ControladorProduccion elControlador;
    private int numero;
    private boolean entroHilo = false;

    public Electrico(ControladorProduccion elCon, int num) {
        super("Electrico");
        elControlador = elCon;
        numero = num;
    }

    public void run() {
        try {
            while (!entroHilo) {
                if (elControlador.puedeIngresarElectrico()) {
                    this.llegaElectrico();
                    System.out.println("el producto electrico n° " + this.numero + " entra a la linea de ensamblaje");
                    Thread.sleep(1000);
                    this.ensamblar();
                    System.out.println(
                            "el producto electrico n° " + this.numero + " termina el ensamblaje y sale de la linea");
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

    public void llegaElectrico() {
        elControlador.ocuparLineaEnsamblaje();
    }

    public void ensamblar() {
        try {
            System.out.println("se comienza a ensamblar el producto electrico n° " + this.numero);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
