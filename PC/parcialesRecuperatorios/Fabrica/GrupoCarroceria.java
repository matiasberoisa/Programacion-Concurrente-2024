package parcialesRecuperatorios.Fabrica;

public class GrupoCarroceria implements Runnable {
    private Fabrica laFabrica;
    private int numero;

    public GrupoCarroceria(Fabrica laF, int num) {
        laFabrica = laF;
        numero = num;
    }

    public void run() {
        while (true) {
            try {
                laFabrica.entrarLineaCarroceria();
                if (!laFabrica.producirCarroceria()) {

                    System.out.println("el grupo de carroceria N° " + numero + " produce una carroceria");
                    Thread.sleep(5000);
                }
                laFabrica.salirLineaCarroceria();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
