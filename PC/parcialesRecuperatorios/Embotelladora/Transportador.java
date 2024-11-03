package parcialesRecuperatorios.Embotelladora;

public class Transportador implements Runnable {
    private Fabrica laFabrica;

    public Transportador(Fabrica laF) {
        laFabrica = laF;
    }

    public void run() {
        try {
            while (true) {
                laFabrica.transportarCaja();
                System.out.println("el transportador se lleva las cajas");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
        }
    }

}
