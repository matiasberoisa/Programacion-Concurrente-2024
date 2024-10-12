package PC.TP6.clases;

public class Coche implements Runnable {
    private int numero;
    private String direccion;
    private Carril puente;
    private boolean cruzo = false;

    public Coche(int num, String dir, Carril pu) {
        numero = num;
        direccion = dir;
        puente = pu;
    }

    public void run() {
        System.out.println("el coche " + this.numero + " aparece en el puente desde el " + this.direccion);
        while (!cruzo) {
            if (direccion.equals("Norte")) {
                if (!puente.puedeCruzarNorte()) {
                    puente.circular();
                    System.out.println("avanza el coche " + this.numero + " por el " + this.direccion);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    puente.liberar();
                    cruzo = true;
                }
            }
            if (direccion.equals("Sur")) {
                if (!puente.puedeCruzarSur()) {
                    puente.circular();
                    System.out.println("avanza el coche " + this.numero + " por el " + this.direccion);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    puente.liberar();
                    cruzo = true;
                }
            }
        }
    }
}
