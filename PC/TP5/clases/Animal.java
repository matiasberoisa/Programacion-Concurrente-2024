package PC.TP5.clases;

public class Animal {

    private String nombre;
    private int numero;

    public Animal(String nn, int n) {
        nombre = nn;
        numero = n;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getNumero() {
        return this.numero;
    }
}
