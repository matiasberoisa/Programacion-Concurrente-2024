package PC.TP3.Clases;

public class Energia implements Runnable {
    private int energia = 10;

    public Energia() {
    }

    public int getEnergia() {
        return this.energia;
    }

    public void cambiarEnergia(int valor) {
        this.energia += valor;
    }

    public void realizarAtaque() {
        synchronized (this) {
            int poder;
            if (Thread.currentThread().getName().equals("la Criatura Oscura")) {
                poder = -3;
                System.out.println(
                        Thread.currentThread().getName() + " ha drenado " + poder + " unidades de energia");
            } else {
                poder = 3;
                System.out.println(
                        Thread.currentThread().getName() + " revitaliza " + poder + " unidades de energia");
            }
            this.cambiarEnergia(poder);
            System.out.println("energia restante: " + this.getEnergia());
        }
    }

    public void run() {
        try {
            this.realizarAtaque();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Energia energia = new Energia();
        Thread hilo1 = new Thread(energia, "la Criatura Oscura");
        Thread hilo2 = new Thread(energia, "el Sanador");
        System.out.println("comienza la secuencia de energia");
        hilo1.start();
        hilo1.join();
        hilo2.start();
        hilo2.join();
        /*
         * Energia energia = new Energia();
         * Thread[] hilo1 = new Thread[3];
         * Thread[] hilo2 = new Thread[3];
         * System.out.println("comienza la secuencia de energia");
         * for (int i = 0; i < 3; i++) {
         * Thread hiloCriatura = new Thread(energia, "la Criatura Oscura");
         * Thread hiloSanador = new Thread(energia, "el Sanador");
         * hilo1[i] = hiloCriatura;
         * hilo2[i] = hiloSanador;
         * }
         * for (int i = 0; i < 3; i++) {
         * hilo1[i].start();
         * hilo1[i].join();
         * hilo2[i].start();
         * hilo2[i].join();
         * }
         */
    }
}