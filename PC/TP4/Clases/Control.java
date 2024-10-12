package Clases;

public class Control implements Runnable {
    private ControladorProduccion elControlador;

    public Control(ControladorProduccion contr) {
        this.elControlador = contr;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                elControlador.cambiarLinea("Mecanico");
                System.out.println("////////////////////CAMBIO DE LINEA, NORTE A OESTE////////////////////");
                Thread.sleep(10000);
                elControlador.cambiarLinea("Electrico");
                System.out.println("////////////////////CAMBIO DE LINEA, OESTE A NORTE////////////////////");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
