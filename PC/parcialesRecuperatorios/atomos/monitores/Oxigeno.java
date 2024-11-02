package parcialesRecuperatorios.atomos.monitores;

public class Oxigeno implements Runnable {
    private String atomo;
    private Recipiente elRecipiente;

    public Oxigeno(Recipiente elR) {
        atomo = "Oxigeno";
        elRecipiente = elR;
    }

    public void run() {
        try {
            elRecipiente.prepararOxigeno();
            System.out.println("un atomo de " + atomo + " esta listo");
            Thread.sleep(3000);
            elRecipiente.oxigenoListo();
            if (elRecipiente.OListo() && elRecipiente.Hlisto()) {
                elRecipiente.hacerAgua();
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
