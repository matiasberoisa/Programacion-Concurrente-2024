package parcialesRecuperatorios.atomos.monitores;

public class Hidrogeno implements Runnable {
    private String atomo;
    private Recipiente elRecipiente;

    public Hidrogeno(Recipiente elR) {
        atomo = "Hidrogeno";
        elRecipiente = elR;
    }

    public void run() {
        try {
            elRecipiente.prepararHidrogeno(this);
            System.out.println("un atomo de " + atomo + " esta listo");
            Thread.sleep(3000);
            elRecipiente.hidrogenoListo();
            if (elRecipiente.OListo() && elRecipiente.Hlisto()) {
                elRecipiente.hacerAgua();
                System.out.println("se ha formado agua. recipiente: " + elRecipiente.cantRecipiente());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAtomo() {
        return this.atomo;
    }
}
