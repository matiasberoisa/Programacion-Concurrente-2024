package PC.TP3;

public class Plato implements Runnable {
    private boolean enUso;

    public Plato() {
    }

    public void run() {
        String cadena = "";
        if (!enUso) {
            enUso = true;
            System.out.println(Thread.currentThread().getName() + " usa el plato");
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
                System.out.println("el plato fue desocupado");
            }
            enUso = false;
        } else {
            System.out.println("el plato esta ocupado.");
        }
    }
}
