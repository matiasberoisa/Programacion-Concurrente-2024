package parcialesRecuperatorios.Exposicion;

public class Visitante implements Runnable {
    private int numero;
    private Sala laSala;

    public Visitante(int num, Sala laS) {
        numero = num;
        laSala = laS;
    }

    public void run() {
        try {
            laSala.entraVisitante();
            System.out.println("el visitante N° " + this.numero + " entra a la sala. visitantes dentro: "
                    + laSala.visitantesDentro());
            Thread.sleep(3000);
            System.out.println("el visitante N° " + this.numero + " sale de la sala");
            laSala.saleVisitante();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
