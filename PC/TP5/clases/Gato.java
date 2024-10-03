package PC.TP5.clases;

public class Gato extends Animal implements Runnable {
    private Comedor elComedor;

    public Gato(int n, Comedor elC) {
        super("Gato", n);
        elComedor = elC;
    }

    public void run() {
        elComedor.buscarPlato(this);
    }

    public void comer() {
        System.out.println(this.getNombre() + " " + this.getNumero() + " empieza a comer");

    }
}
