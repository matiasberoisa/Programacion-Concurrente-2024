package TP5.clases;

public class Perro extends Animal implements Runnable {
    private Comedor elComedor;

    public Perro(int n, Comedor elC) {
        super("Perro", n);
        elComedor = elC;
    }

    public void run() {
        elComedor.buscarPlato(this);
    }

    public void comer() {
        System.out.println(this.getNombre() + " " + this.getNumero() + " empieza a comer");

    }
}
