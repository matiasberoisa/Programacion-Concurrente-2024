package parcialesRecuperatorios.Fabrica;

public class GrupoRueda implements Runnable {
    private Fabrica laFabrica;
    private int numero;

    public GrupoRueda(Fabrica laF, int num) {
        laFabrica = laF;
        numero = num;
    }

    public void run() {
        while (true) {
            try {
                laFabrica.entrarLineaRueda();
                if (!laFabrica.producirRueda()) {
                    System.out.println("el grupo de rueda N° " + numero + " produce una rueda");
                    Thread.sleep(2000);
                }
                laFabrica.salirLineaRueda();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
