package PC.TP2;

public class Cliente {
    private String nombre;
    private int[] carroCompra;

    // Constructor y métodos de acceso
    public Cliente(String nn, int[] cc) {
        nombre = nn;
        carroCompra = cc;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int[] getCarroCompra() {
        return this.carroCompra;
    }
}
