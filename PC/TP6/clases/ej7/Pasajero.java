package TP6.clases.ej7;

public class Pasajero implements Runnable {
    private int numero;
    private Barco elBarco;
    private int espacioNecesario;

    public Pasajero(int num, Barco barco) {
        numero = num;
        elBarco = barco;
        espacioNecesario = 1;
    }

    public void run() {
        try {
            elBarco.subirPasajero();
            System.out.println("el pasajero " + this.numero + " sube al barco");
            elBarco.pasajeroAAuto();
            elBarco.bajarPasajero();
            System.out.println("el pasajero " + this.numero + " baja del barco");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int espaciousado() {
        return this.espacioNecesario;
    }
}
