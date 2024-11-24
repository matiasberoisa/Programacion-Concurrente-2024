package parcialesRecuperatorios.atomos.semaforos;

public class Oxigeno implements Runnable {
    private String atomo;
    private Recipiente elRecipiente;

    public Oxigeno(Recipiente elR) {
        atomo = "Oxigeno";
        elRecipiente = elR;
    }

    public void run() {
        boolean hizoAgua = false;
        try {
            elRecipiente.entraOxigeno();
            System.out.println("una molecula de " + atomo + " esta lista");
            Thread.sleep(3000);
            hizoAgua = elRecipiente.hacerAgua();
            if (hizoAgua) {
                System.out.println("se ha formado agua.");
                System.out.println("agua en el recipiente: " + elRecipiente.cantRecipiente());
                Thread.sleep(3000);
                if (elRecipiente.vaciarRecipiente()) {
                    System.out.println("se vacio el recipiente");
                }
            }
            elRecipiente.dejarRecipiente();
            elRecipiente.terminarEjecucion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
