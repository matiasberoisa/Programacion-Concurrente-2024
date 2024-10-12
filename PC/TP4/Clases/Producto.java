package Clases;

public class Producto {
    private int numero;
    private String tipo;

    public Producto(String ti, int num) {
        tipo = ti;
        numero = num;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getNumero() {
        return this.numero;
    }
}
