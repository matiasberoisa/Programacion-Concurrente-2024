package PC.TP3;

public class Hamaca implements Runnable {
    private boolean enUso;

    public Hamaca() {
    }

    public void run() {
        if (!enUso) {
            enUso = true;
            System.out.println(Thread.currentThread().getName() + " usa la hamaca");
            synchronized (this) {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.print(". ");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println();
                System.out.println("la hamaca fue desocupada");
            }
            enUso = false;
        } else {
            System.out.println("la hamaca esta ocupada.");
        }
    }
}