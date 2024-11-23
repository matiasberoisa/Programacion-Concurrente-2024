package parcialesRecuperatorios.Fabrica;

public class GrupoPuerta implements Runnable {
    private Fabrica laFabrica;
    private int numero;

    public GrupoPuerta(Fabrica laF, int num) {
        laFabrica = laF;
        numero = num;
    }

    public void run() {
        while (true) {
            try {
                laFabrica.entrarLineaPuerta();
                if (!laFabrica.producirPuerta()) {
                    System.out.println("el grupo de puerta N° " + numero + " produce una puerta");
                    Thread.sleep(3000);
                }
                laFabrica.salirLineaPuerta();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
