package parcialesRecuperatorios.Fabrica;

public class GrupoEnsamblador implements Runnable {
    private Fabrica laFabrica;

    public GrupoEnsamblador(Fabrica laF) {
        laFabrica = laF;
    }

    public void run() {
        while (true) {
            try {
                laFabrica.ensamblar();
                System.out.println("el grupo ensamblador fabrica un auto");
                Thread.sleep(3000);
                if (laFabrica.empaquetar()) {
                    System.out.println("el grupo ensamblador empaqueta los 5 autos y los envia");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
