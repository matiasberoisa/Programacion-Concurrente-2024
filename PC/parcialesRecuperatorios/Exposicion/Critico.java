package parcialesRecuperatorios.Exposicion;

public class Critico implements Runnable {
    private int numero;
    private Sala laSala;

    public Critico(int num, Sala laS) {
        numero = num;
        laSala = laS;
    }

    public void run() {
        try {
            laSala.entraCritico();
            System.out.println(
                    "el critico N° " + this.numero + " entra a la sala. criticos dentro: " + laSala.criticosDentro());
            Thread.sleep(3000);
            System.out.println(
                    "el critico N° " + this.numero + " sale de la sala");
            laSala.saleCritico();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
