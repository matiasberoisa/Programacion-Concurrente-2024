package PC.TP3;

public class Rueda implements Runnable {
    private boolean enUso;

    public Rueda() {
    }

    public void run() {
        String cadena = "";
        if (!enUso) {
            enUso = true;
            System.out.println(Thread.currentThread().getName() + " usa la rueda");
            synchronized (this) {
                try {
                    for (int i = 0; i < 5; i++) {
                        cadena = ". ";
                        System.out.print(cadena);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println();
                System.out.println("la rueda fue desocupada");
            }
            enUso = false;
        } else {
            System.out.println("la rueda esta ocupada.");
        }
    }
}
