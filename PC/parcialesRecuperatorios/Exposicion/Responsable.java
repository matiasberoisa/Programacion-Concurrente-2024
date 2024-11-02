package parcialesRecuperatorios.Exposicion;

public class Responsable implements Runnable {
    private int numero;
    private Sala laSala;

    public Responsable(int num, Sala laS) {
        numero = num;
        laSala = laS;
    }

    public void run() {
        try {
            laSala.entraResponsable();
            System.out.println("el responsable N° " + this.numero + " entra a la sala. responsable dentro: "
                    + laSala.responsablesDentro());
            Thread.sleep(3000);
            System.out.println("el responsable N° " + this.numero + " sale de la sala");
            laSala.saleResponsable();
        } catch (Exception e) {

        }
    }
}
