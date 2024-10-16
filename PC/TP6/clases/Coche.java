package TP6.clases;

public class Coche implements Runnable {
    private int numero;
    private String direccion;
    private Carril puente;

    public Coche(int num, String dir, Carril pu) {
        numero = num;
        direccion = dir;
        puente = pu;
    }

    public void run() {
        if (direccion.equals("Norte")) {
            try {
                puente.EntrarCocheDelNorte(this);
                System.out.println("avanza por el norte el auto " + this.numero);
                Thread.sleep(3000);
                puente.salirCocheDelNorte();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                puente.EntrarCocheDelSur(this);
                System.out.println("avanza por el sur el auto " + this.numero);
                Thread.sleep(3000);
                puente.salirCocheDelSur();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDireccion() {
        return this.direccion;
    }

    public int getNumero() {
        return this.numero;
    }
}
