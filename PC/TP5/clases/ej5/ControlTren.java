package TP5.clases.ej5;

public class ControlTren implements Runnable {
    private Tren elTren;

    public ControlTren(Tren elT) {
        elTren = elT;
    }

    public void run() {
        while (true) {
            try {
                elTren.cerrarPuertas();
                System.out.println("el tren cierra las puertas y realiza el viaje");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
