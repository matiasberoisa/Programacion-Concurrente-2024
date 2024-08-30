package PC.TP3;

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
            for (int i = 0; i < 3; i++) {
                this.realizarAtaque();
                Thread.sleep(3000);
            }
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
    }
}