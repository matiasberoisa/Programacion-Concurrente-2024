package TP6.clases.ej7;

public class Auto implements Runnable {
    private int numero;
    private Barco elBarco;
    private int espacioNecesario;

    public Auto(int num, Barco barco) {
        numero = num;
        elBarco = barco;
        espacioNecesario = 4;
    }

    public void run() {
        try {
            elBarco.subirAuto();
            System.out.println("el auto " + this.numero + " sube al barco");
            elBarco.autoAPasajero();
            elBarco.bajarAuto();
            System.out.println("el auto " + this.numero + " baja del barco");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int espaciousado() {
        return this.espacioNecesario;
    }
}
