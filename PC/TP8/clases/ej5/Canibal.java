package TP8.clases.ej5;

public class Canibal implements Runnable {
    private int numero;
    private Olla laOlla;

    public Canibal(int num, Olla laO) {
        numero = num;
        laOlla = laO;
    }

    public void run() {
        try {
            laOlla.entrarFila();
            System.out.println("el canibal " + this.numero + " se acerca a la olla");
            Thread.sleep(1000);
            if (laOlla.quedanRaciones()) {
                laOlla.comer();
                System.out.println("el canibal " + this.numero + " toma una racion");
            } else {
                System.out.println("no quedan raciones");
                System.out.println("el canibal " + this.numero + " despierta al cocinero");
                laOlla.despertarCocinero();
                laOlla.comer();
                System.out.println("el canibal " + this.numero + " toma una racion");
            }
            Thread.sleep(1000);
            laOlla.dejarFila();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
