package PC.TP3.Clases;

import java.util.Random;

public class Auto implements Runnable {
    private String patente;
    private int modelo;
    private String marca;
    private int km;
    private int cantLitro;
    private Surtidor unSurtidor;
    private Random random = new Random();

    public Auto(String pa, int mo, String ma, int k, Surtidor unSur) {
        patente = pa;
        modelo = mo;
        marca = ma;
        km = k;
        cantLitro = random.nextInt(1, 5);
        unSurtidor = unSur;
    }

    public void conducir() {
        try {
            this.cantLitro -= 1;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void llenarTanque(int litros) {
        cantLitro = litros;
    }

    public int getLitros() {
        return this.cantLitro;
    }

    public String getPatente() {
        return this.patente;
    }

    public String toString() {
        return "| patente: " + this.patente + " | modelo: " + this.modelo + " | marca: " + this.marca + " | km: "
                + this.km + " | cantLitro: " + this.cantLitro
                + " |";
    }

    public void run() {
        System.out.println("el auto " + this.toString() + " empieza a circular");
        int litros = cantLitro;
        while (cantLitro > 0) {
            this.conducir();
        }
        unSurtidor.cargarAuto(this, litros);
    }
}
