package TP6.clases;

public class Mesa {
    private int numero;
    private boolean disponible;

    public Mesa(int num) {
        numero = num;
        disponible = true;
    }

    public void ocuparMesa() {
        disponible = false;
    }

    public void liberarMesa() {
        disponible = true;
    }

    public boolean mesaDisponible() {
        return this.disponible;
    }

    public int obtenerNumero() {
        return this.numero;
    }
}
