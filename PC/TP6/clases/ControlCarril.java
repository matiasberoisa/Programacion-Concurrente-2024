package PC.TP6.clases;

public class ControlCarril implements Runnable {
    private Carril puente = new Carril();

    public ControlCarril() {

    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(4000);
                puente.norteASur();
                System.out.println("//////////cambio de carril, norte a sur//////////");
                Thread.sleep(4000);
                puente.surANorte();
                System.out.println("//////////cambio de carril, sur a norte//////////");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
