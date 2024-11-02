package parcialesRecuperatorios.atomos.locks;

public class Hidrogeno implements Runnable {
    private String atomo;
    private Recipiente elRecipiente;

    public Hidrogeno(Recipiente elR) {
        atomo = "Hidrogeno";
        elRecipiente = elR;
    }

    public void run() {
        try {
            elRecipiente.prepararHidrogeno();
            System.out.println("un atomo de " + atomo + " esta listo");
            Thread.sleep(3000);
            elRecipiente.hidrogenoListo();
            if (elRecipiente.OListo() && elRecipiente.Hlisto()) {
                elRecipiente.hacerAgua();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
