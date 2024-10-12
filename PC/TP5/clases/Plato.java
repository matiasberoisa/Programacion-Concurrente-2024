package TP5.clases;

public class Plato {
    private int numero;
    private int cantidad = 0;
    private int limite;
    private String IngresoUltimo = "";

    public Plato(int nn) {
        numero = nn;
        limite = 5;
    }

    public void entraAComer() {
        cantidad++;
    }

    public void saleDeComer() {
        cantidad--;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public String quienIngreso() {
        return this.IngresoUltimo;
    }

    public int getLimite() {
        return this.limite;
    }
}
