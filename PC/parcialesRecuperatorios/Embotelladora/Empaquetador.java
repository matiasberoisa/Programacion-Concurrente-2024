package parcialesRecuperatorios.Embotelladora;

public class Empaquetador implements Runnable {
    private Fabrica laFabrica;

    public Empaquetador(Fabrica laF) {
        laFabrica = laF;
    }

    public void run() {
        try {
            while (true) {
                laFabrica.cambiarCaja();
                System.out.println("el empaquetador retira la caja");
                Thread.sleep(3000);
                System.out.println("el empaquetador repone la caja");
                laFabrica.habilitarEmbotellador();
            }
        } catch (Exception e) {
        }
    }
}
