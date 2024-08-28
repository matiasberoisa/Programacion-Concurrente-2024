package PC.TP2;

public class Cliente1 extends Thread {
    public void run() {
        System.out.println("soy" + Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        ;
    };
}