package TP8.clases.ej5;

public class Cocinero implements Runnable {
    private Olla laOlla;

    public Cocinero(Olla laO) {
        laOlla = laO;
    }

    public void run() {
        try {
            System.out.println("el cocinero cocina la primera racion y se va a dormir");
            while (true) {
                laOlla.cocinar();
                System.out.println("el cocinero se despierta y cocina una nueva tanda");
                Thread.sleep(3000);
                System.out.println("el cocinero termina de cocinar y se va a dormir");
                laOlla.servir();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
