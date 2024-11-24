package parcialesRecuperatorios.atomos.semaforos;

public class Hidrogeno implements Runnable {
    private String atomo;
    private Recipiente elRecipiente;
    private int numero;

    public Hidrogeno(Recipiente elR, int num) {
        atomo = "Hidrogeno";
        elRecipiente = elR;
        numero = num;
    }

    public void run() {
        boolean hizoAgua = false;
        try {
            elRecipiente.entraHidrogeno();
            System.out.println("la molecula " + numero + " de " + atomo + " esta lista");
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
